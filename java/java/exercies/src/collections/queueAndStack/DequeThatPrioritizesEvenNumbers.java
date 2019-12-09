package collections.queueAndStack;

import java.util.*;

class DequeThatPrioritizesEvenNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int commands = Integer.parseInt(scanner.nextLine());
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i=0; i<commands; i++) {
      Integer num = Integer.parseInt(scanner.nextLine().trim());

      // even
      if (num % 2 == 0) {
        deque.addFirst(num);

        // odd
      } else {
        deque.addLast(num);
      }
    }

    for (int i=0; i<commands; i++) {
      System.out.println(deque.pollFirst());
    }
  }
}

/*
Write a program that reads numbers and stores them to a deque. An even number should be added as the first element, an odd number - as the last. After, the program must output all elements from the first to the last.

The first string contains the number of elements. Each line followed the first one contains an element.

Sample Input 1:
4
1
2
3
4

Sample Output 1:
4
2
1
3
 */