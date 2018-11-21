package Modele;

public class Fraction {

	int numerateur;
	int denominateur;
	
	public Fraction(int num, int den) {
		numerateur=num;
		denominateur = den;
	}
	
	public void addition(Fraction fraction) {
		if(this.denominateur == fraction.getDenominateur()) {
			this.numerateur+=fraction.getNumerateur();
			this.simplifier();
		}
		else {
			int ppcm = Fraction.PPCM(this.denominateur, fraction.getDenominateur());
			int tempDen = this.getDenominateur();
			this.multiplier(new Fraction(ppcm/tempDen, ppcm/tempDen));
			System.out.println(this);
			fraction.multiplier(new Fraction(ppcm/fraction.getDenominateur(),ppcm/fraction.getDenominateur()));
			System.out.println(fraction);
			this.numerateur=this.numerateur+fraction.getNumerateur();
			this.simplifier();
		}
	}
	
	public static int PPCM(int a, int b) {
		int c = a;
		int d=b;
		while(a!=b) {
			if(a>b) {
				b+=d;
			}
			else {
				a+=c;
			}
		}
		
		return a;
	}
	
	public void multiplier(Fraction fraction) {
		numerateur = numerateur*fraction.getNumerateur();
		denominateur= denominateur * fraction.getDenominateur();
	}
	
	public int PGCD(int a, int b) {

		while(b != 0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
	public void simplifier() {
		int pgcd = this.PGCD(numerateur, denominateur);
		numerateur=numerateur/pgcd;
		denominateur = denominateur/pgcd;
	}

	public int getNumerateur() {
		return numerateur;
	}

	public void setNumerateur(int numerateur) {
		this.numerateur = numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	public void setDenominateur(int denominateur) {
		this.denominateur = denominateur;
	}
	
	public String toString() {
		return this.numerateur + "/"+this.denominateur;
	}
}
