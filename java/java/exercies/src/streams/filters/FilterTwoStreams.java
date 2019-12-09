package streams.filters;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FilterTwoStreams {
  public static void main(String[] args) {
    IntStream odds = Stream.of(1,3,5).mapToInt(Integer::intValue);
    IntStream evens = Stream.of(30, 75, 60, 90).mapToInt(Integer::intValue);

    IntStream results = createFilteringStream(evens, odds);
    results.forEach(System.out::println);
  }

  public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
    return IntStream
      .concat(oddStream, evenStream)
      .filter(n -> n%3 ==0)
      .filter(n -> n%5 ==0)
      .sorted()
      .skip(2)
      ;
  }
}

/*
You have two IntStream. The first stream contains even numbers and the second stream contains odd numbers. Create the third stream that contains numbers from both streams which is divisible by 3 and 5. After calling collect(Collectors.toList()) the stream should return sorted list (ascending) of these numbers. Two first suitable numbers in the sorted list must be skipped.

Important. You need return a prepared IntStream from a template method, not a list of integers. Pay attention to the method template. Do not change the signature of this method.
 */