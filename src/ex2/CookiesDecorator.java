package ex2;
import java.io.IOException;
import java.net.HttpURLConnection;
public class CookiesDecorator extends CommandDecorator{

    /**
     * The function executes the CookiesDecorator blocks the download
     * of urls that hava cookies.
     * @param link
     * @throws Exception
     */
    @Override
    public void execute(String link) throws IOException {

        HttpURLConnection con = this.createConnection(link);
        String headerN;

        for(int j = 1;(headerN = con.getHeaderFieldKey(j)) != null;j++)
            if(headerN.equalsIgnoreCase("Set-Cookie"))
                throw new IOException("denied");

        if(command != null)
            command.execute(link);
    }
}
