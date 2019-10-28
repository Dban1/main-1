package seedu.address.logic.commands.clearcommand;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.UiChange;
import seedu.address.model.DataBook;
import seedu.address.model.Model;
import seedu.address.model.order.Order;

/**
 * Clears the archived order book.
 */
public class ClearArchivedOrderCommand extends Command {

    public static final String COMMAND_WORD = "clear-a";
    public static final String MESSAGE_SUCCESS = "Archived order book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setArchivedOrderBook(new DataBook<Order>());
        return new CommandResult(MESSAGE_SUCCESS, UiChange.ARCHIVED_ORDER);
    }
}
