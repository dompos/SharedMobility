import java.util.*;

public class Database {

    private Map<Integer , Utente> utenti;
    private Map<Integer , Veicolo> veicoli = new HashMap<>();
    private List<Noleggio> noleggi = new ArrayList<>();


    /**
     * Costruisce un oggetto Database inserendo gli utenti e i veicoli
     * @param utenti Mappa di utenti
     *
     */
    public Database(Map<Integer, Utente> utenti) {
        this.utenti = utenti;
        for (int i = 0; i < 30; i++){
            Random random = new Random();
            int r = random.nextInt(5);
            switch(r){
                case 0:
                    veicoli.put(i, new Monopattino(true, 100));
                    veicoli.get(i).setId(i);
                    break;
                case 1:
                    veicoli.put(i, new Auto(false, 100, "AE450GT", Patente.B));
                    veicoli.get(i).setId(i);
                    break;
                case 2:
                    veicoli.put(i, new Furgone(false, 100, "FG670DT", Patente.B));
                    veicoli.get(i).setId(i);
                    break;
                case 3:
                    veicoli.put(i, new Scooter(true, 100, "ET573HY", Patente.A1));
                    veicoli.get(i).setId(i);
                    break;
                case 4:
                    veicoli.put(i, new Bicicletta(true));
                    veicoli.get(i).setId(i);
                    break;
            }
        }
    }

    /**
     * Ritorna un HashSet contenente gli id di tutti i veicoli noleggiati
     * @return HashSet<Integer>
     */
    private HashSet<Integer> idVeicoliNoleggiati(){
        HashSet<Integer> veicoliNoleggiati = new HashSet<>();
        for (Noleggio noleggio : noleggi){
            veicoliNoleggiati.add(noleggio.getIdVeicoloNoleggiato());
        }
        return veicoliNoleggiati;
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto  Oggetto della classe del veicolo scelto dall'utente
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
        return !veicoliNoleggiati.containsAll(idVeicoliScelti);
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto Oggetto della classe del veicolo scelto dall'utente
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
        return !veicoliNoleggiati.containsAll(idVeicoliScelti);
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto Oggetto della classe del veicolo scelto dall'utente
     * @return boolean
     */
    public boolean isDisponibile(Auto veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        return !veicoliNoleggiati.containsAll(idVeicoliScelti);
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto Oggetto della classe del veicolo scelto dall'utente
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
        return !veicoliNoleggiati.containsAll(idVeicoliScelti);
    }

    /**
     * Restituisce true se il veicolo richiesto è disponibile, altrimenti false
     * @param veicoloScelto Oggetto della classe del veicolo scelto dall'utente
     * @return boolean
     */
    public boolean isDisponibile(Furgone veicoloScelto){
        Set<Integer> idVeicoliScelti = new HashSet<>();
        Set<Integer> veicoliNoleggiati = idVeicoliNoleggiati();
        for (int key : veicoli.keySet()){// creo un HashSet contenente tutti gli id dei veicoli che corrispondono al tipo di veicolo scelto
            if (veicoli.get(key).getClass() == veicoloScelto.getClass()){
                idVeicoliScelti.add(key);
            }
        }
        return !veicoliNoleggiati.containsAll(idVeicoliScelti);
    }

    /**
     * Aggiunge un utente alla mappa di utenti
     * @param utente Oggetto utente da aggiungere alla mappa
     */
    public void addUtente(Utente utente){
        utenti.put(utente.getId(), utente);
    }

    /**
     * Rimuove un utente dalla mappa di utenti
     * @param utente Oggetto utente da rimuovere
     */
    public void removeUtente(Utente utente){
        utenti.remove(utente.getId());
    }

    /**
     * Aggiunge un veicolo alla mappa dei veicoli
     * @param veicolo Veicolo da aggiungere
     */
    public void addVeicolo(Veicolo veicolo){ veicoli.put(veicolo.getId(), veicolo);}

    /**
     * Rimuove un veicolo dalla mappa dei veicoli
     * @param veicolo Veicolo da rimuovere
     */
    public void removeVeicolo(Veicolo veicolo){ veicoli.remove(veicolo.getId());}

    /**
     * Aggiunge un noleggio alla lista dei noleggi
     * @param noleggio Noleggio da aggiungere
     */
    public void addNoleggio(Noleggio noleggio){ noleggi.add(noleggio); }

    /**
     * Rimuove un noleggio dalla lista dei noleggi
     * @param noleggio Noleggio da rimuovere
     */
    public void removeNoleggio(Noleggio noleggio){ noleggi.remove(noleggio); }
}
