package standardClasses.mathRandom;

import java.util.*;
import java.util.Random;

class FindTheSeed {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int A = scanner.nextInt();
    int B = scanner.nextInt();
    int N = scanner.nextInt();    // N numbers
    int K = scanner.nextInt();    // random 0-K

    int answerSeed = A;
    int min = K;

    for (int seed=A; seed<=B; seed++) {
//      System.out.println("seed: "+seed);
      Random random = new Random(seed);

      int max = 0;
      for (int i=0; i<N; i++) {
        int num = random.nextInt(K);
        max = num > max ? num : max;
//        System.out.println(num);
      }

      if (max < min) {
        min = max;
        answerSeed = seed;
      }

//      System.out.println();
    }

//    System.out.println("----------------------");
    System.out.println(answerSeed);
    System.out.println(min);
  }
}

/*
7 9 4 100

Find the seed between A and B inclusively that produces N pseudorandom numbers from 0 inclusive to K exclusive and have the maximum of these N numbers be the minimum among all maximums of other seeds in this range.

For example, we have N=4, A=7, B=9, K=100. Suppose,
for the seed 7 we have sequence 45, 99, 23, 67 - the maximum is 99.
For the seed 8, we have 64, 34, 23, 9 - the maximum is 64.
For the seed 9, we have 78, 34, 0, 11 - the maximum is 78.
The minimum among these maximums is 64 form the seed 8, therefore, in this case, the program should output 8.

If there are some seeds with equal minimal maximums, you should output the seed which is less than all other seeds.

The input contains numbers A, B, N, K in a single line.

You should output 2 numbers - a seed and it's maximum.

Sample Input 0:
7 9 4 100
8
64

Sample Input 1:
0 100 5 1000

Sample Output 1:
18
270

Sample Input 2:
0 100 1000 1000

Sample Output 2:
5
993

Sample Input 3:
0 100 10000 1000

Sample Output 3:
0
999
 */