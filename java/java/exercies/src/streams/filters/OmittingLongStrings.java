package streams.filters;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class OmittingLongStrings {
  public static void main(String[] args) {
    List<String> strings = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
    List<String> shorts = omitLongStrings(strings);

    shorts.stream().forEach(System.out::println);
  }

  public static List<String> omitLongStrings(List<String> strings) {
    return strings.stream()
      .filter(word -> word.length() < 4)
      .collect(Collectors.toList());
  }
}

/*
Given a list of strings, return a list of the strings, omitting any string length 4 or more.

Please, use functional streams to solve the problem.

Example: ["a", "bbb", "cccc", "dddddd"] → ["a", "bbb"]
 */