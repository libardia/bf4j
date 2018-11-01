package info.tonyl.bf4j.commands;

public class Print implements Command {
	@Override
	public void execute() {
		System.out.print();
	}
}
