package info.tonyl.bf4j;

import info.tonyl.bf4j.options.Options;
import info.tonyl.opper.Opper;

public class Bf4jApp {
	public static void main(String[] args) {
		Options.registerAndParse(args);

		for (String k : Opper.getAllSetOptions()) {
			System.out.print("Option " + k);

			if (Opper.hasValue(k)) {
				System.out.println(" has value " + Opper.getValueOf(k));
			} else {
				System.out.println(" is set.");
			}
		}
	}
}
