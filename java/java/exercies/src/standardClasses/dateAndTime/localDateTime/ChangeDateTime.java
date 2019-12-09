package standardClasses.dateAndTime.localDateTime;

import java.util.*;
import java.time.*;

class ChangeDateTime {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    int hours = scanner.nextInt();
    int mins = scanner.nextInt();

    LocalDateTime d1 = LocalDateTime.parse(line);
    LocalDateTime d2 = d1.minusHours(hours).plusMinutes(mins);

    System.out.println(d2);
  }
}

/*
Write a program that subtracts N hours and adds M minutes to a date-time pair.

Input data format
The first line contains a date-time pair (year-month-dayThours:minutes). The second line contains two numbers separated by a space: hours to subtract and minutes to add.

Output data format
A single line with a date-time pair (year-month-dayThours:minutes).

Sample Input 1:
2017-12-15T11:11
1 58

Sample Output 1:
2017-12-15T11:09

Sample Input 2:
2016-11-22T00:00
5000 300010

Sample Output 2:
2016-11-22T00:10

 */