package standardClasses.dateAndTime.localDate;

import java.time.*;
import java.util.*;

class AllTheMondaysInAMonth {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int year = scanner.nextInt();
    int month = scanner.nextInt();

    LocalDate date = LocalDate.of(year, month, 1);

    while(true) {
//      System.out.println(date + " " + date.getDayOfWeek().name());
      if ( date.getDayOfWeek().name().equals("MONDAY") ) {
        System.out.println( date );
      }
      date = date.plusDays(1);

      if (date.getMonthValue() != month) {
        break;
      }

    }

  }
}

/*
Write a program that reads a year and the number of a month (1-12) and prints dates of all Mondays in this month from the first to the last date.
Sample Input 1:

2017 1

Sample Output 1:
2017-01-02
2017-01-09
2017-01-16
2017-01-23
2017-01-30

 */