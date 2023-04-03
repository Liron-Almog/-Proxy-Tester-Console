package ex2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public abstract class CommandDecorator implements Command{

    protected CommandDecorator command = null;
    public void setCommand(CommandDecorator c){
        command = c;
    }

    /**
     * The function checks response code and throws HttpException
     * @param con http url connection variable
     * @throws IOException
     */
    public void checkStatus(HttpURLConnection con) throws IOException{

        // get the HTTP response code
        int responseCode = con.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK)
            throw new HttpException(responseCode);
    }

    /**
     * Creates connection and checks status code
     * @param link
     * @return the connection variable
     * @throws IOException
     */
    public HttpURLConnection createConnection(String link) throws IOException{

        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        checkStatus(con);

        return con;
    }
}
