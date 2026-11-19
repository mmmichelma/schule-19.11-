/*
 * Kompilieren: javac -encoding UTF-8 *.java
 * Starten:     java StartB
 * Beenden:     Strg + C (Thread 2 läuft unendlich)
 */
public class StartB {

  public static void main(String[] args) {
    // Kein start() nötig – die Threads laufen schon beim Erzeugen los
    new MeinThreadB("Thread 1", 1, 5);
    new MeinThreadB("Thread 2", 2);
  }
}
