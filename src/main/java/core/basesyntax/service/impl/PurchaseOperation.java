package core.basesyntax.service.impl;

import core.basesyntax.dp.Storage;
import core.basesyntax.exception.IllegalOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private final Storage storage;

    public PurchaseOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        if (!storage.getStorage().containsKey(fruit)) {
            throw new IllegalOperationException("Fruit " + fruit + " not found");
        }
        int currentQuantity = storage.getStorage().get(fruit);
        int purchaseQuantity = transaction.getQuantity();
        if (currentQuantity < purchaseQuantity) {
            throw new IllegalOperationException(
                    "Purchase quantity less than current quantity in storage: "
                            + currentQuantity + " < " + purchaseQuantity);
        }
        storage.getStorage().put(fruit, currentQuantity - purchaseQuantity);
    }
}
