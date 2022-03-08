import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static Scanner scanner = new Scanner(System.in);
    static final String colorReset = "\u001B[0m";
    static final String colorRed = "\u001B[31m";
    static final String colorGreen = "\u001B[32m";
    static final String colorYellow = "\u001B[33m";

    public enum CharsIndexLibrary {
        UPPER_CHARS(65, 90), LOWER_CHARS(97, 122),
        NUMBERS(48, 57);

        final int indexFrom;
        final int indexTo;

        CharsIndexLibrary(int indexFrom, int indexTo) {
            this.indexFrom = indexFrom;
            this.indexTo = indexTo;
        }
    }

    public enum GeneratorType {
        BY_STREAM(1), BY_LIST(2);

        final int typeIndex;

        GeneratorType(int typeIndex) {
            this.typeIndex = typeIndex;
        }
    }

    public static int validateTokenLength(String tokenLength) {

        List<Integer> availableSize = Arrays.asList(5, 10, 15);
        int triesCount = 4;

        for (int i = 0; i < triesCount; i++) {
            if (tokenLength.matches("[0-9]+")) {
                if (availableSize.contains(Integer.parseInt(tokenLength))) break;
                System.out.println(colorYellow + "You entered a token size " + tokenLength + " which is not in the " +
                        "specified token version. Type 5, 10, 15:" + colorReset);
            } else System.out.println(colorYellow + "You need to type a number!" + colorReset);
            tokenLength = scanner.nextLine();
            validateTries(triesCount, i);
        }
        return Integer.parseInt(tokenLength);
    }

    public static int validateGeneratorType(String type) {

        int triesCount = 4;

        for (int i = 0; i < triesCount; i++) {
            if (type.matches("[1-2]")) break;
            else {
                System.out.println(colorYellow + "You need to type 1 or 2!" + colorReset);
                type = scanner.nextLine();
            }
            validateTries(triesCount, i);
        }
        return Integer.parseInt(type);
    }

    private static void validateTries(int triesCount, int tryIndex) {

        if (tryIndex == triesCount - 1) {
            System.out.println(colorRed + "You have entered wrong value 5 times, the token generator is blocked.");
            System.exit(0);
        }
    }
}
