package Modele;

public class Monome {
	Fraction coefficient;
	String inconnue;
	
	public Monome(Fraction coeff, String inconnue) {
		coefficient=coeff;
		this.inconnue=inconnue;
	}
	
	public String toString() {
		return coefficient + inconnue;
	}
	
	public void additionner(Monome m) {
		this.coefficient = this.coefficient.FAddition(m.getCoefficient());
		
	}

	public void multiplier(Fraction constante) { // ADD FRACTION
		this.coefficient.FMultiplication(constante);
	}
	
	public Fraction getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Fraction coefficient) {
		this.coefficient = coefficient;
	}

	public String getInconnue() {
		return inconnue;
	}

	public void setInconnue(String inconnue) {
		this.inconnue = inconnue;
	}
}
