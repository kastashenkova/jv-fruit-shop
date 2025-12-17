package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        return report.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(FruitTransaction.Operation.fromCode(parts[0]));
                    transaction.setFruit(parts[1]);
                    transaction.setQuantity(Integer.parseInt(parts[2]));
                    return transaction;
                })
                .collect(Collectors.toList());
    }
}
