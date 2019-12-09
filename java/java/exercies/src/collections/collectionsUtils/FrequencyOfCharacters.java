package collections.collectionsUtils;

import java.util.*;

class FrequencyOfCharacters {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> list = Arrays.asList(scanner.nextLine().split("\\s+"));
    String searchFor = scanner.nextLine();

    int frequency = Collections.frequency(list, searchFor);
    System.out.println(frequency);
  }
}