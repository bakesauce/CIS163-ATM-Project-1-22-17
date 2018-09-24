package atmPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**************************************************
 * ATM simulation
 * 
 * @author Mark Baker
 * @version 1/31/2017
 *
 **************************************************/
public class ATM {

	/** current number of hundreds */
	private int hundreds;
	
	/** current number of fifties */
	private int fifties;
	
	/** current number of twenties */
	private int twenties;
	
	/** ATM on/off switch */
	private static boolean suspend = false;

	public static void main(String args[]) {
		
	}

	/**************************************************
	 Default constructor that creates an ATM object with
	 instance variables all set to 0
	 **************************************************/
	public ATM() {
		this.hundreds = 0;
		this.fifties = 0;
		this.twenties = 0;
	}

	/**************************************************
	 Constructor that creates an ATM object with instance
	 variables set to the parameters.
	 
	 @param number of hundreds (h), fifties (f), and twenties(t)
	 **************************************************/
	public ATM(int h, int f, int t) {
		if ((h < 0) || (f < 0) || (t < 0)) {
			throw new IllegalArgumentException();
		} else {
			this.hundreds = h;
			this.fifties = f;
			this.twenties = t;
		}
	}

	/**************************************************
	 Constructor that creates an ATM object with instance
	 variables set to those of another ATM object.
	 
	 @param ATM object
	 **************************************************/
	public ATM(ATM other) {
		this.hundreds = other.hundreds;
		this.fifties = other.fifties;
		this.twenties = other.twenties;
	}

	/**************************************************
	 Method that returns the number of hundreds in this ATM object
	 **************************************************/
	public int getHundreds() {
		return this.hundreds;
	}

	/**************************************************
	 Method that returns the number of fifties in this ATM object
	 **************************************************/
	public int getFifties() {
		return this.fifties;
	}

	/**************************************************
	 Method that returns the number of twenties in this ATM object
	 **************************************************/
	public int getTwenties() {
		return this.twenties;
	}

	/**************************************************
	 Method that returns the sets the number of hundreds in
	 this ATM object to the parameter integer
	 
	 @param number of hundreds (h)
	 **************************************************/
	public void setHundreds(int h) {
		if (h < 0) {
			throw new IllegalArgumentException();
		} else {
			this.hundreds = h;
		}
	}

	/**************************************************
	 Method that returns the sets the number of fifties in
	 this ATM object to the parameter integer
	 
	 @param number of fifties (f)
	 **************************************************/
	public void setFifties(int f) {
		if (f < 0) {
			throw new IllegalArgumentException();
		} else {
			this.fifties = f;
		}
	}

	/**************************************************
	 Method that returns the sets the number of twenties in
	 this ATM object to the parameter integer
	 
	 @param number of twenties (t)
	 **************************************************/
	public void setTwenties(int t) {
		if (t < 0) {
			throw new IllegalArgumentException();
		} else {
			this.twenties = t;
		}
	}

	/**************************************************
	 Method that returns true if the internal state of the this ATM object
	 is equal to the internal state of another object (all instance
	 variables are equal to each other)
	 
	 @param other Object (gets casted to ATM)
	 **************************************************/
	public boolean equals(Object other) {
		ATM o = (ATM) other;

		int h = o.hundreds;
		int f = o.fifties;
		int t = o.twenties;

		if (this.hundreds == h && this.fifties == f && this.twenties == t)
			return true;
		else
			return false;
	}

	/**************************************************
	 Method that returns true if the internal state of the this ATM object
	 is equal to the internal state of another ATM object (all instance
	 variables are equal to each other)
	 
	 @param ATM object
	 **************************************************/
	public boolean equals(ATM o) {
		int h = o.hundreds;
		int f = o.fifties;
		int t = o.twenties;

		if (this.hundreds == h && this.fifties == f && this.twenties == t)
			return true;
		else
			return false;
	}

	/**************************************************
	 Static method that returns true if the internal state of an ATM object
	 is equal to the internal state of another ATM object (all instance
	 variables are equal to each other)
	 
	 @param Two ATM objects (o1 and o2)
	 **************************************************/
	public static boolean equals(ATM o1, ATM o2) {
		int h1 = o1.hundreds;
		int f1 = o1.fifties;
		int t1 = o1.twenties;

		int h2 = o2.hundreds;
		int f2 = o2.fifties;
		int t2 = o2.twenties;

		if (h1 == h2 && f1 == f2 && t1 == t2)
			return true;
		else
			return false;
	}

	/**************************************************
	 Method that returns true if the the total amount of money
	 in the this ATM is equal to the total amount of money in
	 another ATM
	 
	 @param ATM object
	 **************************************************/
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

	/**************************************************
	 Method that adds up the total amount of money of an 
	 ATM object given the number of hundreds, fifties, 
	 and twenties in it
	 
	 @param number of hundreds, fifties, and twenties
	 **************************************************/
	public int addTotal(int h, int f, int t) {
		return (h * 100) + (f * 50) + (t * 20);
	}

	/**************************************************
	 Method that adds up the total amount of money in
	 this ATM object 
	 **************************************************/
	public int addTotal() {
		return (this.hundreds * 100) + (this.fifties * 50) + (this.twenties * 20);
	}

	/**************************************************
	 Method that returns true if the the total amount of money
	 in two ATMs are equal to each other
	 
	 @param Two ATM objects (other1 and other2)
	 **************************************************/
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
		if ((h < 0) || (f < 0) || (t < 0)) {
			throw new IllegalArgumentException();
		} else {
			this.hundreds += h;
			this.fifties += f;
			this.twenties += t;
		}
	}

	public void putIn(ATM other) {
		this.hundreds += other.hundreds;
		this.fifties += other.fifties;
		this.twenties += other.twenties;
	}

	public void takeOut(int h, int f, int t) {
		if ((h < 0) || (f < 0) || (t < 0) || (suspend)) {
			throw new IllegalArgumentException();
		} else {
			this.hundreds -= h;
			this.fifties -= f;
			this.twenties -= t;
		}
	}

	public void takeOut(ATM other) {
		if (suspend) {
			throw new IllegalArgumentException();
		} else {
			this.hundreds -= other.hundreds;
			this.fifties -= other.fifties;
			this.twenties -= other.twenties;
		}
	}

	public ATM takeOut(double amount) {
		if ((amount < 0) || (amount % 10 != 0) || (suspend)) {
			throw new IllegalArgumentException();
		} else {
			double amountInitial = amount;
			int hFinal = 0, fFinal = 0, tFinal = 0;
			if (amount > this.addTotal()) {
				return null;
			} else {
				for (int h = this.hundreds; h >= 0; h--) {
					if ((h * 100) > amount) {
						continue;
					} else {
						hFinal = h;
						amount -= h * 100;
							for (int f = this.fifties; f >= 0; f--) {
								if ((f * 50) > amount) {
								continue;
							} else {
								fFinal = f;
								amount -= f * 50;
								for (int t = this.twenties; t >= 0; t--) {
									if ((t * 20) > amount) {
										continue;
									} else {
										tFinal = t;
										amount -= t * 20;
										break;
									}
								}
								break;
							}
						}
						break;
					}
				}
				
				if ((hFinal * 100) + (fFinal * 50) + (tFinal * 20) != amountInitial) {
					for (int t = this.twenties; t >= 0; t--) {
						if ((t * 20) > amount) {
							continue;
						} else {
									tFinal = t;
									amount -= t * 20;
									break;
								}
							}
						}
				
				System.out.println(hFinal);
				System.out.println(fFinal);
				System.out.println(tFinal);
				if (((hFinal * 100) + (fFinal * 50) + (tFinal * 20)) == amountInitial) {
					System.out.println("c");
					this.hundreds -= hFinal;
					this.fifties -= fFinal; 
					this.twenties -= tFinal;

					ATM takeOut = new ATM(hFinal, fFinal, tFinal);

					return takeOut;
				} else {
					return null;
				}
			
		}
		}
	}
					 /*
						 
					if ((amount % 50 == 0) && (this.fifties * 50 == amount)) {
						for (int f = this.fifties; f >= 0; f--) {
							if ((f * 50) > amount) {
								continue;
							} else {
								fFinal = f;
								amount -= f * 50;
								break;
							}
						}
					} else if ((amount % 20 == 0) && (this.twenties * 20 == amount)) {
						for (int t = this.twenties; t >= 0; t--) {
							if ((t * 20) > amount) {
								continue;
							} else {
								tFinal = t;
								amount -= t * 20;
								break;
							}
						}
					} else {
						for (int f = this.fifties; f>=0; f--) {
							for (int t = 1; t > this.fifties; t++) {
								if (((f * 50) + (t * 20)) == amount) {
									fFinal = f;
									tFinal = t;
									break;
								} else {
									continue;
								}
							}
					}
				}
				*/

	public String toString() {
		String h, f, t;
		if (this.hundreds == 1) {
			h = "" + this.hundreds + " hundred dollar bill,";
		} else {
			h = "" + this.hundreds + " hundred dollar bills,";
		}

		if (this.fifties == 1) {
			f = " " + this.fifties + " fifty dollar bill,";
		} else {
			f = " " + this.fifties + " fifty dollar bills,";
		}

		if (this.twenties == 1) {
			t = " " + this.twenties + " twenty dollar bill.";
		} else {
			t = " " + this.twenties + " twenty dollar bills.";
		}
		return "" + h + f + t;
	}

	public void save(String fileName) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		out.println(this.hundreds + " " + this.fifties + " " + this.twenties);
		out.close();
	}

	public void load(String fileName) {
		int h, f, t;

		try {
			// open data file
			Scanner fileReader = new Scanner(new File(fileName));

			// read one ATM object
			h = fileReader.nextInt();
			f = fileReader.nextInt();
			t = fileReader.nextInt();

			this.hundreds = h;
			this.fifties = f;
			this.twenties = t;

			System.out.println(this.hundreds + " " + this.fifties + " " + this.twenties);

			fileReader.close();
		}

		catch (Exception error) {
			System.out.println("File not found.");
		}
	}

	public static void suspend(Boolean on) {
		suspend = on;
	}

}

// 6 hours
