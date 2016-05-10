/**
 * Created by raffennn on 28/04/2016.
 */
public class Client extends Thread {
    private static int numClient = 0;
    private int clientNum;
    private String etat;
    private Guichets guichets;
    private FileAttente file;
    private int guichet;

    public Client(Guichets g, FileAttente file) {
        this.guichets = g;
        this.file = file;
        this.etat = "New";
        this.guichet = -1;
        this.clientNum = numClient++;
    }

    public void run() {
        boolean fin = false;
        while (! fin) {
            if(this.file.estPleine()) {
                fin = true;
            } else {
                if(this.etat .equals("New")) {
                    if(this.file.estVide()) {
                        int guichet = this.guichets.entrer(this);
                        if(guichet == -1) {
                            this.file.entrer(this);
                            this.etat = "En attente";
                        } else {
                            fin = this.attenteGuichet(guichet);
                        }
                    } else {
                        boolean res = this.file.entrer(this);
                        if(!res) {
                            fin = true;
                            System.out.println("Plus de place, le client " + this.toString() + " ressort. \n");
                        }
                    }

                } else {
                    if(this.file.estPremier(this)) {
                        int guichet = this.guichets.entrer(this);
                        if(guichet > -1) {
                            this.file.sortir(this);
                            fin = this.attenteGuichet(guichet);
                        }
                    }
                }
            }
        }
    }

    public boolean attenteGuichet(int numGuichet) {
        this.etat = "Au guichet";
        try {
            sleep(3000);
            this.guichets.quitter(this, numGuichet);
            System.out.println("Le client " + clientNum + " a fini. \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client " + clientNum;
    }

    public int getClientNum() {
        return clientNum;
    }
}
