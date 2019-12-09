package collections.queueAndStack;

import java.util.*;

public class LoadBalancer {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Deque<String> q1 = new ArrayDeque<>();
    Deque<String> q2 = new ArrayDeque<>();
    int load1 = 0;
    int load2 = 0;

    int count = Integer.parseInt(scanner.nextLine());
    for (int i=0; i<count; i++) {
      String line = scanner.nextLine();
      String[] arr = line.split("\\s+");

      int task = Integer.parseInt(arr[0]);
      int load = Integer.parseInt(arr[1]);

      if (load2 < load1) {
        load2 += load;
        q2.addLast(Integer.toString(task));
      } else {
        load1 += load;
        q1.addLast(Integer.toString(task));
      }
    }

    String result1 = String.join(" ", new ArrayList(q1));
    String result2 = String.join(" ", new ArrayList(q2));

    System.out.println(result1);
    System.out.println(result2);
  }
}

/*
Write a program that implements a simple load balancer.

The program must read tasks from the standard input and distribute them between two queues. Tasks will be processed by a system (in future). Each task has a unique identifier and a number indicating the load on the system (in parrots).

The balancer should distribute tasks between queues by the following rule - the task is added to the lower-load queue (by the total load). If both queues have the same total load indicator, the task must be added to the first queue.

It's guaranteed, the input data contain at least two tasks.

Input data format

The first line contains the number of tasks. Other lines consist of task descriptions - an identifier and a load indicator (separated by a space).

Output data form

The first line should contain identifiers of tasks in the first queue, the second line - in the second queue.


Sample Input 1:
6
1 1
2 1
3 1
4 3
5 1
6 1

Sample Output 1:
1 3 5 6
2 4
 */