package streams.methodReferences;

import java.util.*;
import java.util.function.*;


class ApplyFunctionToAllElements {

  public static <T> void applyFunction(T[] array, Function<T, T> func) {
    for (int i=0; i<array.length; i++) {
      array[i] = func.apply(array[i]);
    }
  }

  // do not change code below
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String method = scanner.nextLine();
    String[] array = scanner.nextLine().split(" ");

    applyFunction(array,
      method.equals("lower") ? String::toLowerCase :
      method.equals("upper") ? String::toUpperCase :
      method.equals("new") ? String::new :
      method.equals("trim") ? String::trim : String::intern);

    Arrays.stream(array).forEach(e -> System.out.print(e + " "));
  }
}

/*
You need to implement a method that applies given function to all elements of the given array.
You need to change the existing array, and not create a new array.

INPUT:
upper
cat sat bat hat

OUTPUT:
CAT SAT BAT HAT
 */