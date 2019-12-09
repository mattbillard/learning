package misc;

import java.util.*;
import java.util.logging.*;

class LoggerEnum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    String[] arr = line.split("\\s+");

    int sum = 0;
    for (String level : arr) {
      sum += Level.parse(level.toUpperCase()).intValue();
    }

    System.out.println(sum);
  }
}