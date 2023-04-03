package ex2;
import java.io.IOException;
import java.util.Scanner;
public class Main {

    /**
     * The function reads commands from user and executes them,
     * if the command is incorrect an exception is thrown.
     * @param args
     */
    public static void main(String[] args) {

        Factory<Command> commandFactory = new CommandFactory("invalid command");
        Scanner sc = new Scanner(System.in);

        SingeltonFile.getInstance();//initialize Singelton and loading file
        while (true){
            try {
                String line = sc.nextLine();//read line
                Command cmd = commandFactory.createCommand(line.split("\\s+")[Const.CMD_CHAR]);
                cmd.execute(line);
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
