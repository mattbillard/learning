package regex.advanced;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;

class RegexAdvanced3 {
  public static void main(String[] args) {

//    tests();

    Scanner scanner = new Scanner(System.in);

    String lookingFor = scanner.nextLine();
    String sentence = scanner.nextLine();
    work(lookingFor, sentence);
  }


  public static void work(String lookingFor, String line) {
    String reg1 = "\\b[\\w]+" + lookingFor + "\\b";
    String reg2 = "\\b" +       lookingFor + "[\\w]+\\b";
    String reg3 = "\\b" +       lookingFor + "\\b";

    boolean matches1 = Pattern.compile(reg1, Pattern.CASE_INSENSITIVE).matcher(line).find();
    boolean matches2 = Pattern.compile(reg2, Pattern.CASE_INSENSITIVE).matcher(line).find();
    boolean matches3 = Pattern.compile(reg3, Pattern.CASE_INSENSITIVE).matcher(line).find();


    System.out.println(matches1 || matches2 || matches3 ? "YES" : "NO");
  }

  public static void tests() {
    work( "ing", "Java is the most popular programming language" ); // YES
    work( "press", "Regular expressins is hard to read, isnt it?" ); // NO
    work( "ho", "Wow! How awesome is that!" ); // YES

    work( "part", "test with part as a whole word" ); // YES
  }
}