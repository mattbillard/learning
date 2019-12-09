package standardClasses.dateAndTime.comparingDateAndTime;

import java.util.*;
import java.time.*;

class BetweenTwoDates {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    String[] arr = line.split("\\s+");

    LocalDate d1 = LocalDate.parse(arr[0]);
    LocalDate d2 = LocalDate.parse(arr[1]);
    LocalDate d3 = LocalDate.parse(arr[2]);

    boolean result = (d1.isAfter(d2) && d1.isBefore(d3)) || (d1.isBefore(d2) && d1.isAfter(d3));
    System.out.println(result);
  }
}

/*
Is the date between two other dates?

Write a program that reads three dates from the standard input and checks that the first date is between the second and the third but doesn't equal to them.

Input data format

The single line contains three dates separated by the space character. Each date has the format year-month-day.

Output data format

The program must output "true" or "false".


Sample Input 1:
2017-10-13 2017-10-11 2017-10-15

Sample Output 1:
true

Sample Input 2:
2017-05-06 2017-12-31 2017-01-01

Sample Output 2:
true

Sample Input 3:
2017-04-04 2017-05-05 2017-06-06

Sample Output 3:
false
 */