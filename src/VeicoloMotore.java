public abstract class VeicoloMotore extends Veicolo {
	private double autonomia; 
	
	public VeicoloMotore (boolean casco, double autonomia) {
		super (casco);
		this.autonomia = autonomia;
		
	}

	/**
	 * @return the autonomia
	 */
	
	public double getAutonomia() {
		return autonomia;
	}
 public void setAutonomia(double autonomia) {
	  this.autonomia = autonomia;
}

}
