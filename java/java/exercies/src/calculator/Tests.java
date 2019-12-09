package calculator;

import java.util.*;

public class Tests {
  int testCounter = 0;
  Calculator calculator = new Calculator();

  public static void main(String[] args) {
    Tests tests = new Tests();
    tests.runTests();
  }

  void runTests() {
    runTest("   ", "");

    runTest("/help", "This program is a calculator.");
    runTest("/exit", "Bye!");
    runTest("/unknown", "Unknown command");

    runTest(" 2 ", "2");
    runTest("2+2", "4");
    runTest(" 2 + 2 ", "4");

    runTest("a", "Unknown variable");
    runTest("a1 = 8", "Invalid identifier");
    runTest("n = a2a", "Invalid assignment");
    runTest("a = 7 = 8", "Invalid assignment");

    runTest(" a = 2 \n a", "2");
    runTest(" a = 2 \n b = 3 \n c = a + b \n c ", "5");
    runTest(" z = 5 \n x = y = z \n x ", "5");

    runTest(" 1 + 2 + 3 ", "6");
    runTest(" 2 * 3 * 4 ", "24");
    runTest(" 3 - 2 + 1 ", "2");
    runTest(" 100 / 10 / 5 ", "2");

    runTest(" 2 + + 2 ", "4");
    runTest(" 2 - + 2 ", "0");
    runTest(" 2 + - 2 ", "0");

    runTest("2 + + + - - - + + + - - - 2", "4");
    runTest("2 - - - + + + - - - + + + 2", "4");

    runTest(" 2 2 ", "Invalid expression");
    runTest(" 2 + ", "Invalid expression");
    runTest(" 2 + 2 +", "Invalid expression");

    runTest("123\n456\n/exit", "123\n456\nBye!");

    runTest(
      "4 + 6 - 8\n\n\n2 - 3 - 4\n\n8 + 7 - 4\n/exit",
      "2\n-5\n11\nBye!"
    );
    runTest(
      "/command\n/exit",
      "Unknown command\nBye!"
    );
    runTest(
      "n = 3\nm=4\na =   5\nb = a\nn\nm\na\nb\ncount = 10\ncount\n/exit",
      "3\n4\n5\n5\n10\nBye!"
    );
    runTest(
      "a = 3\nb = 4\nc = 5\na + b - c\nb - c + 4 - a\na = 800\na + b + c\n/exit",
      "2\n0\n809\nBye!"
    );
    runTest(
      "a = 1\na = 2\na = 3\na\n/exit",
      "3\nBye!"
    );
    runTest(
      "q\nr\nq = 10\nr = 20\nq\nr\nR\n/exit",
      "Unknown variable\nUnknown variable\n10\n20\nUnknown variable\nBye!"
    );
    runTest(
      "a1 = 8\nn = a2a\na = 7 = 8\nnum = 10\n/exit",
      "Invalid identifier\nInvalid assignment\nInvalid assignment\nBye!"
    );

  }

  void runTest(String input, String expected) {
    testCounter++;

    ArrayList<Object> outputs = new ArrayList<>();
    String[] lines = input.split("\n");

    // Process all lines. Accumulate results
    for (String line : lines) {
      Object output = calculator.doCalc(line);

      // Null result
      if (output == null) {
        continue;
      }

      // Add output
      outputs.add(output);
    }

    // Compare actual to expected
    String actual = "";
    for (Object output : outputs) {
      actual += output + "\n";
    }
    boolean success = expected.equals(actual.trim());

    // Output FAILED or SUCCESS
    if (!success) {
      System.out.println("-------------------");
      System.out.println(testCounter + ") FAILED ");
      System.out.println("\nINPUT\n" + input);
      System.out.println("\nEXPECTED\n" + expected);
      System.out.println("\nACTUAL\n" + actual);
      System.out.println("-------------------");
    } else {
      System.out.println(testCounter + ") SUCCESS ");
    }
  }
}
