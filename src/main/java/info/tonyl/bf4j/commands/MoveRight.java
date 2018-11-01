package info.tonyl.bf4j.commands;

import info.tonyl.bf4j.lang.Environment;

public class MoveRight implements Command {
	@Override
	public void execute() {
		Environment.moveRight();
	}
}
