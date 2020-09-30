package parser;

import commands.ByeCommand;
import commands.Command;
import commands.DeadlineCommand;
import commands.DeleteCommand;
import commands.DoneCommand;
import commands.EventCommand;
import commands.FindCommand;
import commands.InvalidCommand;
import commands.ListCommand;
import commands.TodoCommand;
import common.Messages;
import data.exception.DukeException;
import data.exception.InvalidParameterException;

/**
 * Parses user input.
 */
public class Parser {

    /**
     * Parses user input int command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     */
    public static Command parseCommand(String userInput) {
        String[] words = userInput.trim().split(Messages.SPACE, 2);
        final String commandWord = words[0];
        final String arguments = userInput.replaceFirst(commandWord, "").trim();

        switch (commandWord) {
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        case DoneCommand.COMMAND_WORD:
            return new DoneCommand(arguments);
        case TodoCommand.COMMAND_WORD:
            return prepareTodoCommand(arguments);
        case DeadlineCommand.COMMAND_WORD:
            return prepareDeadlineCommand(arguments);
        case EventCommand.COMMAND_WORD:
            return prepareEventCommand(arguments);
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommand(arguments);
        case FindCommand.COMMAND_WORD:
            return new FindCommand(arguments);
        case ByeCommand.COMMAND_WORD:
            return new ByeCommand();
        default:
            return new InvalidCommand(Messages.MESSAGE_INVALID_USER_COMMAND);
        }
    }

    /**
     * Parses arguments in the context of the TodoCommand.
     *
     * @param arguments full command args string
     * @return the prepared command
     */
    private static Command prepareTodoCommand(String arguments) {
        try {
            if (arguments.equals("")) {
                throw new StringIndexOutOfBoundsException();
            }
            return new TodoCommand(arguments);
        } catch (StringIndexOutOfBoundsException e) {
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        }
    }

    /**
     * Parses arguments in the context of the DeadlineCommand.
     *
     * @param arguments full command args string
     * @return the prepared command
     */
    private static Command prepareDeadlineCommand (String arguments){
        try {
            String description = arguments.substring(0, arguments.indexOf(" /"));
            String parameter = arguments.substring(arguments.indexOf("/"), arguments.indexOf("/") + 3);
            String by = arguments.substring(arguments.indexOf("/") + 3);
            if (!parameter.trim().equals("/by")) {
                throw new InvalidParameterException();
            }
            if (by.trim().isEmpty()) {
                throw new DukeException();
            }
            return new DeadlineCommand(description, by);
        } catch (StringIndexOutOfBoundsException e) {
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            return new InvalidCommand(Messages.MESSAGE_EMPTY_BY_DEADLINE);
        } catch (InvalidParameterException e) {
            return new InvalidCommand(Messages.MESSAGE_INVALID_PARAMETER_DEADLINE);
        }
    }

    /**
     * Parses arguments in the context of the EventCommand.
     *
     * @param arguments full command args string
     * @return the prepared command
     */
    private static Command prepareEventCommand (String arguments){
        try {
            String description = arguments.substring(0, arguments.indexOf(" /"));
            String parameter = arguments.substring(arguments.indexOf("/"), arguments.indexOf("/") + 3);
            String at = arguments.substring(arguments.indexOf("/") + 3);
            if (!parameter.trim().equals("/at")) {
                throw new InvalidParameterException();
            }
            if (at.trim().isEmpty()) {
                throw new DukeException();
            }
            return new EventCommand(description, at);
        } catch (StringIndexOutOfBoundsException e) {
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            return new InvalidCommand(Messages.MESSAGE_EMPTY_AT_EVENT);
        } catch (InvalidParameterException e) {
            return new InvalidCommand(Messages.MESSAGE_INVALID_PARAMETER_EVENT);
        }
    }

}