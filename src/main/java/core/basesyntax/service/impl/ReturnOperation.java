package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.getStorage().putIfAbsent(transaction.getFruit(), 0);

        storage.getStorage().entrySet().stream()
                .filter(entry
                        -> entry.getKey().equals(transaction.getFruit()))
                .forEach(entry
                        -> entry.setValue(entry.getValue()
                        + transaction.getQuantity()));
    }
}
