package IO;

import Model.ConsoleCommands.ConsoleCommand;

public class Output {
    private static String lineBreak = System.getProperty("line.separator");

    public static void ShowOutput(String message) {
        System.out.println(message);
    }

    public static String ParseStateOptions(ConsoleCommand[] options) {
        int n = options.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(i).append(". ").append(options[i].name()).append(lineBreak);
        }
        return result.toString();
    }
}
