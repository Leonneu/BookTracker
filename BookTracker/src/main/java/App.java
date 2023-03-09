import IO.Input;
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
            Output.ShowOutput(Output.ParseStateOptions(currentOptions));
            try {
                int selectedOption = Input.GetOption(numberOfOptions);
                appState=currentOptions[selectedOption].execute();
            } catch (Exception e) {
                Output.ShowOutput(e.getMessage());
            }
        }
    }

}
