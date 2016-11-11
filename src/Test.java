import java.io.*;

public class Test {
    public static void readFile (final String fileName, final StringBuilder contentBuilder, final StringBuilder errorBuilder) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            final StringBuilder stringBuilder = new StringBuilder();

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }

            contentBuilder.append(stringBuilder.toString());
        } catch (IOException e) {
            errorBuilder.append(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    errorBuilder.append(e.getMessage());
                }
            }
        }
    }

    public static void main (final String[] args) {
        final StringBuilder contentBuilder = new StringBuilder();
        final StringBuilder errorMessageBuilder = new StringBuilder();

        readFile("./src/Test.java", contentBuilder, errorMessageBuilder);
        if (errorMessageBuilder.length() > 0) {
            System.out.printf("Hat leider nicht geklappt: %s\n", errorMessageBuilder.toString());
        } else {
            System.out.printf("Hat geklappt: %s\n", contentBuilder.toString());
        }

        contentBuilder.setLength(0);
        errorMessageBuilder.setLength(0);

        readFile("./gibts-gar.nicht", contentBuilder, errorMessageBuilder);
        if (errorMessageBuilder.length() > 0) {
            System.out.printf("Hat leider nicht geklappt: %s\n", errorMessageBuilder.toString());
        } else {
            System.out.printf("Hat geklappt: %s\n", contentBuilder.toString());
        }
    }
}