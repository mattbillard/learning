package collections.set;

import java.util.*;

class SymmetricDifference {

  public static  Set symmetricDifference(Set set1, Set set2) {
    Set set = new HashSet<>(set1);
    set.removeAll(set2);
    set2.removeAll(set1);
    set.addAll(set2);
    return set;
  }

  /* Do not change code below */
  static final String EMPTY = "empty";
  static final String SPLIT_PATTERN = "\\s+";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String strSet1 = scanner.nextLine();
    String strSet2 = scanner.nextLine();
    Set set1 = new HashSet<>();
    Set set2 = new HashSet<>();
    if (!EMPTY.equals(strSet1)){
      Collections.addAll(set1, strSet1.split(SPLIT_PATTERN));
    }
    if (!EMPTY.equals(strSet2)){
      Collections.addAll(set2, strSet2.split(SPLIT_PATTERN));
    }
    Set resultSet = symmetricDifference(set1, set2);
    resultSet.forEach(e -> System.out.print(e + " "));
  }
}

/*
Implement a method for finding the symmetric difference of two given sets. Elements in the resulting set can be in any order.

An example

The symmetric difference of two sets {1, 2, 3} and {0, 1, 2} is {0, 3}

Sample Input 1:
1 2 3
0 1 2

Sample Output 1:
0 3

 */