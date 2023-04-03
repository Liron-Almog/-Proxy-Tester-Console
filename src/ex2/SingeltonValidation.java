package ex2;


public class SingeltonValidation {

    private static SingeltonValidation uniqueInstance;

    /**
     * The function checks The numbers of arguments in command,
     * if there are not enough arguments the function throws an exception
     * @param cmd The command
     * @param number of arguments
     */
    public void ValidtionToNumsOfArgs(String cmd,int number){

        if(cmd.split("\\s+").length != number)
            throw new IllegalArgumentException("invalid command");
    }

    /**
     * checks if there is dash in command and return true if there is.
     * @param cmd
     * @return
     */
    public boolean ValidtionDash(String [] array){

        if(array.length == Const.DOWNLOAD_WITH_OPTION_LEN && array[Const.OPTIONS_PLACE].equals("-"))
            return true;
        return false;
    }

    /**
     * checks if the download command is correct, else throws exception
     * @param cmd
     */
    public void ValidtionDowalond(String cmd){

        String [] array = cmd.split("\\s+");

        if((array.length == Const.DOWNLOAD_WITH_OPTION_LEN  && array[1].charAt(0) == '-')
            || array.length == Const.DOWNLOAD_WITHOUT_OPTION_LEN )
            return;

        throw new IllegalArgumentException("invalid command");
    }
    public static synchronized SingeltonValidation getInstance() {

        if (uniqueInstance == null) {
            uniqueInstance = new SingeltonValidation();
        }
        return uniqueInstance;
    }
    private SingeltonValidation() {}
}
