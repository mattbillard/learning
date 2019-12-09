package calculator;

import java.util.Scanner;

public class Main {
  Calculator calculator = new Calculator();

  public static void main(String[] args) {
    Main app = new Main();
    app.processUserInput();
  }

  void processUserInput() {
    Scanner scanner = new Scanner(System.in);

    // Keep taking input until they quit
    Object result;
    while (true) {
      String line = scanner.nextLine().trim();
      result = calculator.doCalc(line);

      // Null result
      if (result == null) {
        continue;
      }

      // Output
      System.out.println(result);

      // Quit app
      if (result.equals("Bye!")) {
        return;
      }
    }
  }
}
