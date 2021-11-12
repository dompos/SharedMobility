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
     * Costruttore
     */
    public Noleggio(Veicolo veicolo, double tariffa){
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

}
