extern crate arrow;
extern crate parquet;

use std::error::Error;
use std::fs::File;
use std::sync::Arc;

use arrow::array::{ArrayRef, Int32Array, Int8Array};
use arrow::compute::{add, cast};
use arrow::datatypes::{DataType, Field, Schema};
use arrow::record_batch::RecordBatch;

// Scenario - add two columns of different types and write the 3 to csv and parquet
//
// where
// - xs: i32 array
// - ys: i8 array
// - zs: xs + ys
//
// outputs
// - out/simple.csv
// - out/parquet.csv
//
// improvements
// - can we keep a reference to the primitive arrays?
// - use error libraries to see how it goes with arrow and remove unwraps/excepts
//
fn main() -> Result<(), Box<dyn Error>> {
    // a simple definition of a i32 and i8 arrays
    let xs: ArrayRef = Arc::new(Int32Array::from(vec![1, 2, 3, 4, 5]));
    let ys: ArrayRef = Arc::new(Int8Array::from(vec![
        Some(1),
        None,
        Some(3),
        Some(4),
        Some(5),
    ]));

    // compute xs + cast(ys, i32)
    let zs = {
        let b = cast(&ys, &DataType::Int32).unwrap();
        let c = b.as_any().downcast_ref::<Int32Array>().unwrap().to_owned();

        Arc::new(add(xs.as_any().downcast_ref::<Int32Array>().unwrap(), c).unwrap())
    };

    // define the schema
    let schema = Arc::new(Schema::new(vec![
        Field::new("x", DataType::Int32, false),
        Field::new("y", DataType::Int8, true),
        Field::new("z", DataType::Int32, true),
    ]));

    // create a record batch
    let record_batch = RecordBatch::try_new(schema.clone(), vec![xs, ys, zs]).unwrap();

    // write csv
    {
        let output_csv_file = File::create("out/simple.csv").unwrap();
        arrow::csv::WriterBuilder::new()
            .has_headers(true)
            .with_delimiter(',' as u8)
            .build(output_csv_file)
            .write(&record_batch)
            .expect("failed to write csv");
    }

    // write parquet
    {
        let output_parquet_file = File::create("out/simple.par").unwrap();
        parquet::arrow::ArrowWriter::try_new(output_parquet_file, schema.clone(), None)
            .unwrap()
            .write(&record_batch)
            .expect("failed to write parquet");
    }

    Ok(())
}
