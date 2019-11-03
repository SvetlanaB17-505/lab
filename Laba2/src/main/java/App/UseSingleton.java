package App;

import java.util.HashSet;
import java.util.Set;

public class UseSingleton {
    private Set<String> sessionId;
    private static UseSingleton instance = new UseSingleton();

    private UseSingleton(){
        this.sessionId = new HashSet<String>();
    }

    public static UseSingleton getInstance(){
        return instance;
    }

    void addId(String value) {sessionId.add(value);}
    boolean containsId(String value) {return sessionId.contains(value);}
}
