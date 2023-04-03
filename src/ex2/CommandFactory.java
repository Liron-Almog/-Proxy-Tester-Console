package ex2;
import java.util.TreeMap;
public class CommandFactory extends Factory {

    CommandFactory(String m) {
        super(m);
        factoryCommand = new TreeMap<String, Command>() {{
            put("p", new Print());
            put("q", new Quit());
            put("u", new UnBlock());
            put("b", new Block());
            put("d", new Download());
        }};
    }
}

