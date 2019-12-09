import java.util.Scanner;

public class ScannerInput {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine(); // read a whole line, for example "Hello, Java"
    int num = scanner.nextInt(); // read a number, for example 123
    double d = scanner.nextDouble(); // read double, for example 123.01
    String string = scanner.next(); // read a string (not a line), for example "Hello"
    long l = scanner.nextLong(); // read a long

    // useful line to read count in problems
    int count = Integer.parseInt(scanner.nextLine());

    System.out.println(scanner.nextInt()-1);
  }
}
