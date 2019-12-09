package calculator;

import java.util.*;

class Calculator {
  Map<String, Integer> vars = new HashMap<>();

  Object doCalc(String input) {
    try {
      input = removeExtraPlusesAndMinuses(input.trim());

      // No input
      if (input.length() == 0) {
        return null;
      }

      // Menu
      if (input.charAt(0) == '/') {
        return outputMenu(input);
      }

      // Var assign
      if (input.matches(".*=.*")) {
        return doVarAssign(input);
      }

      // Else do some math
      return evaluateMath(input);

    } catch(RuntimeException e) {
      // Output error
      return e.getMessage();
    }
  }

  Integer evaluateMath(String input) throws RuntimeException {
    ArrayDeque<String> q = new ArrayDeque<>(Arrays.asList(input.split("\\b")));

    Integer result = itemToInt(nextFromQueue(q));

    // Do math item by item, left to right
    while(q.size() > 0) {
      String next = q.remove().trim();
      Integer right = itemToInt(nextFromQueue(q));

      switch (next) {
        case "+":
          result += right;
          break;

        case "-":
          result -= right;
          break;

        case "*":
          result *= right;
          break;

        case "/":
          result /= right;
          break;

        default:
          throw new RuntimeException("Invalid expression");
      }
    }

    return result;
  }

  Integer itemToInt(String item) throws RuntimeException {
    // Variable -> int
    if (item.matches("[a-zA-Z]+")) {
      Integer val = vars.getOrDefault(item, null);
      if (val == null) {
        throw new RuntimeException("Unknown variable");
      }
      return val;
    }

    // Int
    if (item.matches("\\d+")) {
      return Integer.parseInt(item);
    }

    // Note: spec is wrong this should probably be something else
    throw new RuntimeException("Invalid assignment");
  }

  String outputMenu(String input) throws RuntimeException {
    switch(input) {
      case "/help":
        return "This program is a calculator.";

      case "/exit":
        return "Bye!";

      default:
        throw new RuntimeException("Unknown command");
    }
  }

  String doVarAssign(String input) throws RuntimeException {
    ArrayDeque<String> stack = new ArrayDeque<>(Arrays.asList(input.split("=")));

    // Assign variables, right to left (e.g. a = b = 4)
    Integer right = evaluateMath(stack.removeLast().trim());
    while(stack.size() > 0) {
      String var = stack.removeLast().trim();

      // throw if tring to assign to an int or something similarly dumb
      if (var.matches("\\d+")) {
        throw new RuntimeException("Invalid assignment");

        // throw if variable name is not just letters
      } else if (var.matches("[a-zA-Z]+") != true) {
        throw new RuntimeException("Invalid identifier");
      }

      vars.put(var, right);
    }

    return null; // No output when assigning vars
  }

  String removeExtraPlusesAndMinuses(String input) {
    // Loop until all extra +s and -s are stripped
    String stripped;
    do {
      stripped = input;
      input = input
        .replaceAll("(\\+\\s*\\+)+", "+") // + + => +
        .replaceAll("(\\+\\s*-)+", "-")   // + - => -
        .replaceAll("(-\\s*\\+)+", "-")   // - + => -
        .replaceAll("(-\\s*\\-)+", "+")   // - - => +
      ;
    } while(input.equals(stripped) == false);

    return input;
  }

  String nextFromQueue(ArrayDeque<String> q) throws RuntimeException {
    try {
      return q.remove();
    } catch (Exception e) {
      // No items left in q
      throw new RuntimeException("Invalid expression");
    }
  }
}

//class MyException extends Exception {
//  public RuntimeException(String message){
//    super(message);
//  }
//}