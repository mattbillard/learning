package misc;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * DOUBLE FACTORIAL...
 *
 * 7!! = 7*5*3*1
 * 8!! = 8*6*4*2
 */

public class BigInt {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
    int n = Integer.parseInt(line);
    System.out.println(calcDoubleFactorial(n));
  }

  public static BigInteger calcDoubleFactorial(int n) {
    BigInteger two = new BigInteger("2");
    BigInteger result = BigInteger.ONE;

    BigInteger num = BigInteger.valueOf(n);

    while(num.compareTo(BigInteger.ONE) == 1) {
      result = result.multiply(num);
      num = num.subtract(two);
    }

    return result;
  }
}