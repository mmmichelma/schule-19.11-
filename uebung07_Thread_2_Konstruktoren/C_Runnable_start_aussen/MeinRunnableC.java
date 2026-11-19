/*
 * Übung 07 – Teil C: Mit Runnable, Thread von außen starten
 *
 * Die Klasse ist nur der JOB. Den Arbeiter (Thread) erzeugt die Startklasse.
 */
public class MeinRunnableC implements Runnable {

  private String name;
  private int intervall;   // in Sekunden
  private int anzahl;      // 0 = unendlich

  // Konstruktor 1: ohne Anzahl -> unendlich
  public MeinRunnableC(String name, int intervall) {
    this(name, intervall, 0);
  }

  // Konstruktor 2: mit Anzahl
  public MeinRunnableC(String name, int intervall, int anzahl) {
    this.name = name;
    this.intervall = intervall;
    this.anzahl = anzahl;
  }

  public String getName() {
    return name;
  }

  // Implementieren der Methode run des Interfaces Runnable
  public void run() {
    int i = 1;
    while (anzahl == 0 || i <= anzahl) {
      System.out.println(Thread.currentThread().getName() + ": Durchlauf " + i);
      i++;
      try {
        Thread.sleep(intervall * 1000L);
      } catch (InterruptedException e) {
        return;
      }
    }
    System.out.println(Thread.currentThread().getName() + " ist fertig.");
  }
}
