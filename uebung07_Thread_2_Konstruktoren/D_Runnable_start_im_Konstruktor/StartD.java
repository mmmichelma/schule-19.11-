/*
 * Kompilieren: javac -encoding UTF-8 *.java
 * Starten:     java StartD
 * Beenden:     Strg + C (Thread 2 läuft unendlich)
 */
public class StartD {

  public static void main(String[] args) {
    // Kein Thread-Objekt und kein start() nötig – das macht der Konstruktor
    new MeinRunnableD("Thread 1", 1, 5);
    new MeinRunnableD("Thread 2", 2);
  }
}
