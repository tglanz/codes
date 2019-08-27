mod solutions;
use solutions::*;

#[cfg(test)]
mod tests {

    use super::*;

    #[test]
    fn it_works() {
        assert_eq!(1, Solution1::check_it(1));
        assert_eq!(1, Solution2::check_it(1));
    }
}