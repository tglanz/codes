module Aoc.Util where

cartesian :: Int -> [Int] -> [[Int]]
cartesian repetition values = sequence duplicate
    where duplicate = take repetition $ cycle [values]

