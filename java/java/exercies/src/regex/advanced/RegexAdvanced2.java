package regex.advanced;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RegexAdvanced2 {
  public static void main(String[] args) {

//    tests();

    Scanner scanner = new Scanner(System.in);
    int count = Integer.parseInt(scanner.nextLine());
    String line = scanner.nextLine();
    work(count, line);
  }


  public static void work(int count, String line) {
    Pattern pattern = Pattern.compile("(?i)\\b[a-z]{" + count + "}\\b");
    Matcher matcher = pattern.matcher(line);
    System.out.println(matcher.find() ? "YES" : "NO");
  }

  public static void tests() {
    work( 3, "Java is the most popular programming language"); // YES
    work( 11, "Regular expressins is hard to read, isnt it?"); // NO
    work( 4, "Wow! How awesome is that!"); // YES
  }
}