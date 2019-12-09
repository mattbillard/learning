package standardClasses.dateAndTime.localDateTime;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class LocalDateTimeWithFormatter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    int N = scanner.nextInt();

    LocalDateTime dt = LocalDateTime.parse(line);
    dt = dt.plusMinutes(N);

    int year = dt.getYear();
    int dayOfYear = dt.getDayOfYear();
    int secs = dt.getSecond();

    String pattern = secs == 0 ? "HH:mm" : "HH:mm:ss";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    String out = year+" "+dayOfYear+" "+dt.format(formatter);

    System.out.println(out);
  }
}

/*
Write a program that reads date-time, adds N minutes to it and then prints resulting year, day of the year, hours and minutes. The input date-time format like "2017-12-31T22:30:15". The result date must be similar to "2018 139 19:50:15" (year, day of the year, hours, minutes, seconds). If the result has no seconds, the program must not print them.

Input data format
The first line contains a date-time. The second line contains a number of minutes (N) to add.

Output data format
The single line must contain a string with the result.

Sample Input 1:
2017-12-31T22:30:15
200000

Sample Output 1:
2018 139 19:50:15



Sample Input 2:
2017-05-05T15:20
20

Sample Output 2:
2017 125 15:40



Sample Input 3:
2017-01-01T01:01:01
5000000

Sample Output 3:
2026 186 06:21:01
 */