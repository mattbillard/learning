package standardClasses.mathRandom;

import java.util.*;
import java.util.Random;

class SumOfRandomNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int from = scanner.nextInt();
    int to = scanner.nextInt();

    Random random = new Random(from+to);

    int sum = 0;
    for (int i=0; i<N; i++) {
      sum += random.nextInt(to - from + 1) + from;
    }

    System.out.println(sum);

  }
}

/*
Given the number N, and the numbers A and B, output sum of the first N random numbers in a range from A to B inclusively. The seed should be a number A+B.

Input contains numbers N, A, B in a single line in this order.

Sample Input 1:
100 5 10

Sample Output 1:
734
 */