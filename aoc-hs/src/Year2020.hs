module Year2020 where

import Data.Maybe
import Data.List

day1 :: Int -> String -> Int
day1 takeCount content = fromMaybe 0 (fmap operate (find predicate (cartesian takeCount $ ints content)))
    where
        ints content = read <$> lines content
        predicate values = sum values == 2020
        operate = foldr (*) 1

cartesian :: Int -> [Int] -> [[Int]]
cartesian repetition values = sequence duplicate
    where duplicate = take repetition $ cycle [values]
