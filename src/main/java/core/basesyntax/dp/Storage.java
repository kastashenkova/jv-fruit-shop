package core.basesyntax.dp;

import java.util.Map;

public class Storage {
    private Map<String, Integer> storage;

    public Storage(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    public void setStorage(Map<String, Integer> storage) {
        this.storage = storage;
    }
}
