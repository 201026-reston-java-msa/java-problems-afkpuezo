/**
 * Andrew Curry
 */
package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		String ans = "";
		
		for (int i = string.length() - 1; i >= 0; i--) {
			ans = ans + string.charAt(i);
		}
		
		return ans;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String ans = "";
		
		String[] tokens = phrase.split(" |, |-");
		
		for (String t : tokens) {
			ans = ans + Character.toUpperCase(t.charAt(0));
		}
		
		return ans;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			return (sideOne == sideTwo) && (sideTwo == sideThree);
		}

		public boolean isIsosceles() {
			return ((!isEquilateral()) && (!isScalene()));
		}

		public boolean isScalene() {
			return (sideOne != sideTwo) && (sideTwo != sideThree) && (sideThree != sideOne);
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		HashMap<Character, Integer> scoreMap = new HashMap<Character, Integer>(){{
			put('A', 1);
			put('E', 1);
			put('I', 1);
			put('O', 1);
			put('U', 1);
			put('L', 1);
			put('N', 1);
			put('R', 1);
			put('S', 1);
			put('T', 1);
			
			put('D', 2);
			put('G', 2);
			
			put('B', 3);
			put('C', 3);
			put('M', 3);
			put('P', 3);
			
			put('F', 4);
			put('H', 4);
			put('V', 4);
			put('W', 4);
			put('Y', 4);
			
			put('K', 5);
			
			put('J', 8);
			put('X', 8);
			
			put('Q', 10);
			put('Z', 10);
		}};
		
		int score = 0;
		
		for (char c : string.toUpperCase().toCharArray()) {
			score += scoreMap.get(c);
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String ans = "";
		
		for (char c : string.toCharArray()) {
			if (Character.isDigit(c)) {
				ans = ans + c;
			}
			else if (Character.isLetter(c)) {
				IllegalArgumentException e = new IllegalArgumentException();
				throw(e);
			}
		}
		
		return ans;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		
		String[] words = string.split(",\\n|\\n| |, |,");
		
		for (String w : words) {
			if (countMap.containsKey(w)) {
				countMap.put(w, countMap.get(w) + 1);
			}
			else {
				countMap.put(w,  1);
			}
		}
		
		return countMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private static final int NOT_FOUND = -1; // not sure what indication to use, tests dont specify
		
		private List<T> sortedList;

		public int indexOf(T t) {
			int index = indexOfHelp(t, 0, sortedList.size());
			
			/*
			System.out.println("--------");
			System.out.println("list is: " + sortedList);
			System.out.println("t is: " + t);
			System.out.println("index is: " + index);
			*/
			
			return index;
		}
		
		/**
		 * Helper method for indexOf - recursively searches through segments of the list
		 * @param t
		 * @param start
		 * @param end // NOT inclusive
		 * @return
		 */
		private int indexOfHelp(T t, int start, int end) {
			if ((end - start) <= 0) {
				//System.out.println("    returning not found");
				return NOT_FOUND;
			}
			

			int middle = start + ((end - start) / 2);
			
			if (t.equals(sortedList.get(middle))) {
				//System.out.println("    returning middle");
				return middle;
			}
			// recur
			int left = indexOfHelp(t, start, middle);
			if (left != NOT_FOUND) {
				//System.out.println("    returning left");
				return left;
			}
			int right = indexOfHelp(t, middle + 1, end);
			//System.out.println("    returning right");
			return right;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String ans = "";
		
		if (string.length() < 1) {
			return ans;
		}
		
		String[] words = string.split(" "); // only spaces in test sample
		
		ans = toPigLatinHelp(words[0]); // no space before first word
		
		for (int i = 1; i < words.length; i++) {
			ans = ans + " " + toPigLatinHelp(words[i]);
		}
		
		/*
		System.out.println("------");
		System.out.println("input is: " + string);
		System.out.println("output is: " + ans);
		*/
		
		return ans;
	}
	
	private static final String[] vowelSounds = new String[] {
		"a", "e", "i", "o", "u"	
	};
	
	// this is probably not all inclusive but it should pass the tests
	// multi-letter sounds are listed first to avoid being split
	private static final String[] consonantSounds = new String[] {
		"ch", "sh", "sch", "th", "wh", "bl", "br", "cl", "cr", "dr", "fl", "fr",
		"gl", "gr", "kl", "kr", "pl", "pr", "qu", "sk", "sl", "sm", "sn", "sp", "st", "sw",
		"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", 
		"s", "t", "v", "w", "x", "y", "z" 
	};
	
	/**
	 * Handles one word at a time
	 * @param word
	 * @return
	 */
	private String toPigLatinHelp(String word) {
		
		for (String vs : vowelSounds) {
			if (word.startsWith(vs)){
				return word + "ay";
			}
		}
		
		// didn't find a vowel
		for (String cs : consonantSounds) {
			if (word.startsWith(cs)) {
				int len = cs.length();
				return word.substring(len) + cs + "ay";
			}
		}
		
		return ""; // catchall return, hopefully never reached
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// using a String is slow but easy
		String s = "" + input; // String constructor was giving me issues
		int numDigits = s.length();
		
		int sum = 0;
		
		for (int i = 0; i < numDigits; i++) {
			int d = s.charAt(i) - '0';
			sum += Math.pow(d, numDigits);
		}
		
		return (sum == input);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * ANDREW'S NOTE: I commented out the testProductOfPrimes() because it took a very long time to run,
	 * 				  but this solution does solve it correctly.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long L) {
		List<Long> factors = new ArrayList<Long>();
		
		for (long f = 2; f < (L / 2); f++) {
			if (isPrime(f)) {
				// check divisibility
				if ((L % f) == 0) {
					long repeat = checkPrimeFactorRepeats(f, L); // if l is a power of f, reflect that
					for (long i = 0; i < repeat; i++) {
						factors.add(f);
					}
				}
			}
		}
		
		// is l prime itself?
		if (isPrime(L)) {
			factors.add(L);
		}
	
		return factors;
	}
	
	/**
	 * Helper method that checks if the given long is a prime number.
	 * Currently slow/wasteful.
	 * @param n
	 * @return boolean
	 */
	private boolean isPrime(long n) {
		
		for (long i = 2; i < n; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * A helper method that returns the largest value n, where f^n is a factor of L.
	 * @param f
	 * @param l
	 * @return
	 */
	private long checkPrimeFactorRepeats(long f, long L) {
		long product = f; // bad name
		long power = 1;
		
		for (long n = 2; product < L; n++) {
			product = (long) Math.pow(f, n);
			if ((L % product) == 0) {
				power = n;
			}
		}
		
		return power;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		private static final char[] ALPHABET = new char[] {
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String scrambled = "";
			
			for (char c : string.toCharArray()) {
				if (Character.isLetter(c))
				{
					boolean isUpper = Character.isUpperCase(c);
					c = Character.toLowerCase(c);
					
					int index = letterToInt(c) + key;
					// fix wraparound
					while (index >= ALPHABET.length) {
						index -= ALPHABET.length;
					}
					
					c = intToLetter(index);
					if (isUpper) {
						c = Character.toUpperCase(c);
					}
					scrambled = scrambled + c;
				}
				else { // if not a letter, leave it alone
					scrambled = scrambled + c;
				}
			}
			
			// System.out.println(string + " -> " + scrambled);
			return scrambled;
		}
		
		/**
		 * Helper method (excessive, technically)
		 * @param n
		 * @return char
		 */
		private static char intToLetter(int n) {
			return ALPHABET[n];
		}
		
		/**
		 * Helper method, essentially indexOf
		 * @param c
		 * @return
		 */
		private static int letterToInt(char c) {
			for (int i = 0; i < ALPHABET.length; i++) {
				if (ALPHABET[i] == c) {
					return i;
				}
			}
			
			return -1; // catchall, shouldn't happen
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * ANDREW'S NOTE: This uses the isPrime helper method from a previous problem/solution.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		if (i < 1) {
			IllegalArgumentException e = new IllegalArgumentException();
			throw(e);
		}
		
		int numPrimes = 0;
		int currentPrime = -1; // ignored value
		
		for (int n = 2; numPrimes < i; n++) {
			if (isPrime(n)) {
				numPrimes++;
				currentPrime = n;
			}
		}
		
		// System.out.println(i + " -> " + currentPrime);
		return currentPrime;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 * 
	 * ANDREW'S NOTE: This solution re-uses some code from the earlier cipher problem.
	 *
	 */
	static class AtbashCipher {
		
		private static final char[] ALPHABET = new char[] {
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
		};

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String message = "";
			int letterSpaceCount = -1; // first space doesnt occur until just before 6th char
			
			for (char c : string.toCharArray()) {
				if (Character.isLetter(c)) {
					letterSpaceCount++; 
					if (letterSpaceCount == 5) { // insert a space every 5 letters
						message = message + " ";
						letterSpaceCount = 0;
					}
					message = message + invertLetter(Character.toLowerCase(c));
				}
				else if (Character.isDigit(c)) {
					letterSpaceCount++; 
					if (letterSpaceCount == 5) { // insert a space every 5 letters
						message = message + " ";
						letterSpaceCount = 0;
					}
					message = message + c;
				}
			}
			
			//System.out.println(string + " -> " + message);
			return message;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String message = "";
			
			for (char c : string.toCharArray()) {
				if (Character.isLetter(c)) {
					message = message + invertLetter(c);
				}
				else if (Character.isDigit(c)) {
					message = message + c;
				}
			}
			
			// System.out.println(string + " -> " + message);
			return message;
		}
		
		/**
		 * A helper method that encodes/decodes a single letter.
		 * 
		 * @param c: A lowercase letter
		 * @return the 'inverse' letter (eg, a -> z)
		 */
		private static char invertLetter(char c) {
			
			int index = letterToInt(c);
			
			return intToLetter(ALPHABET.length - index - 1);
		}
		
		/**
		 * Helper method (excessive, technically)
		 * @param n
		 * @return char
		 */
		private static char intToLetter(int n) {
			return ALPHABET[n];
		}
		
		/**
		 * Helper method, essentially indexOf
		 * @param c
		 * @return
		 */
		private static int letterToInt(char c) {
			for (int i = 0; i < ALPHABET.length; i++) {
				if (ALPHABET[i] == c) {
					return i;
				}
			}
			
			return -1; // catchall, shouldn't happen
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		boolean ans = bookNumberHelp(string);
		//System.out.println(string + " -> " + ans);
		return ans;
	}
	
	/**
	 * I split this off into a separate method for testing/verification purposes
	 * @param string
	 * @return
	 */
	private boolean bookNumberHelp(String string) {
		int multiplier = 10;
		int total = 0;
		
		for (char c : string.toCharArray()) {
			if (Character.isDigit(c)) {
				total += multiplier * ((int) c - '0'); // digit to correct int
				multiplier--;
				if (multiplier < 2) { // handle check character differently
					break; 
				}
			}
			else if (c != '-') { // if an invalid char
				// System.out.println("    Failing on invalid char: " + c);
				return false;
			}
		}
		
		// now take care of the last character
		int checkNum = 0;
		char checkChar = string.charAt(string.length() - 1);
		if (checkChar == 'X' || checkChar == 'x') {
			checkNum = 10;
		}
		else if (Character.isDigit(checkChar)) {
			checkNum = checkChar - '0';
		}
		else { // not a digit or X
			return false;
		}
		
		total += checkNum;
		
		return (total % 11) == 0;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		ArrayList<Character> unusedLetters = new ArrayList<Character>(
				Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
								'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));		
		
		for (char c : string.toCharArray()) {
			unusedLetters.remove(new Character(Character.toLowerCase(c)));
		}
		
		return unusedLetters.isEmpty();
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	// SKIPPED
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		ArrayList<Integer> multiples = new ArrayList<Integer>();
		
		for (int n = 1; n < i; n++) {
			if (isMultiple(n, set)) {
				multiples.add(n);
			}
		} // end outer (n) loop
		
		int sum = 0;
		for (int n = 0; n < multiples.size(); n++) {
			sum += multiples.get(n);
		}
		
		// System.out.println(i + " and  " + set + " -> " + sum);
		return sum;
	}
	
	/**
	 * A helper method - returns true if n is a multiple of any member of set
	 * @param n
	 * @param set
	 * @return
	 */
	private boolean isMultiple(int n, int[] set) {
		for (int s : set) {
			if (n % s == 0) {
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		int digitSum = 0;
		boolean everyOther = false; // could be an int i guess
		
		for (int i = string.length() - 1; i >= 0; i--) {
			char c = string.charAt(i);
			if (Character.isDigit(c)) {
				int d = c - '0';
				if (everyOther){
					// handle doubling
					d *= 2;
					if (d > 9) {
						d -= 9;
					}
				}
				everyOther = !everyOther;
				digitSum += d;
			}
			else if (c != ' ') {
				// System.out.println(string + " ->  false");
				return false; // invalid char
			}
			
		}
		
		// System.out.println(string + " -> " + ((digitSum % 10) == 0));
		return (digitSum % 10) == 0;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// System.out.println("check: " + string);
		String[] tokens = string.split(" ");
		int a = Integer.parseInt(tokens[2]); // assume position based on format
		//remove ? from second number
		String bTemp = tokens[tokens.length - 1];
		bTemp = bTemp.substring(0, bTemp.length() - 1);
		int b = Integer.parseInt(bTemp);
		
		
		String operator = tokens[3].toLowerCase(); // don't need the 'by'
		int ans = 0;
		
		switch (operator) {
			case "plus":
				ans = a + b;
				break;
			case "minus":
				ans = a - b;
				break;
			case "multiplied":
				ans = a * b;
				break;
			case "divided":
				ans = a / b;
				break;
		}
		
		// System.out.println(string + " -> " + ans);
		return ans;
	}

}
