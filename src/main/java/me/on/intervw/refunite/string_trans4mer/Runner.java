package me.on.intervw.refunite.string_trans4mer;

import java.util.Scanner;

/**
 * This application calculates the minimum cost of transforming two strings, s1
 * and s2, so that the two strings are the same. All leading and trailing
 * slashes are removed before transformation
 * 
 * @author nelson.okello
 *
 */
public class Runner {

	private static final char SEP = '-';

	private static final String INTRO = "This application calculates the minimum cost of making two strings equal";

	/**
	 * Displays the interaction console. Strings to be transformed are passed as
	 * command line arguments. The two strings to be transformed must be
	 * separated by '#'
	 * 
	 * To exit the application, type '-1' and press Enter key
	 * 
	 * @author nelson.okello
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n\n"
				+ new String(new char[INTRO.length()]).replace('\0', SEP));
		System.out.println(INTRO);
		System.out.println(new String(new char[INTRO.length()]).replace('\0',
				SEP));
		Scanner scanner = new Scanner(System.in);

		boolean more = true;
		while (more) {
			System.out.println("\n\nACTION REQUIRED");
			System.out.println(new String(new char["ACTION REQUIRED".length()])
					.replace('\0', SEP));
			System.out.print("Enter the first string: ");
			String inputLineS1 = scanner.nextLine();

			System.out.print("Enter the second string: ");
			String inputLineS2 = scanner.nextLine();

			if (inputLineS1.trim().equals("-1")
					|| inputLineS2.trim().equals("-1"))
				more = false;

			else {
				StringEqualizer equalizer = new StringEqualizer(
						inputLineS1.trim(), inputLineS2.trim());

				System.out.println("Minimum Cost: "
						+ equalizer.equalizingCost());
			}
		}

		System.out.println("\nExiting...");
	}
}
