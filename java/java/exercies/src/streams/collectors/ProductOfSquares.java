package streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ProductOfSquares {
  public static long productOfSquares(List<Integer> numbers) {
    // NOTE: just using reduce is simpler:
    // numbers.stream().reduce(1, (b, c) -> b * c * c);

    long val = numbers.stream().collect( Collectors.reducing(1, (b, c) -> b * c * c) );
    return val;
  }

  public static void main(String[] args) {
    System.out.println( productOfSquares(Arrays.asList(0, 1, 2, 3)) );
    System.out.println( productOfSquares(Arrays.asList(1, 2)) );
  }
}