/*
 * Übung 07 – Teil A: Mit Thread, von außen starten (t1.start())
 *
 * Zwei Konstruktoren:
 *   MeinThreadA(name, intervall)          -> läuft unendlich
 *   MeinThreadA(name, intervall, anzahl)  -> läuft "anzahl" Mal
 */
public class MeinThreadA extends Thread {

  private int intervall;   // in Sekunden
  private int anzahl;      // 0 = unendlich

  // Konstruktor 1: ohne Anzahl -> unendlich
  public MeinThreadA(String name, int intervall) {
    this(name, intervall, 0);   // ruft Konstruktor 2 auf
  }

  // Konstruktor 2: mit Anzahl
  public MeinThreadA(String name, int intervall, int anzahl) {
    super(name);                // Threadname an die Klasse Thread übergeben
    this.intervall = intervall;
    this.anzahl = anzahl;
  }

  // Überschreiben der Methode run der Klasse Thread
  public void run() {
    int i = 1;
    while (anzahl == 0 || i <= anzahl) {
      System.out.println(getName() + ": Durchlauf " + i);
      i++;
      try {
        Thread.sleep(intervall * 1000L);
      } catch (InterruptedException e) {
        return;
      }
    }
    System.out.println(getName() + " ist fertig.");
  }
}
