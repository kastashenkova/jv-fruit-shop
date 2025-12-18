package core.basesyntax.db;

import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage;

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public int getFruitQuantity(String fruitName) {
        return storage.get(fruitName);
    }

    public boolean findFruit(String fruitName) {
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            if (entry.getKey().equals(fruitName)) {
                return true;
            }
        }
        return false;
    }

    public void addFruit(String fruitName, int quantity) {
        storage.put(fruitName, quantity);
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            report.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }
        return report.toString();
    }
}
