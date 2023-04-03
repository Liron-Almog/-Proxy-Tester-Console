package ex2;
import java.io.IOException;
public class BlockDecorator extends CommandDecorator {

    /**
     * The function executes the BlockDecorator blocks the download
     * of url that exist in blocked.txt.
     * @param link is the input from user e.i. command
     * @throws IOException
     */
    @Override
    public void execute(String link) throws IOException{

        this.createConnection(link); // checks the status code

        if (SingeltonFile.getInstance().isUrlBlocked(link))
            throw new IOException("denied");

        if(command != null)
            command.execute(link);
    }
}
