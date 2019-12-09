//import java.util.Arrays;
import java.util.Scanner;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;

class RegexAdvanced5 {
  public static void main(String[] args) {

//    tests();

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    System.out.println(
            work(text)
    );
  }


  public static String work(String text) {
    String result = text
//            .replaceAll("/\\*.*?\\*/", "")
            .replaceAll("(?i)/\\*(.|\\n)*?\\*/", "")
            .replaceAll("[\\s]*//.*", "")
            .trim()
            ;
//    System.out.println(result);
    return result;
  }

  public static void tests() {
    String result = null;
    String expected = null;

//    result = work( "Integer variable /* it only \ncontains integers */= new Integer(\"0\");       // now contains zero /*stupid stuff*/" );
//    expected = "Integer variable = new Integer(\"0\");";
//    System.out.println(result);
//    System.out.println(expected);
//    System.out.println(result.equals(expected));
//
//
//    result = work( "/* new line */String /* we need String, not int */s /* bad name, I think */= \"123\";" );
//    expected = "String s = \"123\";";
//    System.out.println(result);
//    System.out.println(expected);
//    System.out.println(result.equals(expected));
//
//    result = work( "int b = 0;/* expression */ b = b /* **/* b /* b * b = b squared */; // 0 * 0 = 0" );
//    expected = "int b = 0; b = b * b ;";
//    System.out.println(result);
//    System.out.println(expected);
//    System.out.println(result.equals(expected));
//
//    result = work( "/**/test/**/" );
//    expected = "test";
//    System.out.println(result);
//    System.out.println(expected);
//    System.out.println(result.equals(expected));


    result = work( "/*i/**/int/**/ b/*b*//**/=/**/0/*0*/;/*;*/b/*is*/=/*/*/b/**/*/**/b/*b*b=b*/;//0*0=0" );
//    expected = "test";
    System.out.println(result);
//    System.out.println(expected);
//    System.out.println(result.equals(expected));
  }
}
