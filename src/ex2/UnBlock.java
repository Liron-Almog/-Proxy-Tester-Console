package ex2;
import java.io.IOException;

public class UnBlock implements Command {

    /**
     * The function removes url from blocked.txt
     * @param cmd is the input from user e.i. command
     * @throws IOException
     */
    @Override
    public void execute(String cmd) throws IOException{

        SingeltonValidation.getInstance().ValidtionToNumsOfArgs(cmd,Const.TWO_ARGS);
        String link = cmd.split("\\s+")[Const.URL];//takes the url from cmd
        SingeltonFile.getInstance().removeUrl(link);
    }
}