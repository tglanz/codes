pub trait Solution {
    fn check_it(x: i32) -> i32;
}

pub struct Solution1;
pub struct Solution2;

impl Solution for Solution1 {
    fn check_it(x: i32) -> i32 {
        x
    }
}

impl Solution for Solution2 {
    fn check_it(x: i32) -> i32 {
        x + 1
    }
}