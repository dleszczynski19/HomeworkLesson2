import java.util.*;

public class GeneratorByList {

    static Scanner scanner = new Scanner(System.in);
    static final String colorReset = "\u001B[0m";
    static final String colorRed = "\u001B[31m";
    static final String colorGreen = "\u001B[32m";
    static final String colorYellow = "\u001B[33m";

    public static void main(String[] args) {

        System.out.println("You can generate a token with " + colorGreen + "5, 10, 15 " + colorReset + "characters. " +
                "How many characters you want?");
        System.out.println("Your token: " + colorGreen + tokenGenerator(validateTokenLength(scanner.nextInt())));
    }

    private static String tokenGenerator(int tokenLength) {

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

    private static int validateTokenLength(int tokenLength) {

        for (int i = 0; i < 4; i++) {
            if (tokenLength == 5 || tokenLength == 10 || tokenLength == 15) break;
            System.out.println(colorYellow + "You entered a token size " + tokenLength + " which is not in the " +
                    "specified token version. Type 5, 10, 15:" + colorReset);
            tokenLength = scanner.nextInt();
            if (i == 3) {
                System.out.println(colorRed + "You have entered wrong value 5 times, the token generator is blocked.");
                System.exit(0);
            }
        }
        return tokenLength;
    }
}