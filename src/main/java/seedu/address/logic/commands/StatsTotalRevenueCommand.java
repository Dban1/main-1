package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class StatsTotalRevenueCommand extends Command {
    public static final String COMMAND_WORD = "generate-totalRevenue";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Generated Total Revenue!.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_STATS_MESSAGE = "Opened Statistics window.";

    @Override
    public CommandResult execute(Model model) throws CommandException {

        return new CommandResult(SHOWING_STATS_MESSAGE, UiChange.STATS_TOTAL_REVENUE);
    }
}
