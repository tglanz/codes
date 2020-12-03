module Aoc.Year2020.Day2 (part1, part2) where

import Text.Parsec
import Data.Maybe
import Data.List

data PassLine = PassLine Int Int Char String

part1 :: String -> Int 
part1 = anyPart isValid
    where
        isValid (PassLine minRange maxRange character password) = higher && lower 
            where
                higher = occurences >= minRange
                lower = occurences <= maxRange
                occurences = length $ findIndices (== character) password 
 
part2 :: String -> Int
part2 = anyPart isValid
    where
        isValid (PassLine minRange maxRange character password) =
            isMin /= isMax
            where
                isMin = password!!(minRange - 1) == character
                isMax = password!!(maxRange - 1) == character

anyPart :: (PassLine -> Bool) -> String -> Int
anyPart isValid content = length $ filter isValid (parseLines content)

parseLines :: String -> [PassLine]
parseLines content = mapMaybe parseLine (lines content)

parseLine :: String -> Maybe PassLine 
parseLine content = case parse passLineParser "" content of
    Left error -> Nothing
    Right success -> Just success

passLineParser :: Parsec String () PassLine 
passLineParser = do
    minRange <- many1 digit 
    char '-' 

    maxRange <- many1 digit 
    char ' '

    character <- anyChar
    string ": "

    pass <- many1 anyChar

    return $ PassLine(read minRange) (read maxRange) character pass
