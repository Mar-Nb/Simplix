package Modele;

public class Monome {
	int coefficient;
	String inconnue;
	
	public Monome(int coeff, String inconnue) {
		coefficient=coeff;
		this.inconnue=inconnue;
	}
	
	public String toString() {
		return coefficient + inconnue;
	}
	
	public void additionner(Monome m) {
		this.coefficient += m.getCoefficient();
	}

	public void multiplier(float constante) { // ADD FRACTION
		this.coefficient *= constante;
	}
	
	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public String getInconnue() {
		return inconnue;
	}

	public void setInconnue(String inconnue) {
		this.inconnue = inconnue;
	}
}
