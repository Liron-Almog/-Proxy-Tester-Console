package ex2;
import java.io.IOException;
public class Print implements Command {

    /**
     * The function Print the urls
     * @param cmd is the input from user e.i. command
     * @throws IOException
     */
    @Override
    public void execute(String cmd) throws IOException{

        SingeltonValidation.getInstance().ValidtionToNumsOfArgs(cmd,Const.ONE_ARG);
        SingeltonFile.getInstance().printData();
    }
}
