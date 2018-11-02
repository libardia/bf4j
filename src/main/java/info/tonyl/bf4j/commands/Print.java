package info.tonyl.bf4j.commands;

import info.tonyl.bf4j.lang.Environment;

public class Print implements Command {
	@Override
	public void execute() {
		System.out.print((char) Environment.value());
	}
}
