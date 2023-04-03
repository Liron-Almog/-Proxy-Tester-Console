package ex2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
public class Block implements Command {

    /**
     * The function executes the block command and catches invalid url
     * @param cmd is the input from user e.i. command
     * @throws IOException
     */
    @Override
    public void execute(String cmd) throws IOException{

        SingeltonValidation.getInstance().ValidtionToNumsOfArgs(cmd,Const.TWO_ARGS);
        String [] cmdAsArray = cmd.split("\\s+");

        try {
            new URL(cmdAsArray[Const.URL]).toURI();/* Try creating a valid URL */
            SingeltonFile.getInstance().insertUrlToFile(cmdAsArray[Const.URL]);
        }
        // If there was an Exception
        // while creating URL object
        catch (URISyntaxException | MalformedURLException e) {
            System.out.println("invalid URL");
        }
    }
}
