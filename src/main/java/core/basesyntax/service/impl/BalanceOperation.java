package core.basesyntax.service.impl;

import core.basesyntax.dp.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private final Storage storage;

    public BalanceOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        storage.getStorage().put(transaction.getFruit(), transaction.getQuantity());
    }
}
