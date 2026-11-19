/*
 * Übung 07 – Teil D: Mit Runnable, Thread startet automatisch,
 * wenn ein Objekt dieser Klasse erzeugt wird.
 *
 * Die Klasse erzeugt im Konstruktor selbst einen Thread und gibt sich (this) als Job mit.
 */
public class MeinRunnableD implements Runnable {

  private int intervall;   // in Sekunden
  private int anzahl;      // 0 = unendlich
  private Thread thread;

  // Konstruktor 1: ohne Anzahl -> unendlich
  public MeinRunnableD(String name, int intervall) {
    this(name, intervall, 0);
  }

  // Konstruktor 2: mit Anzahl
  public MeinRunnableD(String name, int intervall, int anzahl) {
    this.intervall = intervall;
    this.anzahl = anzahl;
    thread = new Thread(this, name);   // this = dieses Objekt ist der Job
    thread.start();                    // erst am Ende starten, wenn alles gesetzt ist
  }

  // Implementieren der Methode run des Interfaces Runnable
  public void run() {
    int i = 1;
    while (anzahl == 0 || i <= anzahl) {
      System.out.println(thread.getName() + ": Durchlauf " + i);
      i++;
      try {
        Thread.sleep(intervall * 1000L);
      } catch (InterruptedException e) {
        return;
      }
    }
    System.out.println(thread.getName() + " ist fertig.");
  }
}
