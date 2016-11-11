import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
    public static void readFile (final String fileName, final StringBuilder contentBuilder) throws FileDoesNotExistException, FileReadingException {
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
        } catch (FileNotFoundException e) {
            throw new FileDoesNotExistException(e.getMessage());
        } catch (IOException e) {
            throw new FileReadingException(e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public static void main (final String[] args) {
        final StringBuilder contentBuilder = new StringBuilder();

        try {
            readFile("./src/Test2.java", contentBuilder);
            System.out.printf("Hat geklappt: %s\n", contentBuilder.toString());
        } catch (FileIOException e) {
            System.err.println(e.getMessage());
        }

        contentBuilder.setLength(0);

        try {
            readFile("./gibts-gar.nicht", contentBuilder);
            System.out.printf("Hat geklappt: %s\n", contentBuilder.toString());
        } catch (FileIOException e) {
            System.err.println(e.getMessage());
        }
    }
}
