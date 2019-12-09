package regex.advanced;

//import java.util.Arrays;
import java.util.Scanner;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;

class RegexAdvanced4 {
  public static void main(String[] args) {

//    tests();

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    work(text);
  }


  public static void work(String text) {
    String result = text.trim()
            .replaceAll("<.*?>", "")
            .replaceAll("</.*?>", "")
            ;
    System.out.println(result);
  }

  public static void tests() {
    work( "<h1>Simple header</h1>" ); // Simple header
    work( "<h2>Header with <b>bold</b> text</h2>" ); // Header with bold text
  }
}
