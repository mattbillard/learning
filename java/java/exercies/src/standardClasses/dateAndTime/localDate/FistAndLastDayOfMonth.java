package standardClasses.dateAndTime.localDate;

import java.time.*;
import java.util.*;

class FistAndLastDayOfMonth {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int year = scanner.nextInt();
    int month = scanner.nextInt();

    LocalDate start = LocalDate.of(year, month, 1);
    LocalDate end = start.withDayOfMonth( start.lengthOfMonth() );

    System.out.println(start + " " + end);

  }
}

/*
Write a program that reads a year and a month and outputs the first and the last day of the month.
Sample Input 1:

2017
1

Sample Output 1:
2017-01-01 2017-01-31
 */