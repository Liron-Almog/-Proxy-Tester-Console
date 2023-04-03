package ex2;
import java.util.TreeMap;
public class CommandDecoratorFactory extends Factory{
    CommandDecoratorFactory(String m){
        super(m);

        factoryCommand = new TreeMap<String, Command>() {{
            put("i", new ImageDecorator());
            put("h", new TextHtmlDecorator());
            put("c", new CookiesDecorator());
            put("b", new BlockDecorator());
        }};
    }
}

