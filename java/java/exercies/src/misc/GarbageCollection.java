package misc;

class GarbageCollection {

  private static void printUsedMemory() {
    Runtime r = Runtime.getRuntime(); // it allows to get memory information for JVM
    long usedMemory = r.totalMemory() - r.freeMemory();
    System.out.println("Used memory (bytes): " + usedMemory);
  }

  public static void main(String[] args) {
    printUsedMemory();

    for (int i = 0; i < 1_000_000; i++) {
      new Hamster(i);
    }

    printUsedMemory();

    System.gc(); // Requesting JVM for running GC

    printUsedMemory();
  }
}

class Hamster {
  private int id;

  public Hamster(int id) {
    this.id = id;
  }
}