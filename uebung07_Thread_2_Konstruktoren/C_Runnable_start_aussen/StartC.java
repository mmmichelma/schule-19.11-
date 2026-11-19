/*
 * Kompilieren: javac -encoding UTF-8 *.java
 * Starten:     java StartC
 * Beenden:     Strg + C (Thread 2 läuft unendlich)
 */
public class StartC {

  public static void main(String[] args) {
    MeinRunnableC job1 = new MeinRunnableC("Thread 1", 1, 5);   // 1. Job erzeugen
    MeinRunnableC job2 = new MeinRunnableC("Thread 2", 2);

    Thread t1 = new Thread(job1, job1.getName());               // 2. Thread mit Job + Name
    Thread t2 = new Thread(job2, job2.getName());

    t1.start();                                                 // 3. von außen starten
    t2.start();
  }
}
