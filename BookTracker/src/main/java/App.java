import IO.Input;
import StateLogic.State;
import IO.Output;

public class App {
    static State appState = State.INIT;

    public static void main(String[] args) {
        while (appState != State.EXIT) {
            int numberOfOptions = appState.options.length;
            Output.ShowOutput(Output.ParseStateOptions(appState.options));
            try {
                int selectedOption = Input.GetOption(numberOfOptions);
                appState=appState.options[selectedOption].execute();
            } catch (Exception e) {
                Output.ShowOutput(e.getMessage());
            }
        }
    }

}
