public class Veicolo {

    private int id;
    private double[] posizione = new  double[]{41.07372462509311, 14.32735545069675};
    private final boolean bisognoDelCasco;

    /**
     * Costruisce un oggetto veicolo
     * @param bisognoDelCasco
     */
    public Veicolo(boolean bisognoDelCasco) {
        this.bisognoDelCasco = bisognoDelCasco;
    }

    public int getId() {
        return id;
    }

    public double[] getPosizione() {
        return posizione;
    }

    public boolean isBisognoDelCasco() {
        return bisognoDelCasco;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosizione(double[] posizione) {
        this.posizione = posizione;
    }
}
