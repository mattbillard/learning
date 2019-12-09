package regex.advanced;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class RegexAdvanced1 {
  public static void main(String[] args) {

    tests();

    Scanner scanner = new Scanner(System.in);

    String lookingFor = scanner.nextLine();
    String sentence = scanner.nextLine();
    work(lookingFor, sentence);
  }


  public static void work(String lookingFor, String sentence) {
    String reg = "\\b[\\w]+"+lookingFor+"[\\w]+\\b";
    Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sentence);
    boolean matches = matcher.find(); // NOTE: uses find instead of match b/c against whole sentence, not words
    System.out.println(matches ? "YES" : "NO");
  }

  public static void tests() {
    work( "Gramm", "Java is the most popular programming language" ); // YES
    work( "Press", "Regular expressins is hard to read, isnt it?" ); // YES
    work( "some", "Wow! How awesome is that!" ); // NO

    work( "some", "awesome" ); // NO
    work( "SoMe", "AwEsOmEe" ); // YES

    work( "ONE", "ponep,onep!"); // YES
  }
}