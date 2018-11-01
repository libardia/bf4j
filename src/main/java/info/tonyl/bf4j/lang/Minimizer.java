package info.tonyl.bf4j.lang;

import info.tonyl.bf4j.commands.CommandCharacters;

public class Minimizer {
	public static String minimize(String script) {
		StringBuilder result = new StringBuilder();

		// Remove all characters that are in a comment or that are not commands
		boolean inComment = false;
		for (int i = 0; i < script.length(); i++) {
			char c = script.charAt(i);

			if (!inComment) {
				if (c == CommandCharacters.COMMENT) {
					inComment = true;
				}

				for (char cmd : CommandCharacters.ALL) {
					if (c == cmd) {
						result.append(c);
					}
				}
			} else if (c == '\n') {
				inComment = false;
			}
		}

		// Remove the "opening comment" if there is one
		if (result.charAt(0) == CommandCharacters.BEGIN_LOOP) {
			int depth = 1;
			int position = 1;
			while (depth > 0 && position < result.length()) {
				switch (result.charAt(position)) {
				case CommandCharacters.BEGIN_LOOP:
					depth++;
					break;
				case CommandCharacters.END_LOOP:
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
