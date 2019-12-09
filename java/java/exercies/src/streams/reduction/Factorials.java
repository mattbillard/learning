package streams.reduction;

import java.util.stream.LongStream;

class Factorials {
  public static long factorial(long n) {
    long result = LongStream.rangeClosed(1, n).reduce(1, (b, c) -> b * c);
    return result;
  }

  public static void main(String[] args) {
    System.out.println( factorial(0) );
    System.out.println( factorial(1) );
    System.out.println( factorial(2) );
    System.out.println( factorial(3) );
    System.out.println( factorial(4) );
    System.out.println( factorial(5) );
  }
}

/*
Reduction methods  -> Calculating factorials

47 users successfully solved this problem.  It was last completed 1 day ago .
Many java developers wrote methods to calculate a factorial value using a recursive or iterative algorithm. It's time to do it with streams.

The factorial of n is calculated by the product of integer number from 1 to n (inclusive). The factorial of 0 is equal to 1.

Important. Use the given template for your factorial method. Pay attention to type of an argument and the returned value. Please, don't use cycles or recursion.


Sample Input 1:
0

Sample Output 1:
1

Sample Input 2:
1

Sample Output 2:
1

Sample Input 3:
2

Sample Output 3:
2
 */