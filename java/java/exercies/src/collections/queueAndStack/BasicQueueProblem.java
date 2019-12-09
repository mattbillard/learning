package collections.queueAndStack;

import java.util.*;

class BasicQueueProblem {

  public static void main(String[] args) {
    Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));

    queue.addLast(5);
    queue.removeFirst();
    queue.removeFirst();

    System.out.println(queue);
  }
}

/*
There is a queue of 4 elements. Put in it one more element - the number 5, and then get 2 items out of the queue.

Sample Input 1:

Sample Output 1:
[3, 4, 5]
*/