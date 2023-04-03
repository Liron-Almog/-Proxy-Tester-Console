package ex2;
import java.util.TreeMap;
public abstract class Factory<T> {
    private String msg;
    protected TreeMap<String, T> factoryCommand;
    Factory(String m){
        msg = m;
    }
    public T createCommand(String str){

        T factory = factoryCommand.get(str);
        if (factory == null)
            throw new IllegalArgumentException(msg);
        return factory;
    }
}
