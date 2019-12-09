package collections.collectionsUtils;

import java.util.*;

class MultipleSwaps {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> list = Arrays.asList(scanner.nextLine().split("\\s+"));
    int numSwaps = scanner.nextInt();

    for (int i=0; i<numSwaps; i++) {
      Collections.swap(list, scanner.nextInt(), scanner.nextInt());
    }

    System.out.println(String.join(" ", list));
  }
}

/*
Write a program to sequentially swap elements by their indexes in a given list. Indexes of the elements start with 0 and always less than the size of the list.

Try to use standard methods for processing collections.

Input data format

The first line contains elements of the list. The second line contains the number of swaps. Then follows the lines with descriptions of the swaps. Each line contains two numbers - indexes of swapped elements.

Output data format

All elements of the modified list separated by spaces must be output in one line.


Sample Input 1:
1 2 3 4 5 6
2
0 1
3 4

Sample Output 1:
2 1 3 5 4 6
 */