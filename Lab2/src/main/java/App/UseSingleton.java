package App;

import java.util.HashSet;
import java.util.Set;

public class UseSingleton {
    private Set<String> sessionId = new HashSet();
    private static UseSingleton instance = new UseSingleton();

    private UseSingleton() {
    }

    public static UseSingleton getInstance() {
        return instance;
    }

    void addId(String value) {
        this.sessionId.add(value);
    }

    boolean containsId(String value) {
        return this.sessionId.contains(value);
    }
}
