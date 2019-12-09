package streams.filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FilterBadWords {
  public static void main(String[] args) {
    String text = "The quick brown Fox jumped over the lazy dog";
    List<String> badWords = Arrays.asList("the", "fox");

    Stream<String> found = createBadWordsDetectingStream(text, badWords);
    System.out.println( found.collect(Collectors.toList()) );
  }

  public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
    String[] arr = text.split("\\s+");
    List<String> list = Arrays.asList(arr);

    return list.stream()
      .map(String::toLowerCase)
      .distinct()
      .filter(word -> badWords.contains(word))
      .sorted();
  }
}

/*
Create a stream that will detect bad words in a text according to a bad words list. All words in the text are divided by whitespaces (always only one whitespace between two words).

After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text. The result should be dictionary ordered (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.
 */