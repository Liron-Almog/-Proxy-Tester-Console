package ex2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URISyntaxException;
import java.io.*;
public class Download implements Command{

    /**
     * The function gets command and executes the command if the command meets the conditions.
     * @param cmd
     * @throws Exception
     */
    @Override
    public void execute(String cmd) throws IOException {

        SingeltonValidation.getInstance().ValidtionDowalond(cmd);

        String [] cmdAsArray = cmd.split("\\s+");

        String[] result = setUrlAndFileName(cmdAsArray);
        String url = result[0];
        String fileName = result[1];

        try {
            new URL(url).toURI();
            CommandDecorator decorator = createDecorator(cmdAsArray);

            if(decorator != null)
                decorator.execute(url);

            downloadAnything(fileName, url);
        }
        // If there was an Exception
        // while creating URL object
        catch (URISyntaxException | MalformedURLException e) {
            System.out.println("invalid URL");
        }
    }
    /**
     * The function creates decorator object and wraps the object in all the options in the command
     * @param cmdAsArray
     * @return
     */
    private CommandDecorator createDecorator(String [] cmdAsArray){

        Factory<CommandDecorator> cmdDecoratorFactory = new CommandDecoratorFactory("invalid option");
        CommandDecorator decorator = null,temp = null;
        boolean onlyDash = SingeltonValidation.getInstance().ValidtionDash(cmdAsArray);

        for(int i = cmdAsArray[Const.OPTIONS_PLACE].length()-1; i > 0 && cmdAsArray.length == Const.DOWNLOAD_WITH_OPTION_LEN
                                                                                            && !onlyDash; i--){
            if(i == cmdAsArray[Const.OPTIONS_PLACE].length()-1)
                decorator = cmdDecoratorFactory.createCommand(String.valueOf(cmdAsArray[Const.OPTIONS_PLACE].charAt(i)));

            else {//wrap the decorator
                temp = cmdDecoratorFactory.createCommand(String.valueOf(cmdAsArray[Const.OPTIONS_PLACE].charAt(i)));
                temp.setCommand(decorator);
                decorator = temp;
            }
        }
        return decorator;
    }
    private static String[] setUrlAndFileName(String[] cmdAsArray) {
        String[] result = new String[2];
        if (cmdAsArray.length == Const.DOWNLOAD_WITHOUT_OPTION_LEN) {
            result[0] = cmdAsArray[1];
            result[1] = cmdAsArray[2];
        } else if (cmdAsArray.length == Const.DOWNLOAD_WITH_OPTION_LEN) {
            result[0] = cmdAsArray[2];
            result[1] = cmdAsArray[3];
        }
        return result;
    }

    /**
     * The function checks if there is status 400 - 500 and if not downloads the file.
     * @param filename
     * @param link
     * @throws IOException
     */
    public void downloadAnything(String filename,String link) throws IOException{

        checkStatus(link);//checks status before download
        try {
            URL url = new URL(link);
            // try with resource
            try (
                    InputStream input = new BufferedInputStream(url.openStream());
                    OutputStream output = new BufferedOutputStream(new FileOutputStream(filename));
            ) {
                int b;
                while ((b = input.read()) != -1) {
                    output.write(b);
                }
            }
        }
        catch (IOException e){
            throw new IOException("cannot write output file");
        }
    }

    /**
     * The function checks the status get and throws exception if needed
     * @param link
     * @throws IOException
     */
    private void checkStatus(String link) throws IOException{

        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new HttpException(con.getResponseCode());
        }
    }
}
