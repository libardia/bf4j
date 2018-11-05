package info.tonyl.bf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import info.tonyl.bf4j.lang.BfEngine;
import info.tonyl.bf4j.lang.Minimizer;
import info.tonyl.bf4j.options.Options;
import info.tonyl.opper.Opper;

public class Bf4jApp {
	public static void main(String[] args) throws IOException {
		Options.registerAndParse(args);

		String script = "";
		String input = Opper.getValueOf(Options.INPUT);

		if (Opper.isSet(Options.FILE)) {
			byte[] bytes = Files.readAllBytes(Paths.get(Opper.getValueOf(Options.FILE)));
			script = new String(bytes);
		} else if (Opper.isSet(Options.SCRIPT)) {
			script = Opper.getValueOf(Options.SCRIPT);
		} else {
			script = Opper.getNamelessValues()[0];
		}

		script = Minimizer.minimize(script);

		BfEngine.execute(script, input);
	}
}
