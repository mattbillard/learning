package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SpellCheckerWithMaps {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int words = scanner.nextInt();
    Map<String, Boolean> dict = new HashMap<>();

    for (int i = 0; i < words; i++) {
      dict.put(scanner.next().toLowerCase(), true);
    }

    int lines = scanner.nextInt();
    Scanner lineScanner = new Scanner(scanner.nextLine());

    for (int i = 0; i < lines; i++) {
      lineScanner = new Scanner(scanner.nextLine());
      while (lineScanner.hasNext()) {
        dict.putIfAbsent(lineScanner.next().toLowerCase(), false);
      }
    }

    for (Map.Entry<String, Boolean> entry : dict.entrySet()) {
      if (!entry.getValue()) {
        System.out.println(entry.getKey());
      }
    }
  }
}

/*
NOTE: official solution

The simplest spell checker is based on a list of known words. Every word in the checked text is searched for in this list and, if such a word was not found, it is marked as erroneous.

Write this spell checker.

The first line of the input contains d d – number of records in the list of known word. Next go d d lines contain one known word per line, next — the number l l of lines of the text, after which — l l lines of the text.

Write a program that outputs those words from the text, which are not found in the dictionary (i.e. erroneous). Your spell checker should be case insensitive. The words are entered in an arbitrary order. Words, which are not found in the dictionary, should not be duplicated in the output.

Sample Input 1:
3
a
bb
cCc
2
a bb aab aba ccc
c bb aaa

Sample Output 1:
c
aab
aaa
aba
 */