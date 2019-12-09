package streams.mapAndFlatMap;

import java.util.*;

class MaximumAbsoluteValue {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    String[] arr = input.split("\\s+");
    List<String> list = Arrays.asList(arr);

    Optional<Integer> max = list.stream()
      .map(Integer::parseInt)
      .map(Math::abs)
      .max(Integer::compare);

    System.out.println( max.get() );
  }
}

/*
For a given array, output the maximum of absolute values in the array.
Try not to use the for loop, but use Stream API.

Use .getAsInt() to convert from OptionalInt (returned by .max() ) to int.
 */