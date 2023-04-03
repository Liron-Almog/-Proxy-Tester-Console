package ex2;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.TreeSet;

public class SingeltonFile {

    private static SingeltonFile uniqueInstance;
    static final String FILENAME = "blocked.txt";


    /**
     * The function prints the data in alpha order
     * @throws CanNotReadException
     */
    public void printData() throws CanNotReadException {

        Set<String> urls = new TreeSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line = reader.readLine()) != null) {
                urls.add(line);
            }
            for (String s : urls)
                System.out.println(s);
        }
        catch (IOException e) {
            throw new CanNotReadException();
        }
    }

    /**
     * The function writes the url to file
     * @param url
     * @throws IOException
     */
    private void writeToFile(String url) throws IOException{

        BufferedWriter out = new BufferedWriter(new FileWriter(FILENAME,true));
        out.write(url + "\n");
        out.close();
    }

    /**
     * The function removes the url before it insets it
     * @param url
     * @throws CanNotWriteException
     */
    public void insertUrlToFile(String url) throws CanNotWriteException{

        try {
            removeUrl(url);
            writeToFile(url);
        }
        catch (IOException e) {
            throw new CanNotWriteException();
        }
    }

    /**
     * The function gets url and remove all the prefix and equal
     * @param oldUrl
     * @throws CanNotWriteException
     */
    public void removeUrl(String oldUrl) throws CanNotWriteException{

        ArrayList<String> urls = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while ((line=reader.readLine())!=null)
               if(!line.equals(oldUrl) && !line.contains(oldUrl) &&//if is not prefix or equal
                                               !oldUrl.contains(line))
                   urls.add(line);
            reader.close();

            BufferedWriter out = new BufferedWriter(new FileWriter(FILENAME));//writes to file
            for (String s : urls)
               out.write(s +"\n");

           out.close();
        }
        catch(IOException e){
            throw new CanNotWriteException();
        }
    }

    /**
     * The function loads the file if it doesn't exist
     */
    private void loadingFile(){

        try{
            File file = new File(FILENAME);
            if(!file.exists())
                file.createNewFile();
        }
        catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    /**
     * The function checks if the url exists in block.txt
     * @param url
     * @return
     * @throws IOException
     */
    public boolean isUrlBlocked(String url) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
        String line;
        while ((line=reader.readLine())!=null){
            if (line.equals(url) || line.contains(url) || url.contains(line))
                return true;
        }
        return false;
    }
    public static synchronized SingeltonFile getInstance() {

        if (uniqueInstance == null) {
            uniqueInstance = new SingeltonFile();
            uniqueInstance.loadingFile();
        }
        return uniqueInstance;
    }
    private SingeltonFile() {}
}
