package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.editcommand.EditCommand;
import seedu.address.logic.commands.editcommand.EditCustomerCommand.EditCustomerDescriptor;
import seedu.address.logic.commands.editcommand.EditPhoneCommand.EditPhoneDescriptor;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.customer.Customer;
import seedu.address.model.customer.predicates.CustomerNameContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.phone.Capacity;
import seedu.address.model.phone.Phone;
import seedu.address.model.phone.predicates.IdentityNumberContainsKeywordsPredicate;
import seedu.address.testutil.EditCustomerDescriptorBuilder;
import seedu.address.testutil.EditPersonDescriptorBuilder;
import seedu.address.testutil.EditPhoneDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_CONTACTNUMBER_AMY = "11111111";
    public static final String VALID_CONTACTNUMBER_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String VALID_NAME_ALICE = "Alice Lim";
    public static final String VALID_NAME_BEN = "Ben Ten";
    public static final String VALID_CONTACTNUMBER_ALICE = "98123459";
    public static final String VALID_CONTACTNUMBER_BEN = "83719038";
    public static final String VALID_EMAIL_ALICE = "alice@example.com";
    public static final String VALID_EMAIL_BEN = "ben@example.com";
    public static final String VALID_TAG_REGULAR = "Regular";
    public static final String VALID_TAG_RICH = "Rich";


    public static final String VALID_PHONENAME_IPHONE = "iPhone Pro 11";
    public static final String VALID_PHONENAME_SAMSUNG = "Galaxy S10";
    public static final String VALID_IDENTITYNUMBER_IPHONE = "013373005371667";
    public static final String VALID_IDENTITYNUMBER_SAMSUNG = "352039075644270";
    public static final String VALID_SERIALNUMBER_IPHONE = "1d27s9az";
    public static final String VALID_SERIALNUMBER_SAMSUNG = "29asdn1mx";
    public static final String VALID_COLOUR_IPHONE = "Purple";
    public static final String VALID_COLOUR_SAMSUNG = "Black";
    public static final String VALID_BRAND_IPHONE = "Apple";
    public static final String VALID_BRAND_SAMSUNG = "Samsung";
    public static final Capacity VALID_CAPACITY_IPHONE = Capacity.SIZE_128GB;
    public static final Capacity VALID_CAPACITY_SAMSUNG = Capacity.SIZE_256GB;
    public static final String VALID_COST_IPHONE = "$1649";
    public static final String VALID_COST_SAMSUNG = "$1298";
    public static final String VALID_PRICE_IPHONE = "$2000";
    public static final String VALID_PRICE_SAMSUNG = "$1500";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;
    public static final EditCustomerDescriptor DESC_ALICE;
    public static final EditCustomerDescriptor DESC_BEN;
    public static final EditPhoneDescriptor DESC_IPHONE;
    public static final EditPhoneDescriptor DESC_SAMSUNG;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

        DESC_ALICE = new EditCustomerDescriptorBuilder().withCustomerName(VALID_NAME_ALICE)
                .withContactNumber(VALID_CONTACTNUMBER_ALICE).withEmail(VALID_EMAIL_ALICE)
                .withTags(VALID_TAG_REGULAR).build();

        DESC_BEN = new EditCustomerDescriptorBuilder().withCustomerName(VALID_NAME_BEN)
                .withContactNumber(VALID_CONTACTNUMBER_BEN).withEmail(VALID_EMAIL_BEN)
                .withTags(VALID_TAG_RICH).build();

        DESC_IPHONE = new EditPhoneDescriptorBuilder().withPhoneName(VALID_PHONENAME_IPHONE)
                .withBrand(VALID_BRAND_IPHONE).withCapacity(VALID_CAPACITY_IPHONE).withCost(VALID_COST_IPHONE)
                .withColour(VALID_COLOUR_IPHONE).withSerialNumber(VALID_SERIALNUMBER_IPHONE)
                .withIdentityNumber(VALID_IDENTITYNUMBER_IPHONE).build();

        DESC_SAMSUNG = new EditPhoneDescriptorBuilder().withPhoneName(VALID_PHONENAME_SAMSUNG)
                .withBrand(VALID_BRAND_SAMSUNG).withCapacity(VALID_CAPACITY_SAMSUNG).withCost(VALID_COST_SAMSUNG)
                .withColour(VALID_COLOUR_SAMSUNG).withSerialNumber(VALID_SERIALNUMBER_SAMSUNG)
                .withIdentityNumber(VALID_IDENTITYNUMBER_SAMSUNG).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the customer at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showCustomerAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredCustomerList().size());

        Customer customer = model.getFilteredCustomerList().get(targetIndex.getZeroBased());
        final String[] splitName = customer.getCustomerName().fullName.split("\\s+");
        model.updateFilteredCustomerList(new CustomerNameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredCustomerList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the phone at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPhoneAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPhoneList().size());

        Phone phone = model.getFilteredPhoneList().get(targetIndex.getZeroBased());
        final String[] splitName = phone.getIdentityNumber().value.split("\\s+");
        model.updateFilteredPhoneList(new IdentityNumberContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPhoneList().size());
    }


}
