package ex2;
import java.io.IOException;
/**
 * Customize exception
 */
public class HttpException extends IOException {

    HttpException(int num){
        super(String.valueOf(num));
    }
}
