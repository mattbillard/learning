package collections.set;

import java.util.*;

class CreateATreeSet {

  public static void main(String[] args) {
    Set<String> set = new TreeSet<>(Arrays.asList("Gamma", "Alpha", "Omega" ));
    System.out.println(set);
  }
}

/*
Create TreeSet by name set in any way known to you and fill it with the following three strings "Gamma", "Alpha", "Omega" .

The code for displaying the set is already written.

Sample Input 1:


Sample Output 1:
[Alpha, Gamma, Omega]
 */