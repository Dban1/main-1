package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.Remark;
import seedu.address.testutil.PersonBuilder;

class RemarkCommandTest {

    private static final String REMARK_STUB = "test remark";

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    void  execute_addRemarkUnfilteredList_success() {

        Person personOne = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person personTwo = new PersonBuilder(personOne).withRemark(REMARK_STUB).build();
        Remark remark = new Remark(personTwo.getRemark().value);
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON,remark);

        String expected_message = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, personTwo);
        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(personOne, personTwo);


        assertCommandSuccess(remarkCommand,model,expected_message,expectedModel);
    }
}