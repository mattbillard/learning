package multiarray;

import java.util.*;

class RotateMultiArray {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int Y = scanner.nextInt();
    int X = scanner.nextInt();

    int[][] original = new int[Y][];
    for (int y=0; y<Y; y++) {

      int[] row = new int[X];
      for (int x=0; x<X; x++) {
        int num = scanner.nextInt();
        row[x] = num;
      }

      original[y] = row;
    }

//    for (int i=0; i<original.length; i++) {
//      System.out.println(Arrays.toString(original [i]));
//    }




//    int X = 4;
//    int Y = 3;
//
//    int[][] original = new int[Y][];
//    original[0] = new int[] { 11, 12, 13, 14 };
//    original[1] = new int[] { 21, 22, 23, 24 };
//    original[2] = new int[] { 31, 32, 33, 34 };




    // Create new array
    int[][] rotated = new int[X][];
    for (int a=0, y=0; y<X; a++, y++) {

      int[] row = new int[Y];
      for (int b=Y-1, x=0; x<Y; b--, x++) {
        int  num = original[b][a];
        row[x] = num;
      }

      rotated[y] = row;
    }


    // Output
    for (int y=0; y<rotated.length; y++) {

      int[] row = rotated[y];
      String str = "";
      for (int x=0; x<row.length; x++) {
        str += row[x] + " ";
      }

      System.out.println(str.trim());
    }
  }

  public static void officialSolution(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    for (int i = 0; i < matrix[0].length; ++i) {
      for (int j = 0; j < matrix.length; ++j) {
        System.out.print(matrix[matrix.length - j - 1][i] + " ");
      }
      System.out.println();
    }
  }
}

/*
Given a rectangle array n×m in size. Rotate it by 90 degrees clockwise, by recording the result into the new array m×n in size.

Input data format
Input the two numbers n and m, not exceeding 100, and then an array n×m in size.

Output data format
Output the resulting array. Separate numbers by a single space in the output.

Sample Input 1:
3 4
11 12 13 14
21 22 23 24
31 32 33 34

Sample Output 1:
31 21 11
32 22 12
33 23 13
34 24 14
*/