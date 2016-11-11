import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test3 {
    interface Callback {
        void onSuccess(final String result);

        void onError(final Throwable error);
    }

    public static void readFile(final String fileName, final Callback callback) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            final StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            callback.onSuccess(stringBuilder.toString());
        } catch (IOException e) {
            callback.onError(new Throwable(e.getMessage()));
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                //nothing to do here
            }
        }
    }

    public static void main(final String[] args) {
        readFile("./src/Main.java", new Callback() {
            @Override
            public void onSuccess(String result) {
                System.out.printf("Hat geklappt: %s\n", result);
            }

            @Override
            public void onError(Throwable error) {
                System.err.printf("Hat nicht geklappt: %s", error.getMessage());
            }
        });
    }
}
