package info.tonyl.bf4j.lang;

public class Commands {
	// Standard
	public static final char INCREMENT = '+';
	public static final char DECREMENT = '-';
	public static final char MOVE_LEFT = '<';
	public static final char MOVE_RIGHT = '>';
	public static final char PRINT = '.';
	public static final char READ = ',';
	public static final char BEGIN_LOOP = '[';
	public static final char END_LOOP = ']';

	// Custom
	public static final char DUMP_MEMORY = '*';
	public static final char COMMENT = '#';

	// All commands
	public static final char[] ALL = { INCREMENT, DECREMENT, MOVE_LEFT, MOVE_RIGHT, PRINT, READ, BEGIN_LOOP, END_LOOP,
			DUMP_MEMORY };
}
