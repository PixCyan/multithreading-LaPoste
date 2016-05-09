import static java.lang.Thread.sleep;

/**
 * Created by raffennn on 28/04/2016.
 */
public class Main {
    private static Guichets guichets = new Guichets(2);
    private static FileAttente file = new FileAttente(3);

    public static void main(String[] args) {
        int nbClient = 5;
        int i = 0;
        while(i <= nbClient) {
            Client c = new Client(guichets, file);
            c.start();
            try {
                sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guichets.afficherGuichets();
        }
    }

}
