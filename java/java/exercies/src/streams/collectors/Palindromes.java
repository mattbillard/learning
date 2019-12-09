package streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Palindromes {
  public static void main(String[] args) {

    Map<Boolean, List<String>> collect = Stream.of("level", "bbaa", "ac")
      .collect(
        Collectors.partitioningBy(
          word -> word.equals(new StringBuilder(word).reverse().toString())
        )
      );
    System.out.println(collect);
  }
}

/*
Write a collector that partitions all words in a stream into two groups: palindromes (true) and usual words (false). The collector should return Map<Boolean, List<String>>. All input words will be in the same case (lower).

Hint: the method reverse() of StringBuilder may help you.

Examples of the valid solution formats: Collectors.reducing(...) or reducing(...)

Sample Input 1:
aaaa aaa a aa

Sample Output 1:
{false=[], true=[aaaa, aaa, a, aa]}

Sample Input 2:
level bbaa ac

Sample Output 2:
{false=[bbaa, ac], true=[level]}
 */