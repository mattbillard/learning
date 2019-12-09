package regex.matcher;

import java.util.*;
import java.util.regex.*;

class ExtractingBigNumbers {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();
    Pattern pattern = Pattern.compile("\\d{10,}");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
      String group = matcher.group();
      System.out.println(group + ":" + group.length());
    }
  }
}

/*
Output all found big numbers, each number in a new line together with its length (the number of digits). Write the colon : character to separated numbers and their lengths.

Try to use Matcher and Pattern to solve it. All needed import is already here.

Sample Input 1:
If X is 609348676234, Y is 3077, the sum is 609348679311.

Sample Output 1:
609348676234:12
609348679311:12
 */