package streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PartitioningExamples {
  public static void main(String[] args) {
    Stream<Integer> stream1 = Stream.of(5, 1, 9, -2, -5, 1);
    Stream<Integer> stream2 = Stream.of(5, 1, 9, -2, -5, 1);

    Map<Boolean, Long> map1 = stream1.collect(Collectors.partitioningBy(n -> n > 0, Collectors.summingLong(x -> x)));
    Map<Boolean, List<Integer>> map2 = stream2.collect(Collectors.partitioningBy(a -> a >= 0));

    System.out.println(map1);
    // {false=-7, true=16}

    System.out.println(map2);
    // {false=[-2, -5], true=[5, 1, 9, 1]}
  }
}