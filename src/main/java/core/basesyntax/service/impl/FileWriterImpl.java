package core.basesyntax.service.impl;

import core.basesyntax.exception.IllegalOperationException;
import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements Writer {
    @Override
    public void write(String report, String fileName) {
        if (report == null || report.isEmpty()) {
            throw new IllegalOperationException(
                    "Report cannot be null or empty");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalOperationException(
                    "File name cannot be null or empty");
        }
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report into file: " + e);
        }
    }
}
