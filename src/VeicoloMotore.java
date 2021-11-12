public abstract class VeicoloMotore extends Veicolo {

    private double autonomia;

    /**
     * costruttore
     */
    public VeicoloMotore(boolean casco, double autonomia){
        super(casco);
        this.autonomia = autonomia;
    }
}
