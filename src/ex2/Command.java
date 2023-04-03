package ex2;

import java.io.IOException;

public interface Command {

    public void execute(String cmdLine) throws IOException;
}
