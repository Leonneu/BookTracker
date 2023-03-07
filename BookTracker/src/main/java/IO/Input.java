package IO;

import java.util.Scanner;

public class Input {
    private static Scanner userInput = new Scanner(System.in);

    public static int GetOption(int numberOfValidOptions) throws InvalidOptionException {
        int selectedOption = userInput.nextInt();
        if (0 <= selectedOption && selectedOption < numberOfValidOptions)
            return selectedOption;
        throw new InvalidOptionException("Invalid Option");
    }
}
