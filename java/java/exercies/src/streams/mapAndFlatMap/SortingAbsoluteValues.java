package streams.mapAndFlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SortingAbsoluteValues {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String[] arr = input.split("\\s+");
    List<String> list = Arrays.asList(arr);

    String result = list.stream()
            .map(Integer::parseInt)
            .map(Math::abs)
            .sorted()
            .map(x -> x + "") // Really wish I had a better solution for int->string but Integer::toString won't compile
            .collect(Collectors.joining(" "));

    System.out.println(result);
  }
}

/*
For a given array, output the sorted array of absolute values. You should sort the array in the ascending order.
Try not to use the for loop, but use Stream API.

Sample Input 1:
1 2 6 -3 -9

Sample Output 1:
1 2 3 6 9
 */