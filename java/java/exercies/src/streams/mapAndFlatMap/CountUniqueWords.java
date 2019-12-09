package streams.mapAndFlatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class CountUniqueWords {

  // Official solution
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final int number = scanner.nextInt();
    scanner.nextLine();

    System.out.println(Stream.generate(() -> Arrays.stream(scanner.nextLine().split("\\s+")))
      .limit(number)
      .flatMap(s -> s)
      .map(String::toLowerCase)
      .distinct()
      .count());
  }

  // My solution
  public static void main2(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int numLines = Integer.parseInt(scanner.nextLine());

    // Create list-of-lists
    List<List<String>> listOfLists = new ArrayList<>();
    for (int i=0; i<numLines; i++) {
      List<String> list = Arrays.asList(scanner.nextLine().split("\\s+"));
      listOfLists.add(list);
    }

    // flatMap, lowerCase, distinct, count
    long count = listOfLists.stream()
      .flatMap(list -> list.stream())
      .map(String::toLowerCase)
      .distinct()
      .count();

    System.out.println( count );
  }
}

/*
For given lines with words, count the number of unique words ignoring case sensitivity.

The first line contains the number N - the next N lines contain words separated by a space.


Sample Input 1:
3
Word word wORD
line Line SplinE word
spline align Java java

Sample Output 1:
5
 */