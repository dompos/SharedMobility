

public abstract class Veicolo {
			  
	private int id;
	 private double []  posizione = new double[] {0,0};
	  private  boolean casco;
			 
		public Veicolo(boolean casco) {
			this.casco = casco;
	}
	 // @return the id
	public int getId() {
		return id;
	}
	
	 // @param id the id to set
	 
	public void setId(int id) {
		this.id = id;
	}
	
	 // @return the posizione
	 
	public double [] getPosizione() {
		return posizione;
	}
	
	// @param posizione the posizione to set
	 
	public void setPosizione(double [] posizione) {
		this.posizione = posizione;
	}
	
	 // @return the casco
	 
	public boolean isCasco() {
		return casco;
	}
					
}
