/**
 * Created by raffennn on 28/04/2016.
 */
public class Guichets {
    private Client[] guichets;

    public Guichets(int nb_guichets) {
        // A completer
        this.guichets = new Client[nb_guichets];
        for(int i = 0; i < nb_guichets - 1; i++) {
            this.guichets[i] = null;
        }
    }

    public int entrer(Client client) {
        int res = -1;
        boolean stop = false;
        int i = 0;
        do {
            if (this.guichets[i] == null) {
                res = i;
                this.guichets[i] = client;
                System.out.println("Le client " + client.getClientNum() + " entre au guichet numéro : " + i + "\n");
                stop = true;
            } else {
                i++;
                if (i == this.guichets.length) {
                    stop = true;
                }
            }
        } while (!stop);
        return res;
    }

    public boolean quitter(Client client, int guichet) {
        boolean res = false;
        if(this.guichets[guichet] == client) {
            this.guichets[guichet] = null;
            res = true;
        }
        return res;
    }

    public void afficherGuichets() {
        for(int i = 0; i < this.guichets.length; i++) {
            System.out.println("Guichet "+ i + " ==> " + guichets[i] + " \n");
        }
    }
}
