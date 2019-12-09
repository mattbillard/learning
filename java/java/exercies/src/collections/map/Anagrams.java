package collections.map;

import java.util.*;

class Anagrams {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String str1 = scanner.nextLine().trim().toLowerCase();
    String str2 = scanner.nextLine().trim().toLowerCase();

    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for (char ch: str1.toCharArray()) {
      Integer i = map1.get(ch);
      i = i == null ? 1 : i+1;
      map1.put(ch, i);
    }

    for (char ch: str2.toCharArray()) {
      Integer i = map2.get(ch);
      i = i == null ? 1 : i+1;
      map2.put(ch, i);
    }

    System.out.println(map1.equals(map2) ? "yes" : "no");
  }
}

/*
In this problem, you are Sherlock Holmes and you want to find all anagrams.

You have two words. If the words are an anagram, print "yes", else "no".

Note: anagrams are words which contain the same characters with the same frequencies.

For example:

"ppaaagg" (p - 2; a - 3; g - 2) and "gagaapp" (p - 2; a - 3; g - 2) are anagrams;
"hello" (h - 1; e - 1; l - 2; o - 1) and "helllo" (h - 1; e - 1; l - 3; o - 1) are not anagrams.
Remember: anagrams are case-insensitive


Sample Input 1:
ppaaagg
gagaapp

Sample Output 1:
yes
 */