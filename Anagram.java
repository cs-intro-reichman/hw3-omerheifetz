/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String strCheck1 = preProcess(str1);
		String strCheck2 = preProcess(str2);
		String buildWord = "";
		int place = 0;
		boolean isLetterAppear = true;
		boolean checkAnagram = true;
		if (strCheck1.length() != strCheck2.length()) {
			return false;
		}
		while (place<strCheck1.length() && isLetterAppear==true) {
			isLetterAppear = false;
			for (int j=0; j<strCheck2.length(); j++) {
				if (strCheck1.charAt(place) == strCheck2.charAt(j)) { 
					isLetterAppear = true;
					for (int f=0; f<strCheck2.length(); f++) {
						if (f!=j) {
							buildWord = buildWord + strCheck2.charAt(f);
						}
					}
					j=strCheck2.length()+1;
					strCheck2 = buildWord;
					buildWord = "";
				}
			}
			place++;
		}
		if (place == strCheck1.length()) return true;
		else return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String wordProcessed = "";
		String checkIfLetter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String strBuild = "";
		String strLower = "";
		for (int i=0; i< str.length(); i++) {
			if (checkIfLetter.indexOf(str.charAt(i)) !=-1) {
				strBuild = strBuild + str.charAt(i);
			}
		}
		for (int i=0; i<strBuild.length(); i++) {
			strLower = strLower + Character.toLowerCase(strBuild.charAt(i));
		}
		return strLower;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String strResult = "";
		String strSource = str;
		String buildWord = "";
		int randomPlace = 0;
		for (int i=0; i<str.length();i++) {
			randomPlace = (int) (Math.random()*(strSource.length()-1));
			strResult = strResult + strSource.charAt(randomPlace);
			if (strResult.length()<str.length()) {
			for (int j=0; j<strSource.length(); j++) {
				if (j!=randomPlace) {
					buildWord = buildWord + strSource.charAt(j);
				}
			}
		}
			strSource = buildWord;
			buildWord = "";
		}
		return strResult;
	}
}
