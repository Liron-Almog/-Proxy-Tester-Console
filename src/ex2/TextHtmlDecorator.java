package ex2;
import java.io.IOException;
import java.net.HttpURLConnection;


public class TextHtmlDecorator extends CommandDecorator{

    /**
     * The function executes the TextHtmlDecorator blocks the download
     * of urls that are a html
     * @param link
     * @throws Exception
     */
    @Override
    public void execute(String link) throws IOException {

        HttpURLConnection con = this.createConnection(link);

        // we want to download only if the content-type is text
        String contentType = con.getHeaderField("Content-Type");
        if (contentType.startsWith("text/html"))
            throw new IOException("denied");

        if(command != null)
            command.execute(link);
    }

}
