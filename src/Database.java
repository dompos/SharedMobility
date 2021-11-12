import java.util.*;

public class Database {

    private Map<Integer , Utente> utenti;
    private Map<Integer , Veicolo> veicoli;
    private List<Noleggio> noleggi = new ArrayList();


    /**
     * Costruisce un oggetto Database inserendo gli utenti e i veicoli
     * @param utenti
     * @param veicoli
     */
    public Database(Map<Integer, Utente> utenti, Map<Integer, Veicolo> veicoli) {
        this.utenti = utenti;
        this.veicoli = veicoli;
    }

    /**
     * Ritorna un HashSet contenente gli id di tutti i veicoli neleggiati
     * @return HashSet<Integer>
     */
    private HashSet<Integer> idVeicoliNoleggiati(){
        HashSet<Integer> veicoliNoleggiati = new HashSet<>();
        for (Noleggio noleggio : noleggi){
            veicoliNoleggiati.add(noleggio.idVeicoloNoleggiato);
        }
        return veicoliNoleggiati;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto
     * @return boolean
     */
    public boolean isDisponibile(Monopattino veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        if (veicoliNoleggiati.containsAll(idVeicoliScelti))
            return false;
        return true;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto
     * @return boolean
     */
    public boolean isDisponibile(Bicicletta veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        if (veicoliNoleggiati.containsAll(idVeicoliScelti))
            return false;
        return true;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto
     * @return boolean
     */
    public boolean isDisponibile(Automobile veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        if (veicoliNoleggiati.containsAll(idVeicoliScelti))
            return false;
        return true;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto
     * @return boolean
     */
    public boolean isDisponibile(Scooter veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        if (veicoliNoleggiati.containsAll(idVeicoliScelti))
            return false;
        return true;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto
     * @return boolean
     */
    public boolean isDisponibile(Furgoncino veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        if (veicoliNoleggiati.containsAll(idVeicoliScelti))
            return false;
        return true;
    }

    /**
     * Aggiunge un utente alla mappa di utenti
     * @param utente
     */
    public void addUtente(Utente utente){
        utenti.put(utente.id, utente);
    }

    /**
     * Rimuove un utente dalla mappa di utenti
     * @param utente
     */
    public void removeUtente(Utente utente){
        utenti.remove(utente.id);
    }

    /**
     * Aggiunge un veicolo alla mappa dei veicoli
     * @param veicolo
     */
    public void addVeicolo(Veicolo veicolo){ veicoli.put(veicolo.getId(), veicolo);}

    /**
     * Rimuove un veicolo dalla mappa dei veicoli
     * @param veicolo
     */
    public void removeVeicolo(Veicolo veicolo){ veicoli.remove(veicolo.getId());}

    /**
     * Aggiunge un noleggio alla lista dei noleggi
     * @param noleggio
     */
    public void addNoleggio(Noleggio noleggio){ noleggi.add(noleggio); }

    /**
     * Rimuove un noleggio dalla lista dei noleggi
     * @param noleggio
     */
    public void removeNoleggio(Noleggio noleggio){ noleggi.remove(noleggio); }
}
