public class Grep {
    public static String[] grep(final String search, final String content) {
        String[] result;
        if (null == search) {

        }
        if (search.equals(content)) {
            result = new String[] {
                    content
            };
            return result;
        }

        if (content.contains(search)) {
            result = new String[] {
                    content
            };
            return result;
        }

        if (content.toLowerCase().contains(search.toLowerCase())) {
            result = new String[]{
                    content
            };
            return result;
        }

        return new String[0];
    }
}
