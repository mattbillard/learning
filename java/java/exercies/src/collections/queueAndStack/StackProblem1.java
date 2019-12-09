package collections.queueAndStack;

import java.util.*;

class StackProblem1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int commands = Integer.parseInt(scanner.nextLine());
    Deque<Integer> stackMain = new ArrayDeque<>();
    Deque<Integer> stackMax = new ArrayDeque<>();

    for (int i=0; i<commands; i++) {
      String line = scanner.nextLine().trim();
      String[] arr = line.split("\\s+");

      String command = arr[0];
      Integer num;
      Integer max;
      Integer last;

      switch (command) {
        case "push":
          num = Integer.parseInt(arr[1]);

          // Increment max (solution from: https://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/)
          last = stackMax.peekLast();
          max = last != null && last > num ? last : num;
          stackMax.add(max);

          // Add to stack
          stackMain.add(num);
          break;

        case "pop":
          stackMain.removeLast();
          stackMax.removeLast();
          break;

        case "max":
//          System.out.println("max: "+ stackMax.peekLast());
          System.out.println(stackMax.peekLast());
          break;
      }
//      System.out.println(stackMain);
//      System.out.println(stackMax);
//      System.out.println();
    }
  }
}

/*
Write a program simulating a stack that can effectively return the current max element. Your program should read a sequence of commands of different types from the standard input.

There are three types of commands:

push v - add an element (v) to a top of the stack;
pop - remove the top element of the stack;
max - return the current max in the stack.
The time complexity of these operations should not depend on the stack size (constant time, O(1)).

Sample Input 1:
5
push 2
push 1
max
pop
max

Sample Output 1:
2
2

Sample Input 2:
5
push 1
push 2
max
pop
max

Sample Output 2:
2
1

Sample Input 3:
10
push 2
push 3
push 9
push 7
push 2
max
max
max
pop
max

Sample Output 3:
9
9
9
9
 */