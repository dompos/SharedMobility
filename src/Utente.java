import java.util.ArrayList;
import java.util.Objects;

public class Utente {
    /**
     * Classe Utente
     * <p>
     * param: id, nome, cognome, codice fiscale, credito residuo, casco, patente.
     */
    private String id; // stringa generata da metodo registrazione() in main()
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private double creditoResiduo;
    private boolean casco;
    private ArrayList<Patente> patentiUtente;

    /**
     * Costruttore Classe Utente
     */
    public Utente(String nome, String cognome, String codiceFiscale, double creditoResiduo, boolean casco, ArrayList<Patente> patenti) {
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ArrayList<Patente> getPatentiUtente() {
        return patentiUtente;
    }

    public void setPatentiUtente(ArrayList<Patente> patente) {
        this.patentiUtente = patente;
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