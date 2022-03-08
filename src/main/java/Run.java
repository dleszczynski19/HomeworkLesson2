public class Run extends Utils {

    public static void main(String[] args) {

        System.out.println("Which type of generator you'd to choose: \nPress 1 for by stream\nPress 2 for by list");
        int typeIndex = validateGeneratorType(scanner.nextLine());
        System.out.println("You can generate a token with " + colorGreen + "5, 10, 15 " + colorReset + "characters. " +
                "How many characters you want?");
        if (typeIndex == GeneratorType.BY_LIST.typeIndex) {
            System.out.println("Your token: " + colorGreen + GeneratorByList.tokenGenerator(
                    GeneratorByList.validateTokenLength(scanner.nextLine())));
        } else if (typeIndex == GeneratorType.BY_STREAM.typeIndex) {
            System.out.println("Your token: " + colorGreen + GeneratorByStream.tokenGenerator(
                    GeneratorByStream.validateTokenLength(scanner.nextLine())));
        }
    }
}