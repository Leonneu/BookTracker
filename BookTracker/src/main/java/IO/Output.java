package IO;

import StateLogic.IConsoleCommand;

public class Output {
    private static String lineBreak = System.getProperty("line.separator");
    public static void ShowOutput(String message){
        System.out.println(message);
    }
    public static String ParseStateOptions(IConsoleCommand[] options){
        int n = options.length;
        String result = "";
        for (int i = 0; i < n; i++) {
                 result+=i+". "+options[i].name()+lineBreak;
        }
        return result;
    }
}
