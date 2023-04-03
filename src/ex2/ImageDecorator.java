package ex2;
import java.io.IOException;
import java.net.HttpURLConnection;
public class ImageDecorator extends CommandDecorator {

    /**
     * The function executes the ImageDecorator blocks the download
     * of urls that are an image
     * @param link
     * @throws Exception
     */
    @Override
    public void execute(String link) throws IOException {

        HttpURLConnection con = this.createConnection(link);

        String contentType = con.getHeaderField("Content-Type");
        if (contentType.startsWith("image/")) {
            throw new IOException("denied");
        }
        if(command != null)
            command.execute(link);
    }
}
