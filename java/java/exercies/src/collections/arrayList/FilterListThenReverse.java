package collections.arrayList;

import java.util.*;
import java.util.stream.Collectors;

class FilterListThenReverse {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> list1 = Arrays
      .stream(scanner.nextLine().split("\\s+"))
      .map(Integer::parseInt)
      .collect(Collectors.toList());

    List<String> list2 = new ArrayList<>();
    for (int i=0; i< list1.size(); i++) {
      if (i % 2 == 1) {
        list2.add(""+list1.get(i));
      }
    }

    Collections.reverse(list2);

    System.out.println(String.join(" ", list2));
  }
}

/*
Write a program that reads the list of integer number separated by spaces from the standard input and then remove all numbers with even indexes (0, 2, 4, and so on). After, the program should output the result sequence in the reverse order.

Sample Input 1:
1 2 3 4 5 6 7

Sample Output 1:
6 4 2
 */