package core.basesyntax.service.impl;

import core.basesyntax.dp.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.getStorage().entrySet().stream()
                .filter(entry
                        -> entry.getKey().equals(transaction.getFruit()))
                .forEach(entry
                        -> entry.setValue(entry.getValue()
                        - transaction.getQuantity()));
    }
}
