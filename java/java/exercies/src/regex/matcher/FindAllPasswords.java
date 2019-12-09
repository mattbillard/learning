package regex.matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FindAllPasswords {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String str = scanner.nextLine();
    Pattern pattern = Pattern.compile("password[:\\s]+[\\w]+", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);

    boolean found = false;
    while (matcher.find()) {
      found = true;

      // Remove "password" "PASSWORD:" etc from the match
      String text = matcher.group();
      String password =
            Pattern.compile("password[:\\s]+", Pattern.CASE_INSENSITIVE)
              .matcher(text)
              .replaceFirst("");
      System.out.println(password);
    }

    if (!found) {
      System.out.println("No passwords found.");
    }
  }
}


/*
Write a program to find all passwords in a given text. It is known that:

a password consists of digits and Latin letters in any case;
a password allows follow by the "password" word (in any case), but they can be separated by any number of spaces and the colon : characters.
Output all passwords found in the text, each password in a new line. If the text does not contain a password, just output: "No passwords found." without quotes.

Try to use Matcher and Pattern to solve it. All needed import is already here.

Sample Input 1:
My email javacoder@gmail.com with password    SECRET115. Here is my old PASSWORD: PASS111.

Sample Output 1:
SECRET115
PASS111


Sample Input 2:
My email is javacoder@gmail.com.

Sample Output 2:
No passwords found.

 */