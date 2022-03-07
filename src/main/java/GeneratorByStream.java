import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratorByStream {

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
        char[] array = generateAsciiArray();
        for (int i = 0; i < tokenLength; i++) {
            token.append(array[new Random().nextInt(array.length)]);
        }
        return token.toString();
    }

    private static char[] generateAsciiArray() {

        return Stream.of(IntStream.rangeClosed(CharsLibrary.LOWER_CHARS.indexFrom, CharsLibrary.LOWER_CHARS.indexTo),
                        IntStream.rangeClosed(CharsLibrary.UPPER_CHARS.indexFrom, CharsLibrary.UPPER_CHARS.indexTo),
                        IntStream.rangeClosed(CharsLibrary.NUMBERS.indexFrom, CharsLibrary.NUMBERS.indexTo),
                        IntStream.of(33, 35, 36, 37, 38, 40, 41, 42, 64, 94))
                .flatMapToInt(x -> x)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining())
                .toCharArray();
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

    private enum CharsLibrary {
        UPPER_CHARS(65, 90), LOWER_CHARS(97, 122),
        NUMBERS(48, 57);

        final int indexFrom;
        final int indexTo;

        CharsLibrary(int indexFrom, int indexTo) {
            this.indexFrom = indexFrom;
            this.indexTo = indexTo;
        }
    }
}