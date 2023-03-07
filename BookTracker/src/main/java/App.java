import IO.Input;
import StateLogic.ConsoleCommand;
import StateLogic.DIContainer;
import StateLogic.State;
import IO.Output;

public class App {


    public static void main(String[] args) {
        DIContainer diContainer = new DIContainer(null,null);
        StateDictionary stateDictionary = new StateDictionary(diContainer);
        State appState = State.INIT;
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
