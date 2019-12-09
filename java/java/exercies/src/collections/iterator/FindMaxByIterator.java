package collections.iterator;

import java.util.*;
import java.util.stream.Collectors;

class FindMaxByIterator {

  public static int findMaxByIterator(Iterator<Integer> iterator) {
    int max = iterator.next();
    while (iterator.hasNext()) {
      int num = iterator.next();
      if (num > max) {
        max = num;
      }
    }

    return max;
  }

  /* Do not change code below */
  public static void main(String[] args) {

    final Scanner scanner = new Scanner(System.in);

    final List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(findMaxByIterator(list.iterator()));
  }
}

/*
Implement a method that returns the max number in a collection using the iterator. It's guaranteed the collection always has at least one element.

Sample Input 1:
1 3 8 4 5

Sample Output 1:
8
 */