package me.on.intervw.refunite.string_trans4mer;

/**
 * This class calculates the minimum cost of transforming two strings, s1 and
 * s2, so that they are equal. The two strings are passed as constructor
 * arguments when instantiating this class.
 * 
 * The algorithm implemented in this class
 * 
 * @author nelson.okello
 *
 */
public class StringEqualizer {

	/**
	 * The first string to be transformed.
	 */
	private String s1;

	/**
	 * The second string to be transformed.
	 */
	private String s2;

	/**
	 * The constructor accepts the two strings to be transformed as arguments.
	 * 
	 * @param s1
	 *            The first string to be transformed
	 * @param s2
	 *            The second string to be transformed.
	 */
	public StringEqualizer(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	/**
	 * Calculates the minimum cost of transforming the two strings so that the
	 * two strings are equal.
	 * 
	 * @author nelson.okello
	 * 
	 * @return Returns the integer value of the minimum cost of transforming the
	 *         two strings so that they are equal.
	 */
	public int equalizingCost() {
		// If either string is empty, return the length of the string as the
		// minimum cost
		if (s1.isEmpty())
			return s2.length();
		if (s2.isEmpty())
			return s1.length();

		// Else, keep track of the original length of each string
		final int s1Length = s1.length();
		final int s2Length = s2.length();

		// Minimum cost matrix
		int[][] minCosts = new int[s1Length][s2Length];

		// Populate the cost matrix, starting with bottom right corner
		minCosts[s1Length - 1][s2Length - 1] = Util.initialCost(s1, s2,
				s1Length - 1, s2Length - 1);

		// Pre-populate all cells in the matrix with the least possible cost so
		// far
		for (int i = s2Length - 2; i >= 0; i--) {
			minCosts[s1Length - 1][i] = 1 + minCosts[s1Length - 1][i + 1];
		}

		for (int j = s1Length - 2; j >= 0; j--) {
			minCosts[j][s2Length - 1] = 1 + minCosts[j + 1][s2Length - 1];
		}

		// Now, calculate the cost of transforming s1 and s2 using each of the 3
		// strategies for each character; replace, delete, insert
		for (int i = s1Length - 2; i >= 0; i--) {
			for (int j = s2Length - 2; j >= 0; j--) {

				// Replace cost for the current character
				int replaceCost = Util.replaceCost(s1, s2, i, j)
						+ minCosts[i + 1][j + 1];

				// Delete cost for the current character
				int deleteCost = Util.deleteCost(s1, s2, i, j)
						+ minCosts[i + 1][j];

				// Insert cost for the current character
				int insertCost = Util.insertCost(s1, s2, i, j)
						+ minCosts[i][j + 1];

				// Update the cost matrix with the minimum cost of the three
				// possible transformation actions
				minCosts[i][j] = Util.min(replaceCost, deleteCost, insertCost);
			}
		}

		return minCosts[0][0];
	}
}

/**
 * Cost utility functions
 * 
 * @author nelson.okello
 *
 */
final class Util {

	/**
	 * 
	 * @param s1
	 *            Original s1 character sequence
	 * @param s2
	 *            Original s2 character sequence
	 * @param s1Index
	 *            The current index of string s1. For initial cost, s1 index is
	 *            the corresponds to the last character of s1
	 * @param s2Index
	 *            The current index of string s2. For initial cost, s2 index is
	 *            the corresponds to the last character of s2
	 * @return Returns the initial cost. Return 1 for non-empty strings, 0
	 *         otherwise
	 */
	public static int initialCost(String s1, String s2, int s1Index, int s2Index) {
		return (s1.charAt(s1Index) == s2.charAt(s2Index)) ? 0 : 1;
	}

	/**
	 * By requirement, an insertion transformation action is assigned a cost of
	 * 1 unit.
	 * 
	 * @param s1
	 *            Original s1 character sequence
	 * @param s2
	 *            Original s2 character sequence
	 * @param s1Index
	 *            The current index of string s1
	 * @param s2Index
	 *            The current index of string s2
	 * @return Returns the cost of insertion transformation action. Returns 1 if
	 *         the two current characters are not the same. Returns 0 otherwise.
	 */
	public static int insertCost(String s1, String s2, int s1Index, int s2Index) {
		return (s1.charAt(s1Index) == s2.charAt(s2Index)) ? 0 : 1;
	}

	/**
	 * By requirement, a deletion transformation action is assigned a cost of 1
	 * unit.
	 * 
	 * @param s1
	 *            Original s1 character sequence
	 * @param s2
	 *            Original s2 character sequence
	 * @param s1Index
	 *            The current index of string s1
	 * @param s2Index
	 *            The current index of string s2
	 * @return Returns the cost of deletion transformation action. Returns 1 if
	 *         the two current characters are not the same. Returns 0 otherwise.
	 */
	public static int deleteCost(String s1, String s2, int s1Index, int s2Index) {
		return (s1.charAt(s1Index) == s2.charAt(s2Index)) ? 0 : 1;
	}

	/**
	 * By requirement, a replace transformation action is assigned a cost of 2
	 * units.
	 * 
	 * @param s1
	 *            Original s1 character sequence
	 * @param s2
	 *            Original s2 character sequence
	 * @param s1Index
	 *            The current index of string s1
	 * @param s2Index
	 *            The current index of string s2
	 * @return Returns the cost of deletion transformation action. Returns 1 if
	 *         the two current characters are not the same. Returns 0 otherwise.
	 */
	public static int replaceCost(String s1, String s2, int s1Index, int s2Index) {
		return (s1.charAt(s1Index) == s2.charAt(s2Index)) ? 0 : 2;
	}

	/**
	 * A utility function that returns the minimum value of an arbitrary array
	 * of integers
	 * 
	 * @param numbers
	 *            Arbitrary array of integers
	 * @return Returns the minimum cost integer
	 */
	public static int min(int... numbers) {
		int result = Integer.MAX_VALUE;
		for (int i : numbers) {
			result = Math.min(result, i);
		}
		return result;
	}
}
