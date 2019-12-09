package collections.set;

import java.util.*;

class SpellCheckerWithSets {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int count1 = Integer.parseInt(scanner.nextLine());
    Set<String> dictionary = new TreeSet<>();
    for (int i=0; i<count1; i++) {
      dictionary.add( scanner.nextLine().trim().toLowerCase() );
    }

    int count2 = Integer.parseInt(scanner.nextLine());
    String text = "";
    for (int i=0; i<count2; i++) {
      text = text + " " + scanner.nextLine().trim();
    }
    String[] words = text.split("\\s+");


    Set<String> bad = new TreeSet<>();
    for (String word : words) {
      if (dictionary.contains(word.toLowerCase()) == false) {
        bad.add(word);
      }
    }

    for (String word : bad) {
      System.out.println(word);
    }
  }
}

/*
NOTE: I did this with sets instead of maps b/c it seemed like a better solution

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