// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		int sum = x1;
		for (int i=0; i<Math.abs(x2); i++) {
			if (x2>0) {
			sum++;
			}
			else sum --;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int diff = x1;
		for (int i=0; i<Math.abs(x2); i++) {
			if (x2>0) {
			diff--;
			}
			else diff ++;
		}
		return diff;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int multi = 0;
		boolean x1Pos = true;
		boolean x2Pos = true;
		if (x1==0 || x2==0) return 0;
		if (x1<0) { // is x1 positive
			x1Pos = false;
		}
		if (x2<0) { // is x2 positive
			x2Pos = false;
		}
		if (x1Pos && !x2Pos) { // do it when x1 is positive and x2 is negative
			multi = minus(0, x1); // multi = neg x1
			for (int i=1; i<Math.abs(x2); i++) { //run abs.x2 iterations
				multi = plus (multi, minus(0, x1));
			}
		}
		else if (!x1Pos && x2Pos) { // do it when x1 is negative and x2 is positive
			multi = x1;
			for (int i=1; i<x2; i++) { // run x2 iterations
				multi = plus(multi,x1);
			}
		}
			else if (!x1Pos && !x2Pos) { // do it if both x1 and x2 are negative
				multi = Math.abs(x1);
				for (int i=1; i< Math.abs(x2); i++) { // run abs.x2 iterations
					multi = plus(multi, Math.abs(x1));
				}
			}
			else if (x1Pos && x2Pos) { // do it if both x1 and x2 are positive
				multi = x1;
				for (int i=1; i<x2; i++) { // run x2 iterations
					multi = plus(multi, x1);
				}
			}
			return multi;
		}

		
	

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int power = x;
		if (n==0) return 1;
		for (int i=1; i<n; i++) {
			power = times(power,x);
		}
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int divide = Math.abs(x1);
		int mana = 0;
		boolean x1Neg = false;
		boolean x2Neg = false;
		if (x1<0) x1Neg = true;
		if (x2<0) x2Neg = true;
		if (Math.abs(x1) < Math.abs(x2)) return 0;
		else {

			while (divide>= Math.abs(x2)) {
				divide = minus(divide,Math.abs(x2));
				mana++;
			}
			if ((x1Neg && !x2Neg) || (!x1Neg && x2Neg)) {
				mana = times(mana, -1);
			}
			return mana;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		if (x1<x2)
		return x1;
		else {
			int modolu = minus(x1, times(div(x1, x2), x2) );
			return modolu;
		}
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int square = 0;
		while (times(square, square)<x) {
			square++;
		}
		if (times(square, square) == x) {
			return square;
		}
		else return minus(square, 1);
	}	  	  
}