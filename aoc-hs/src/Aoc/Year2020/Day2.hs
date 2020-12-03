module Aoc.Year2020.Day2 (part1, part2) where

import Text.Parsec
import Data.Maybe

data PassLine = PassLine Int Int Char String

part1 :: String -> Int 
part1 = anyPart isValid
    where
        isValid (PassLine lo hi token pass) = lo <= count && count <= hi 
            where
                count = length $ filter (== token) pass 
 
part2 :: String -> Int
part2 = anyPart isValid
    where
        isValid (PassLine lo hi token pass) =
            (pass!!(lo - 1) == token) /= (pass!!(hi - 1) == token)

anyPart :: (PassLine -> Bool) -> String -> Int
anyPart isValid content = length $ filter isValid $ mapMaybe parseLine $ lines content

parseLine :: String -> Maybe PassLine 
parseLine content = case parse passLineParser "" content of
    Left error -> Nothing
    Right success -> Just success

passLineParser :: Parsec String () PassLine 
passLineParser = do
    lo <- many1 digit ; char '-' 
    hi <- many1 digit ; char ' '
    token <- anyChar ; string ": "
    pass <- many1 anyChar
    return $ PassLine(read lo) (read hi) token pass
