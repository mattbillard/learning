package streams.reduction;

import java.util.stream.IntStream;

class SumOfSquares {
  public static long rangeQuadraticSum(int fromIncl, int toExcl) {
    return IntStream.range(fromIncl, toExcl).reduce(0, (b, c) -> b + c * c);
  }

  public static void main(String[] args) {
    System.out.println( rangeQuadraticSum(10, 12) );
    System.out.println( rangeQuadraticSum(5, 6) );
    System.out.println( rangeQuadraticSum(3, 3) );
  }
}

/*
Reduction methods  -> Range quadratic sum
Implement the provided method rangeQuadraticSum that takes range borders (fromIncl - inclusive, toExcl - exclusive) and calculates the sum of the squares of the elements which belong to the range.

Please, use streams to solve the problem.


Sample Input 1:
10 12

Sample Output 1:
221

Sample Input 2:
5 6

Sample Output 2:
25

Sample Input 3:
3 3

Sample Output 3:
0
 */