/*
 * Übung 07 – Teil B: Mit Thread, startet automatisch beim Erzeugen (start() im Konstruktor)
 */
public class MeinThreadB extends Thread {

  private int intervall;   // in Sekunden
  private int anzahl;      // 0 = unendlich

  // Konstruktor 1: ohne Anzahl -> unendlich
  public MeinThreadB(String name, int intervall) {
    this(name, intervall, 0);
  }

  // Konstruktor 2: mit Anzahl
  public MeinThreadB(String name, int intervall, int anzahl) {
    super(name);
    this.intervall = intervall;
    this.anzahl = anzahl;
    start();   // Thread startet sich selbst – erst NACHDEM alle Attribute gesetzt sind!
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
