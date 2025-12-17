package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements Reader {
    @Override
    public List<String> read(String fileName) {
        try (BufferedReader reader
                     = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read info from file: " + e);
        }
    }
}
