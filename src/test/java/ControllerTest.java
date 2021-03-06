package test.java;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.java.Controller;
import main.java.OSInfo;
import main.java.Suggestion;

public class ControllerTest {
	private Controller controller;
	private static final int CONFIG = 0;
	private static final int HOTKEY = 1;

	@Before
	public void setUp() throws Exception {
		controller = new Controller();
	}

	@Test
	public void testMap() {
		Map<String, Suggestion> suggestionsMap = new HashMap<String, Suggestion>();

		// Hotkeys that vary between operating systems
		if (OSInfo.isMac() || OSInfo.isUnix() ) {
			suggestionsMap.put("blockCommentSuggestion", new Suggestion("blockCommentSuggestion", "Try using 'CMD + /' to comment several lines.", HOTKEY, true));
			suggestionsMap.put("variableRenameRefactorSuggestion", new Suggestion("variableRenameRefactorSuggestion", "Try using 'CMD + OPTION + R' to rename all instances of a variable, class, or method.", HOTKEY, true));
			suggestionsMap.put("addImportStatementsSuggestion", new Suggestion("addImportStatementsSuggestion", "Try using 'CMD + SHIFT + O' to add import statements.", HOTKEY, true));
			suggestionsMap.put("removeUnusedImportStatementsSuggestion", new Suggestion("removeUnusedImportStatementsSuggestion", "Try using 'CMD + SHIFT + O' to remove unused imports.", HOTKEY, true));
			suggestionsMap.put("correctIndentationsSuggestion", new Suggestion("correctIndentationsSuggestion", "Try using 'CMD + I' to correct indentation.", HOTKEY, true));
		} else {  // Windows
			suggestionsMap.put("blockCommentSuggestion", new Suggestion("blockCommentSuggestion", "Try using 'CTRL + /' to comment several lines.", HOTKEY, true));
			suggestionsMap.put("variableRenameRefactorSuggestion", new Suggestion("variableRenameRefactorSuggestion", "Try using 'ALT + SHIFT + R' to rename all instances of a variable, class, or method.", HOTKEY, true));
			suggestionsMap.put("addImportStatementsSuggestion", new Suggestion("addImportStatementsSuggestion", "Try using 'CTRL + SHIFT + O' to add import statements.", HOTKEY, true));
			suggestionsMap.put("removeUnusedImportStatementsSuggestion", new Suggestion("removeUnusedImportStatementsSuggestion", "Try using 'CTRL + SHIFT + O' to remove unused imports.", HOTKEY, true));
			suggestionsMap.put("correctIndentationsSuggestion", new Suggestion("correctIndentationsSuggestion", "Try using 'CTRL + I' to correct indentation.", HOTKEY, true));
		}

		// Hotkeys that remain the same between operating systems
		suggestionsMap.put("getterSetterSuggestion", new Suggestion("getterSetterSuggestion", "Try using 'ALT + SHIFT + S, R' to automatically generate getters and setters.", HOTKEY, true));

		// Configurations
		suggestionsMap.put("enableAutocompleteSuggestion", new Suggestion("enableAutocompleteSuggestion", "Enable content assist auto activation", CONFIG, true));
		suggestionsMap.put("enableSmartSemicolonSuggestion", new Suggestion("enableSmartSemicolonSuggestion", "Enable smart semicolon activation", CONFIG, true));
		suggestionsMap.put("enableShadowedVariableWarning", new Suggestion("enableShadowedVariableWarning", "Enable shadowed variable warning", CONFIG, true));
		suggestionsMap.put("trailingWhiteSpaceSuggestion", new Suggestion("trailingWhiteSpaceSuggestion", "Automatically remove trailing white spaces on save", CONFIG, true));
		
		assertTrue(suggestionsMap.equals(controller.getSuggestionsMap()));
	}
}
