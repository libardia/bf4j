package info.tonyl.bf4j.options;

import info.tonyl.opper.Opper;

public class Options {
	public static final String FILE = "f";
	public static final String FILE_LONG = "file";
	public static final String INPUT = "i";
	public static final String SCRIPT = "s";
	public static final String SHOW_MINIMIZED = "m";
	public static final String DEBUG = "D";

	public static void registerAndParse(String[] args) {
		Opper.registerWithValue(FILE, FILE_LONG);
		Opper.registerMultipleWithValue(SCRIPT, INPUT);
		Opper.registerMultiple(SHOW_MINIMIZED, DEBUG);
		Opper.parse(args);
	}
}
