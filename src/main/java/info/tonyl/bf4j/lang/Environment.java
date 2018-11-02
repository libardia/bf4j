package info.tonyl.bf4j.lang;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Environment {
	private static Map<Integer, Integer> cells = new HashMap<>();
	private static int pos = 0;
	private static int boundLeft = 0;
	private static int boundRight = 0;
	private static InputStream input;

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
		}
		if (pos > boundRight) {
			boundRight = pos;
		}
	}

	public static int position() {
		return pos;
	}

	public static int value() {
		validate();
		return cells.get(pos);
	}

	public static void increment() {
		validate();
		cells.put(pos, (cells.get(pos) + 1));
	}

	public static void decrement() {
		validate();
		cells.put(pos, (cells.get(pos) - 1));
	}

	public static void validateAt(int position) {
		if (!cells.containsKey(pos)) {
			cells.put(pos, 0);
		}
	}

	public static void validate() {
		validateAt(pos);
	}
}
