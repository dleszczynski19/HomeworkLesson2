import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeneratorByStream extends Utils {

    public static String tokenGenerator(int tokenLength) {

        StringBuilder token = new StringBuilder(tokenLength);
        char[] array = generateAsciiArray();
        for (int i = 0; i < tokenLength; i++) {
            token.append(array[new Random().nextInt(array.length)]);
        }
        return token.toString();
    }

    private static char[] generateAsciiArray() {

        return Stream.of(IntStream.rangeClosed(CharsIndexLibrary.LOWER_CHARS.indexFrom, CharsIndexLibrary.LOWER_CHARS.indexTo),
                        IntStream.rangeClosed(CharsIndexLibrary.UPPER_CHARS.indexFrom, CharsIndexLibrary.UPPER_CHARS.indexTo),
                        IntStream.rangeClosed(CharsIndexLibrary.NUMBERS.indexFrom, CharsIndexLibrary.NUMBERS.indexTo),
                        IntStream.of(33, 35, 36, 37, 38, 40, 41, 42, 64, 94))
                .flatMapToInt(x -> x)
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining())
                .toCharArray();
    }
}