package streams.reduction;

import java.util.Scanner;
import java.util.stream.IntStream;

class SumOfDivisors {
  public static int sumOfDivisors(int a, int b, int n, int m) {
    return IntStream
            .rangeClosed(a, b)
            .filter(x -> x%n==0 || x%m==0)
            .reduce(0, (result, next) -> result + next);
  }

  public static void main(String[] args) {
//    System.out.println( sumOfDivisors(10, 20, 2, 3) );

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    System.out.println( sumOfDivisors(a, b, n, m) );
  }
}

/*
Reduction methods  -> Sum of divisors
For a given range from A to B both inclusive, count sum of numbers that are only divisible by N or M. Use streams to solve the problem.

For example, for range from 10 to 20 and N = 2, M = 3, there are 6 numbers that are divisible by N or M - 10, 12, 14, 15, 16, 18, 20. And their sum equals 105.

Input contains a single line with four numbers - A, B, N, M.

Sample Input 1:
10 20 2 3

Sample Output 1:
105

 */
