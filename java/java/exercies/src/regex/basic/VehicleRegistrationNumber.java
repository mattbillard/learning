package regex.basic;

import java.util.Scanner;

public class VehicleRegistrationNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String regNum = scanner.nextLine(); // a valid or invalid registration number

    String reg = "[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}";
    boolean result = regNum.matches(reg);
    System.out.println(result);
  }
}
