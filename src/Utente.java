import java.time.LocalDateTime;
import java.util.*;

public class Utente {
    /**
     * Classe Utente
     * <p>
     * param: id, nome, cognome, codice fiscale, credito residuo, casco, patente.
     */
    private int id;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private double creditoResiduo;
    private boolean casco;
    private Patente patentiUtente;
    private List<Noleggio> noleggiUtente=new ArrayList<>();



    /**
     * Costruttore Classe Utente
     */
    public Utente(String nome, String cognome, String codiceFiscale, double creditoResiduo, boolean casco, Patente patenti){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.creditoResiduo = creditoResiduo;
        this.casco = casco;
        this.patentiUtente = patenti;

    }

    /**
     * Getters e Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public double getCreditoResiduo() {
        return creditoResiduo;
    }

    public void setCreditoResiduo(double credito) {
        this.creditoResiduo += credito;
    }

    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    public Patente getPatentiUtente() {
        return patentiUtente;
    }

    public void setPatentiUtente(Patente patente) {
        this.patentiUtente = patente;
    }

    public List<Noleggio> getNoleggiUtente() {
        return noleggiUtente;
    }

    public void setNoleggiUtente(List<Noleggio> noleggiUtente) {
        this.noleggiUtente = noleggiUtente;
    }

    /**
     * Creo ID Utente
     */

    public int idGen() {

        int id = this.nome.hashCode() + this.cognome.hashCode();
        int length = String.valueOf(id).length();
        int Max_Length = 5;
        if(String.valueOf(id).length()>Max_Length)
        {
            id = (int) (id /Math.pow(10.0,length - Max_Length ));
        }
        return  id;
    }

    /**
     * Ritorna true se il veicolo è stato prenotato, altrimenti false
     * @return boolean
     */
    public boolean prenotaVeicolo(Database db) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Cosa vuoi nolleggiare ?" + "\n" + "1- Auto" + "\n" + "2- Scooter" + "\n" + "3- Furgone" + "\n" + "4- Monopattino" + "\n" + "5-Bicicletta");
        int r = sc.nextInt();
        switch (r) {
            case 1:
                if (patentiUtente != Patente.B){
                    System.out.println("La tua patente non ti permette di noleggiare questo veicolo");
                    return false;
                }
                if(db.isDisponibile(new Auto(true, 100, "we345ty", Patente.B))){

                    Map<Integer,Veicolo> veicoli = db.getVeicoli();
                    Set<Integer> idVeicoliNoleggiati = db.idVeicoliNoleggiati();
                    Set<Integer> idVeicoli = new HashSet<>(veicoli.keySet());
                    idVeicoli.removeAll(idVeicoliNoleggiati);
                    for(Integer s : idVeicoli){
                        Veicolo auto = veicoli.get(s);
                        if(auto  instanceof  Auto){
                            Noleggio noleggio = new Noleggio(s,15.70);
                            if (creditoResiduo < (noleggio.getTariffa() * (noleggio.getMinimoUtilizzo()/60.0))){
                                System.out.println("Non hai abbastanza credito");
                                return false;
                            }
                            db.addNoleggio(noleggio);
                            noleggiUtente.add(noleggio);
                            System.out.println("Hai noleggiato il veicolo "+s);
                            return true;
                        }

                    }
                }else{
                   System.out.println("Il veicolo scelto non è disponibile");
                    return false;

                }
                break;
            case 2:
                if (patentiUtente == Patente.NonPatentato){
                    System.out.println("La tua patente non ti permette di noleggiare questo veicolo");
                    return false;
                }
                if(db.isDisponibile(new Scooter(true, 100, "we345ty", Patente.B))){

                    Map<Integer,Veicolo> veicoli = db.getVeicoli();
                    Set<Integer> idVeicoliNoleggiati = db.idVeicoliNoleggiati();
                    Set<Integer> idVeicoli = new HashSet<>(veicoli.keySet());
                    idVeicoli.removeAll(idVeicoliNoleggiati);
                    for(Integer s : idVeicoli){
                        Veicolo scooter = veicoli.get(s);
                        if(scooter  instanceof  Scooter){
                            Noleggio noleggio = new Noleggio(s,15.70);
                            if (creditoResiduo < (noleggio.getTariffa() * (noleggio.getMinimoUtilizzo()/60.0))){
                                System.out.println("Non hai abbastanza credito");
                                return false;
                            }
                            db.addNoleggio(noleggio);
                            noleggiUtente.add(noleggio);
                            System.out.println("Hai noleggiato il veicolo "+s);
                            return true;
                        }

                    }
                }else{
                    System.out.println("Il veicolo scelto non è disponibile");
                    return false;

                }
                break;
            case 3:
                if (patentiUtente != Patente.B){
                    System.out.println("La tua patente non ti permette di noleggiare questo veicolo");
                    return false;
                }
                if(db.isDisponibile(new Furgone(true, 100, "we345ty", Patente.B)) && patentiUtente == Patente.B){

                    Map<Integer,Veicolo> veicoli = db.getVeicoli();
                    Set<Integer> idVeicoliNoleggiati = db.idVeicoliNoleggiati();
                    Set<Integer> idVeicoli = new HashSet<>(veicoli.keySet());
                    idVeicoli.removeAll(idVeicoliNoleggiati);
                    for(Integer s : idVeicoli){
                        Veicolo furgone = veicoli.get(s);
                        if(furgone  instanceof  Furgone){
                            Noleggio noleggio = new Noleggio(s,15.70);
                            if (creditoResiduo < (noleggio.getTariffa() * (noleggio.getMinimoUtilizzo()/60.0))){
                                System.out.println("Non hai abbastanza credito");
                                return false;
                            }
                            db.addNoleggio(noleggio);
                            noleggiUtente.add(noleggio);
                            System.out.println("Hai noleggiato il veicolo "+s);
                            return true;
                        }

                    }
                }else{
                    System.out.println("Il veicolo scelto non è disponibile");
                    return false;

                }
                break;
            case 4:
                if(db.isDisponibile(new Monopattino(true, 100))){

                    Map<Integer,Veicolo> veicoli = db.getVeicoli();
                    Set<Integer> idVeicoliNoleggiati = db.idVeicoliNoleggiati();
                    Set<Integer> idVeicoli = new HashSet<>(veicoli.keySet());
                    idVeicoli.removeAll(idVeicoliNoleggiati);
                    for(Integer s : idVeicoli){
                        Veicolo monop = veicoli.get(s);
                        if(monop  instanceof  Monopattino){
                            Noleggio noleggio = new Noleggio(s,15.70);
                            if (creditoResiduo < (noleggio.getTariffa() * (noleggio.getMinimoUtilizzo()/60.0))){
                                System.out.println("Non hai abbastanza credito");
                                return false;
                            }
                            db.addNoleggio(noleggio);
                            noleggiUtente.add(noleggio);
                            System.out.println("Hai noleggiato il veicolo "+s);
                            return true;
                        }

                    }
                }else{
                    System.out.println("Il veicolo scelto non è disponibile");
                    return false;

                }
                break;
            case 5:
                if(db.isDisponibile(new Bicicletta(true))){

                    Map<Integer,Veicolo> veicoli = db.getVeicoli();
                    Set<Integer> idVeicoliNoleggiati = db.idVeicoliNoleggiati();
                    Set<Integer> idVeicoli = new HashSet<>(veicoli.keySet());
                    idVeicoli.removeAll(idVeicoliNoleggiati);
                    for(Integer s : idVeicoli){
                        Veicolo bici = veicoli.get(s);
                        if(bici  instanceof  Bicicletta){
                            Noleggio noleggio = new Noleggio(s,15.70);
                            if (creditoResiduo < (noleggio.getTariffa() * (noleggio.getMinimoUtilizzo()/60.0))){
                                System.out.println("Non hai abbastanza credito");
                                return false;
                            }
                            db.addNoleggio(noleggio);
                            noleggiUtente.add(noleggio);
                            System.out.println("Hai noleggiato il veicolo "+s);
                            return true;
                        }

                    }
                }else{
                    System.out.println("Il veicolo scelto non è disponibile");
                    return false;

                }
                break;
            default:
                System.out.println("Veicolo non in lista");
                return false;
        }return false;
    }

    public boolean rilasciaVeicolo(Database db,Veicolo veicolo){

        List<Noleggio> noleggio = db.getNoleggi();
        for(Noleggio  n : noleggio){
            if(n.getIdVeicoloNoleggiato()==veicolo.getId()) {
                noleggiUtente.remove(n);
                n.setFine(new Date());
                if ( (n.getFine().getTime()-n.getInizio().getTime())/1000.0 <= n.getMinimoUtilizzo() )
                    creditoResiduo -= n.getTariffa() * (n.getMinimoUtilizzo()/60.0);
                else
                    creditoResiduo -= (n.getTariffa() * ((n.getFine().getTime() - n.getInizio().getTime()) / 60000.0));
                System.out.println("Hai rilasciato il veicolo " + veicolo.getId());
                System.out.println("Sul conto hai: " + creditoResiduo);
                return true;
            }
        }
        System.out.println("Il veicolo non è noleggiato");
        return false;
    }





    @Override
    public String toString() {
        return "Utente{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", creditoResiduo=" + creditoResiduo +
                ", casco=" + casco +
                ", patentiUtente=" + patentiUtente +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(id, utente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
