module Main where

import System.Environment
import Data.Maybe

import qualified Year2020 

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
provide (2020, 1, 1) = Just $ show . Year2020.day1 2
provide (2020, 1, 2) = Just $ show . Year2020.day1 3
provide rest = Nothing
