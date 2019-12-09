package multiarray;

import java.util.*;
import java.util.regex.*;

class TheaterMultiArray {

  public static void main(String[] args) {
    int index = work();
    System.out.println(index+1);
  }

  public static int work() {
    Scanner scanner = new Scanner(System.in);

    final int Y = scanner.nextInt();
    final int X = scanner.nextInt();

    int[][] seats = new int[Y][];
    for (int y=0; y<Y; y++) {

      int[] row = new int[X];
      for (int x=0; x<X; x++) {
        int num = scanner.nextInt();
        row[x] = num;
      }

      seats[y] = row;
    }

    int desired = scanner.nextInt();


//    for (int i=0; i<seats.length; i++) {
//      System.out.println(Arrays.toString(seats[i]));
//    }



    // My solution: use regex to look for N number of consecutive seats
    for (int y=0; y<seats.length; y++) {

      int[] row = seats[y];
      String text = "";
      for (int x=0; x<row.length; x++) {
        text += row[x];
      }

      String lookingFor = "0{"+ desired +",}";
      boolean found = Pattern.compile(lookingFor).matcher(text).find();

//      System.out.println(text);
//      System.out.println(text + found);

      if (found) {
        return y;
      }
    }

    return -1;
  }


  public static void officialSolution(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] matrix = new int[scanner.nextInt()][scanner.nextInt()];
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[i].length; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }

    int required = scanner.nextInt();
    int result = 0;

    for (int i = 0; i < matrix.length; ++i) {
      int count = 0;
      for (int j = 0; j < matrix[i].length; ++j) {
        if (matrix[i][j] == 0) {
          ++count;
          if (count == required) {
            result = i + 1;
            break;
          }
        } else {
          count = 0;
        }
      }
      if (result != 0) {
        break;
      }
    }

    System.out.println(result);
  }
}

/*
The cinema has n rows, each consisting of m seats (n and m do not exceed 20). The two-dimensional matrix stores the information on the sold tickets, number 1 means that the ticket for this place is already sold, the number 0 means that the place is available. You want to buy k tickets to the neighbouring seats in the same row. Find whether it can be done.

Input data format
On the input, the program gets the numbers n and m. Next go n lines, each containing m numbers (0 or 1), separated by spaces. Next goes the number k.

Output data format
The program should output the row number in which there are k consecutive available seats. If there are several such rows, output the number of the smallest such row. If there is no such row, output the number 0.


Sample Input 1:
3 4
0 1 0 1
1 0 0 1
1 1 1 1
2

Sample Output 1:
2
*/