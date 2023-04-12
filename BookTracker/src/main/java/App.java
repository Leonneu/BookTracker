import Plugin.IO.Input;
import Plugin.IO.InvalidOptionException;
import Plugin.Application.StateDictionary;
import Plugin.Application.ConsoleCommands.ConsoleCommand;
import Plugin.Application.Container;
import Plugin.Application.State;
import Plugin.IO.Output;

public class App {

    public static State appState = State.INIT;
    public static void main(String[] args) {
        Container container = new Container(null,null);
        StateDictionary stateDictionary = new StateDictionary(container);
        while (appState != State.EXIT) {
            ConsoleCommand[] currentOptions =stateDictionary.GetOptions(appState);
            int numberOfOptions = currentOptions.length;
            Output.showOutput(Output.parseStateOptions(currentOptions));
            try {
                int selectedOption = Input.GetOption(numberOfOptions);
                appState=currentOptions[selectedOption].execute();
            } catch (InvalidOptionException e) {
                Output.showOutput("Hilfe:");
                Output.showOutput(Output.parseStateHelp(currentOptions));
            }
        }
    }

}
