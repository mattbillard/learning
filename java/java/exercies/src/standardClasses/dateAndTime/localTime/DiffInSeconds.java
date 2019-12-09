package standardClasses.dateAndTime.localTime;

import java.util.*;
import java.time.*;

class DiffInSeconds {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    LocalTime time1 = LocalTime.parse(scanner.nextLine());
    LocalTime time2 = LocalTime.parse(scanner.nextLine());

    int diff = Math.abs( time1.toSecondOfDay() - time2.toSecondOfDay() );
    System.out.println(diff);
  }
}

/*
Implement a method that takes two instances of LocalTime and determines how many seconds between them.

Sample Input 1:
00:00:01
00:00:05

Sample Output 1:
4

Sample Input 2:
02:00:03
00:00:01

Sample Output 2:
7202
 */