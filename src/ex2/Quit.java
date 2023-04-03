package ex2;
public class Quit implements Command {

    /**
     * The function quits from program
     * @param cmd
     */
    @Override
    public void execute(String cmd) {

        SingeltonValidation.getInstance().ValidtionToNumsOfArgs(cmd,Const.ONE_ARG);
        System.exit(0);
    }
}
