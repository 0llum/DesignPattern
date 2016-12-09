import java.io.*;

public class Test3 {
    interface Callback<RESULT, ERROR extends Throwable> {
        void onSuccess(final RESULT result);

        void onError(final ERROR error);
    }

    public static void readFileSize(final String filename, final Callback<Long, IOException> callback) {
        File file = new File(filename);
        if (file.exists()) {
            callback.onSuccess(file.length());
        } else {
            callback.onError(new FileNotFoundException());
        }
    }

    public static void readFile(final String fileName, final Callback<String, IOException> callback) {
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
            callback.onError(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    //nothing to do here
                }
            }
        }
    }

    public static abstract class HandleErrorCallback<RESULT> implements Callback<RESULT, IOException> {
        @Override
        public void onError(final IOException error) {
            System.err.println(error.getMessage());
        }
    }

    public static void main(final String[] args) {
        readFileSize("./src/Main.java", new HandleErrorCallback<Long>() {
            @Override
            public void onSuccess(final Long fileSize) {
                readFile("./src/Main.java", new HandleErrorCallback<String>() {
                    @Override
                    public void onSuccess(final String result2) {
                        System.out.printf("File size: %d\n%s\n", fileSize, result2);
                    }
                });

            }
        });
    }


    /*public static void main(final String[] args) {
        final StringBuilder outputBuilder = new StringBuilder();

        final Callback callback = new Callback<String, IOException>() {
            @Override
            public void onSuccess(final String result) {
                outputBuilder.append(result);
            }

            @Override
            public void onError(final IOException error) {
                throw new RuntimeException(error);
            }
        };

        readFileSize("./src/Main.java", callback);
        readFile("./src/Main.java", callback);
        readFile("./src/Test3.java", callback);

        System.out.println(outputBuilder.toString());
    }*/
}
