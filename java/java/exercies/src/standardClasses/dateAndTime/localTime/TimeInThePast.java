package standardClasses.dateAndTime.localTime;

import java.util.*;
import java.time.*;

class TimeInThePast {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    LocalTime time = LocalTime.parse(line);

    int hours = scanner.nextInt();
    int mins = scanner.nextInt();

    LocalTime timeBefore = time.minusHours(hours).minusMinutes(mins);

    System.out.println(timeBefore);

  }
}

/*
Write a program that reads a point in time and prints another point before this at the specified number of hours and minutes.

Input data format

The first line contains a point in time like 18:10 (hours:minutes). The second line contains two numbers - hours and minutes separated by a space.

Output data format

The single output line should contain a point in time before the input time in the same format.

Sample Input 1:
18:10
2 30

Sample Output 1:
15:40

 */
