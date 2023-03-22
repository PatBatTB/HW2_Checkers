package com.github.patbattb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {
    private Parser() { }
/*
Разбивает строку со стартовыми координатами на список строк отдельных координат в формате "a3"
 */
    public static List<String> parseStartingPositions(String line) {
        List<String> positions = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=(^|\\s))[a-zA-Z][0-9]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            positions.add(matcher.group());
        }
        return positions;
    }
/*
Из входных данных парсит ходы и разбивает на список строк отдельных ходов в формате "g3-f4"
 */
    public static List<String> parseTurns(List<String> lines) {
        List<String> turns = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\w+)[:-]((\\w+)[:-]?)+");
        Matcher matcher;
        for (String line : lines) {
            matcher = pattern.matcher(line);
            while (matcher.find()) {
                turns.add(matcher.group());
            }
        }
        return turns;
    }
/*
Из строки с координатами отдельного хода парсит координаты и возвращает списком строк в формате "a3"
 */
    public static List<String> parseOneTurn(String step) {
        List<String> coordinates = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<=(^|[:-]))\\w{2}(?=($|[:-]))");
        Matcher matcher = pattern.matcher(step);
        while (matcher.find()) {
            coordinates.add(matcher.group());
        }
        return coordinates;
    }
}
