package info.tonyl.bf4j;

import info.tonyl.bf4j.options.Options;
import info.tonyl.opper.Opper;

public class Bf4jApp {
	public static void main(String[] args) {
		Options.registerAndParse(args);
		System.out.println(Opper.tempGetOptions());
	}
}
