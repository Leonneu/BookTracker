import IO.Input;
import IO.InvalidOptionException;
import Model.StateDictionary;
import Model.ConsoleCommands.ConsoleCommand;
import Model.Data.DIContainer;
import Model.State;
import IO.Output;

public class App {

    public static State appState = State.INIT;
    public static void main(String[] args) {
        DIContainer diContainer = new DIContainer(null,null);
        StateDictionary stateDictionary = new StateDictionary(diContainer);
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
