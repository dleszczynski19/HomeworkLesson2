import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneratorByList extends Utils {
    
    public static String tokenGenerator(int tokenLength) {

        StringBuilder token = new StringBuilder(tokenLength);
        List<Character> asciiLibrary = generateAsciiLibrary();

        for (int i = 0; i < tokenLength; i++) {
            char tokenValue = asciiLibrary.get(new Random().nextInt(asciiLibrary.size()));
            token.append(tokenValue);
        }
        return token.toString();
    }

    private static List<Character> generateAsciiLibrary() {

        List<Character> asciiLibrary = new ArrayList<>();

        for (int tokenIndex = 33; tokenIndex <= 122; tokenIndex++) {
            if (validateTokenValue(tokenIndex)) asciiLibrary.add((char) tokenIndex);
        }
        return asciiLibrary;
    }

    private static boolean validateTokenValue(int tokenValue) {

        List<Integer> asciiExceptions = Arrays.asList(34, 39, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 92, 93,
                95, 96);
        return !asciiExceptions.contains(tokenValue);
    }
}