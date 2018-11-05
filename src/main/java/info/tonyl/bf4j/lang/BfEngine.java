package info.tonyl.bf4j.lang;

import java.util.HashMap;
import java.util.Map;

import info.tonyl.bf4j.options.Options;
import info.tonyl.opper.Opper;

public class BfEngine {
	private static Map<Integer, Integer> cells = new HashMap<>();
	private static int pos = 0;
	private static int boundLeft = 0;
	private static int boundRight = 0;

	public static void moveLeft() {
		pos--;
		if (pos < boundLeft) {
			boundLeft = pos;
		}
	}

	public static void moveRight() {
		pos++;
		if (pos > boundRight) {
			boundRight = pos;
		}
	}

	public static void moveTo(int position) {
		pos = position;
		if (pos < boundLeft) {
			boundLeft = pos;
		} else if (pos > boundRight) {
			boundRight = pos;
		}
	}

	public static int value() {
		validate();
		return cells.get(pos);
	}

	public static void increment() {
		validate();
		int newValue = cells.get(pos) + 1;
		if (newValue > 255) {
			newValue = 0;
		}
		cells.put(pos, newValue);
	}

	public static void decrement() {
		validate();
		int newValue = cells.get(pos) - 1;
		if (newValue < 0) {
			newValue = 255;
		}
		cells.put(pos, newValue);
	}

	public static void validateAt(int position) {
		if (!cells.containsKey(position)) {
			cells.put(position, 0);
		}
	}

	public static void validate() {
		validateAt(pos);
	}

	public static void dumpMemory(char command) {
		System.out.print(command + ": ");
		for (int i = boundLeft; i <= boundRight; i++) {
			int value = 0;
			if (cells.containsKey(i)) {
				value = cells.get(i);
			}

			StringBuilder cell = new StringBuilder();
			cell.append("[");
			if (i == pos) {
				cell.append(">");
			} else {
				cell.append(" ");
			}
			cell.append(value);
			cell.append(" ]");
			System.out.print(cell.toString());
		}
		System.out.println();
	}

	public static int match(String script, int start) {
		int depth = 0;

		for (int i = start; i < script.length(); i++) {
			switch (script.charAt(i)) {
			case Commands.BEGIN_LOOP:
				depth++;
				break;
			case Commands.END_LOOP:
				depth--;
				break;
			}

			if (depth == 0) {
				return i;
			}
		}

		return -1;
	}

	public static void execute(String script, String input) {
		Map<Integer, Integer> forwardMatches = new HashMap<>();
		Map<Integer, Integer> backwardMatches = new HashMap<>();

		for (int commandPos = 0; commandPos < script.length(); commandPos++) {
			switch (script.charAt(commandPos)) {
			case Commands.MOVE_LEFT:
				moveLeft();
				break;
			case Commands.MOVE_RIGHT:
				moveRight();
				break;
			case Commands.INCREMENT:
				increment();
				break;
			case Commands.DECREMENT:
				decrement();
				break;
			case Commands.PRINT:
				break;
			case Commands.READ:
				break;
			case Commands.BEGIN_LOOP:
				if (!forwardMatches.containsKey(commandPos)) {
					int end = match(script, commandPos);
					forwardMatches.put(commandPos, end);
					backwardMatches.put(end, commandPos);
				}
				if (value() == 0) {
					commandPos = forwardMatches.get(commandPos);
				}
				break;
			case Commands.END_LOOP:
				if (value() != 0) {
					commandPos = backwardMatches.get(commandPos);
				}
				break;
			case Commands.DUMP_MEMORY:
				dumpMemory(script.charAt(commandPos));
				break;
			}

			if (Opper.isSet(Options.DEBUG)) {
				dumpMemory(script.charAt(commandPos));
			}
		}
	}
}
