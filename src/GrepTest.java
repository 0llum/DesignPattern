import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;

public class GrepTest {
    @Test
    public void shouldReturnEmptyArrayWhenSearchedStringNotFound() {
        final String[] actual = Grep.grep("notfound", "content");
        assertThat(actual.length, equalTo(0));
    }

    @Test
    public void shouldReturnNonEmptyArrayWhenSearchedStringEqualsContent() {
        final String[] actual = Grep.grep("content", "content");

        assertThat(actual.length, equalTo(1));
        assertThat(actual[0], equalTo("content"));
    }

    @Test
    public void shouldThrowExceptionWhenSearchedStringIsNull() throws NullPointerException{
        final String[] actual = Grep.grep(null, "content");
        assertThat(actual.length, equalTo(0));
    }

    @Test
    public void shouldThrowExceptionWhenContentIsNull() throws NullPointerException{
        final String[] actual = Grep.grep("string", null);
        assertThat(actual.length, equalTo(0));
    }

    @Test
    public void shouldReturnNonEmptyArrayWhenContentContainsSearchedString() {
        final String[] actual = Grep.grep("string", "this is a string");
        assertThat(actual.length, equalTo(1));
    }

    @Test
    public void shouldReturnNonEmptyArrayWhenContentContainsSearchedStringAsSubstring() {
        final String[] actual = Grep.grep("string", "a guitar has six strings");
        assertThat(actual.length, equalTo(1));
    }

    @Test
    public void shouldReturnNonEmptyArrayWhenContentContainsSearchedStringCaseInsensitive() {
        final String[] actual = Grep.grep("string", "String");
        assertThat(actual.length, equalTo(1));
    }
}
