package com.github.patbattb.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Класс считывает данные из файла input.txt с построчной разбивкой.
 * Возвращает список строк.
 */
public final class Reader {
    private Reader() { }
    public static List<String> read() {
        Path file = Path.of("input.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(file);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return lines;
    }
}
