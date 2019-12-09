package streams.pipelines;

import java.util.stream.LongStream;

class SumOfOdds {
  public static long sumOfOdds(long a, long b) {
    long sum = LongStream.rangeClosed(a, b)
            .filter(x -> x % 2 == 1)
            .sum();
    return sum;
  }

  public static void main(String[] args) {
    System.out.println( sumOfOdds(0, 0) );
    System.out.println( sumOfOdds(7, 9) );
    System.out.println( sumOfOdds(21, 30) );
  }
}

/*
Stream pipelines  -> The sum of odd numbers
Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.


Sample Input 1:
0 0

Sample Output 1:
0

Sample Input 2:
7 9

Sample Output 2:
16

Sample Input 3:
21 30

Sample Output 3:
125
 */