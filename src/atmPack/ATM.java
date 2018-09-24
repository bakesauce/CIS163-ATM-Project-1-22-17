package atmPack;
import java.util.ArrayList;


public class ATM {
	
	private int hundreds, fifties, twenties;
	
	public static void main (String args []) {
		
	}
	
	public ATM() {
		this.hundreds = 0;
		this.fifties = 0;
		this.twenties = 0;
	}
	
	public ATM(int h, int f, int t) {
		this.hundreds = h;
		this.fifties = f;
		this.twenties = t;
	}
	
	public ATM (ATM other) {
		this.hundreds = other.hundreds;
		this.fifties = other.fifties;
		this.twenties = other.twenties;
	}
	
	public int getHundreds() {
		return this.hundreds;
	}
	
	public int getFifties() {
		return this.fifties;
	}
	
	public int getTwenties() {
		return this.twenties;
	}
	
	public void setHundreds(int h) {
		this.hundreds = h;
	}
	
	public void setFifties(int f) {
		this.fifties = f;
	}
	
	public void setTwenties(int t) {
		this.twenties = t;
	}
	
	public boolean equals(Object other) {
		ATM o = (ATM) other;
		
		int h = o.hundreds;
		int f = o.fifties;
		int t = o.twenties;
		
		if (this.hundreds == h &&
			this.fifties == f &&
			this.twenties == t) 
				return true;
			else 
				return false;
		}
	
	public boolean equals(ATM other) {
		int h = other.hundreds;
		int f = other.fifties;
		int t = other.twenties;
		
		if (this.hundreds == h &&
			this.fifties == f &&
			this.twenties == t) 
				return true;
			else 
				return false;
	}
	
	public static boolean equals(ATM other1, ATM other2) {
		int h1 = other1.hundreds;
		int h2 = other2.hundreds;
		int f1 = other1.fifties;
		int f2 = other2.fifties;
		int t1 = other1.twenties;
		int t2 = other2.twenties;
		
		if (h1 == h2 &&
			f1 == f2 &&
			t1 == t2) 
				return true;
			else 
				return false;
	}

	public int compareTo(ATM other) {
		int thisAtmTotal = addTotal(this.hundreds, this.fifties, this.twenties);
		int otherAtmTotal = addTotal(other.hundreds, other.fifties, other.twenties);
		
		if (thisAtmTotal > otherAtmTotal)
			return 1;
		else if (thisAtmTotal < otherAtmTotal)
			return -1;
		else
			return 0;
	}
	
	public int addTotal (int h, int f, int t) {
		return (h * 100) + (f * 50) + (t * 20);
	}
	
	public static int compareTo(ATM other1, ATM other2) {
		int other1AtmTotal = other1.addTotal(other1.hundreds, other1.fifties, other1.twenties);
		int other2AtmTotal = other2.addTotal(other2.hundreds, other2.fifties, other2.twenties);
		
		if (other1AtmTotal > other2AtmTotal)
			return 1;
		else if (other1AtmTotal < other2AtmTotal)
			return -1;
		else
			return 0;
	}
	
	public void putIn(int h, int f, int t) {
		this.hundreds += h;
		this.fifties += f;
		this.twenties += t;
	}
	
	public void putIn(ATM other) {
		this.hundreds += other.hundreds;
		this.fifties += other.fifties;
		this.twenties += other.twenties;
	}
	
	public void takeOut(int h, int f, int t) {
		this.hundreds -= h;
		this.fifties -= f;
		this.twenties -= t;
	}
	
	public void takeOut(ATM other) {
		this.hundreds -= other.hundreds;
		this.fifties -= other.fifties;
		this.twenties -= other.twenties;
	}
	
	
	
	}

//40 minutes

