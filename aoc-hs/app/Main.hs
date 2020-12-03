module Main where

import System.Environment
import Data.Maybe

import qualified Aoc.Year2020.Day1 
import qualified Aoc.Year2020.Day2 

type Arguments = (Int, Int, Int)

main :: IO ()
main = do
    args <- getArgs 
    content <- getContents
    let provision = parseArgs args >>= provide
    let result = provision <*> Just content
    putStrLn $ fromMaybe "invalid arguments" result 

parseArgs :: [String] -> Maybe Arguments
parseArgs (year:day:part:other) = Just (read year, read day, read part)
parseArgs other = Nothing

provide :: Arguments -> Maybe (String -> String)
provide (2020, 1, 1) = Just $ show . Aoc.Year2020.Day1.part1
provide (2020, 1, 2) = Just $ show . Aoc.Year2020.Day1.part2
provide (2020, 2, 1) = Just $ show . Aoc.Year2020.Day2.part1 
provide (2020, 2, 2) = Just $ show . Aoc.Year2020.Day2.part2
provide rest = Nothing
