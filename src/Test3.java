public class Test3 {
    interface Callback {
        void onSuccess(final String result);

        void onError(final Throwable error);
    }

    public static void readFile(final String fileName, final Callback callback) {
        // TODO: Implement
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
