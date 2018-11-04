package info.tonyl.bf4j;

import info.tonyl.bf4j.lang.Minimizer;

public class Bf4jApp {
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("Input:     " + args[0]);
			System.out.println("Minimized: " + Minimizer.minimize(args[0]));
		} else {
			System.out.println("No input.");
		}
	}
}
