package standardClasses.dateAndTime.comparingDateAndTime;

import java.util.*;
import java.time.*;

class StoreClosingTime {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int count = Integer.parseInt(scanner.nextLine());
    LocalTime now = LocalTime.parse("19:30");
    LocalTime arriveAt= now.plusMinutes(30);


    for (int i=0; i<count; i++) {
      String line = scanner.nextLine();
      String[] arr = line.split("\\s+");
      String name = arr[0];
      LocalTime closingTime = LocalTime.parse(arr[1]);

      if (arriveAt.isBefore(closingTime)) {
        System.out.println(name);
      }
    }
  }
}

/*
Stores closing soon

You'd like to visit a grocery store but there is one problem. Now is 19:30 and many stores will be closed soon. You have a list of stores near you. You need exactly 30 minutes to get to a store from the list.

Write a program that determines which stores you will be able to reach.

Input data format

The first line contains a number of stores in the list. Following lines describe the stores with two attributes: store name and the closing time. They are separated by a space (a name has no any spaces).

Output data format

The program must output grocery stores you will be able to reach in 30 minutes. The order of stores in the output should be the same as in the input. Each store is in a new line.


Sample Input 1:
4
Tastyday 20:30
Food 20:00
Zehrs 19:00
Bonus 20:20

Sample Output 1:
Tastyday
Bonus
 */