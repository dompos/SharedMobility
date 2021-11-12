import java.util.Date;

public class Noleggio {

    /**
     * costo noleggio del mezzo
     */
    private double tariffa;

    /**
     * Data inizio e fine noleggio
     */
    private Date inizio;
    private Date fine;

    /**
     * tempo minimo di utilizzo del mezzo noleggiato espresso in secondi
     */
    private int minimoUtilizzo = 300;

    /**
     * veicolo noleggiato
     */
    private int idVeicoloNoleggiato;

    /**
     * Costruttore
     */
    public Noleggio(int idVeicoloNoleggiato, double tariffa){
        this.idVeicoloNoleggiato = idVeicoloNoleggiato;
        this.tariffa = tariffa;
        this.inizio = new Date();
    }

    /**
     *Getter e Setter
     */
    public double getTariffa(){
        return tariffa;
    }

    public void setTariffa(double tariffa){
        this.tariffa = tariffa;
    }

    public Date getInizio(){
        return inizio;
    }

    public void setInizio(Date inizio){
        this.inizio = inizio;
    }

    public Date getFine(){
        return fine;
    }

    public void setFine(Date fine){
        this.fine = fine;
    }

    public int getMinimoUtilizzo(){
        return minimoUtilizzo;
    }

    public void setMinimoUtilizzo(int minimoUtilizzo){
        this.minimoUtilizzo = minimoUtilizzo;
    }

    public int getIdVeicoloNoleggiato() {
        return idVeicoloNoleggiato;
    }

    public void setIdVeicoloNoleggiato(int idVeicoloNoleggiato) {
        this.idVeicoloNoleggiato = idVeicoloNoleggiato;
    }
}
