package info.tonyl.bf4j.commands;

import info.tonyl.bf4j.lang.Environment;

public class Increment implements Command {
	@Override
	public void execute() {
		Environment.increment();
	}
}
