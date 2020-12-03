module Aoc.Year2020.Day1 (part1, part2) where

import Aoc.Util 
import Data.Maybe
import Data.List

part1 :: String -> Int
part1 = anyPart 2

part2 :: String -> Int
part2 = anyPart 3

anyPart :: Int -> String -> Int
anyPart takeCount content = fromMaybe 0 (fmap operate (find predicate (cartesian takeCount $ ints content)))
    where
        ints content = read <$> lines content
        predicate values = sum values == 2020
        operate = foldr (*) 1
