package info.tonyl.bf4j.lang;

public class Minimizer {
	public static String minimize(String script) {
		StringBuilder result = new StringBuilder();

		// Remove all characters that are in a comment or that are not commands
		boolean inComment = false;
		for (int i = 0; i < script.length(); i++) {
			char c = script.charAt(i);

			if (!inComment) {
				if (c == Commands.COMMENT) {
					inComment = true;
				}

				for (char cmd : Commands.ALL) {
					if (c == cmd) {
						result.append(c);
					}
				}
			} else if (c == '\n') {
				inComment = false;
			}
		}

		// Remove the "opening comment" if there is one
		if (result.length() != 0 && result.charAt(0) == Commands.BEGIN_LOOP) {
			int depth = 1;
			int position = 1;
			while (depth > 0 && position < result.length()) {
				switch (result.charAt(position)) {
				case Commands.BEGIN_LOOP:
					depth++;
					break;
				case Commands.END_LOOP:
					depth--;
					break;
				}
				position++;
			}

			result.delete(0, position);
		}

		return result.toString();
	}
}
