public abstract class VeicoloTermico extends VeicoloMotore{
    /**
     * Attributi specifici di un veicolo con motore a combustione
     */
    private String targa;
    private Patente patente;

    /**
     * costruttore
     */
    public VeicoloTermico(boolean casco, double autonomia, String targa, Patente patente){
        super(casco, autonomia);
        this.targa = targa;
        this.patente = patente;
    }

    /**
     * Getter e Setter
     */
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
    }
}
