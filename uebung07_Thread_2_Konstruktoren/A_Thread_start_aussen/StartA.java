/*
 * Kompilieren: javac -encoding UTF-8 *.java
 * Starten:     java StartA
 * Beenden:     Strg + C (Thread 2 läuft unendlich)
 */
public class StartA {

  public static void main(String[] args) {
    MeinThreadA t1 = new MeinThreadA("Thread 1", 1, 5);   // alle 1 s, 5 Mal
    MeinThreadA t2 = new MeinThreadA("Thread 2", 2);      // alle 2 s, unendlich

    t1.start();   // von außen starten
    t2.start();
  }
}
