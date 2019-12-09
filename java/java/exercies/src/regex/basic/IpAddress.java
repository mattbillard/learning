package regex.basic;

import java.util.Scanner;

public class IpAddress {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine(); // a valid or invalid registration number

    String reg = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    boolean result = str.matches(reg);
    System.out.println(result ? "YES" : "NO");
  }
}
