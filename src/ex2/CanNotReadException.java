package ex2;
import java.io.IOException;
/**
 * Customize exception
 */
public class CanNotReadException extends IOException{
    CanNotReadException() {
        super("cannot read blocked.txt");
    }

}
