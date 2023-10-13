package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.commands.ViewCommand.MESSAGE_ARGUMENTS;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ViewCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        final String category = "appointments";
        assertCommandFailure(new ViewCommand(category), model,
                String.format(MESSAGE_ARGUMENTS, category));
    }

    @Test
    public void equals() {
        final ViewCommand standardCommand = new ViewCommand(VALID_CATEGORY_APPOINTMENT);

        // same values -> returns true
        ViewCommand commandWithSameValues = new ViewCommand(VALID_CATEGORY_APPOINTMENT);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different category -> returns false
        assertFalse(standardCommand.equals(new ViewCommand(VALID_CATEGORY_STUDENT)));
    }
}
