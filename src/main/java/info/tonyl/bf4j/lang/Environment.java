package info.tonyl.bf4j.lang;

import java.util.HashMap;
import java.util.Map;

public class Environment {
	private static Map<Integer, Byte> cells = new HashMap<>();
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
		}
		if (pos > boundRight) {
			boundRight = pos;
		}
	}

	public static int position() {
		return pos;
	}

	public static byte value() {
		validate();
		return cells.get(pos);
	}

	public static void increment() {
		validate();
		cells.put(pos, (byte) (cells.get(pos) + 1));
	}

	public static void decrement() {
		validate();
		cells.put(pos, (byte) (cells.get(pos) - 1));
	}

	public static void validateAt(int position) {
		if (!cells.containsKey(pos)) {
			cells.put(pos, (byte) 0);
		}
	}

	public static void validate() {
		validateAt(pos);
	}
}
