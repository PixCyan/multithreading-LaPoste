import java.util.LinkedList;

/**
 * Created by raffennn on 28/04/2016.
 */
public class FileAttente {
    private LinkedList<Client> clients;
    private int tailleFile;

    public FileAttente(int taille_file) {
        this.clients = new LinkedList<>();
        this.tailleFile = taille_file;
    }

    public boolean estVide() {
        boolean vide = false;
        if(this.clients.isEmpty()) {
            vide = true;
        }
        return vide;
    }

    public boolean estPleine() {
        boolean pleine = false;
        if(this.clients.size() == tailleFile) {
            pleine = true;
        }
        return pleine;
    }

    public boolean estPremier(Client client) {
        boolean res = false;
        if(this.clients.getFirst() == client) {
            res = true;
        }
        return res;
    }

    public boolean entrer(Client client) {
        boolean res = false;
        if(!(this.clients.size() == this.tailleFile)) {
            res = true;
            this.clients.add(client);
            System.out.println("Le client " + client.getClientNum() + " se place dans la file d'attente \n");
        }
        return res;
    }

    public boolean sortir(Client client) {
        boolean res = false;
        if(this.estPremier(client)) {
            this.clients.remove(client);
            res = true;
        }
        return res;
    }
}
