package ex2;

import java.io.IOException;

/**
 * Customize exception
 */
public class CanNotWriteException extends IOException {
        public CanNotWriteException() {
            super("cannot write blocked.txt");
        }
}
