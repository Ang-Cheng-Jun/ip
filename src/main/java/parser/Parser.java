package parser;


import commands.*;
import common.Messages;
import data.exception.DukeException;
import ui.TextUi;

public class Parser {

    private static final String SPACE = " ";

    public static Command parseCommand(String userInput) {
        String[] words = userInput.trim().split(SPACE, 2);
        final String commandWord = words[0];
        final String arguments = userInput.replaceFirst(commandWord, "").trim();

        switch (commandWord) {
        case ListCommand.COMMAND_WORD:
            return new ListCommand(); //Print the list of tasks
        case DoneCommand.COMMAND_WORD:
            return new DoneCommand(arguments); //Put a tick in the task
        case TodoCommand.COMMAND_WORD:
            return prepareTodoCommand(arguments); //Add task under the "td" category
        case DeadlineCommand.COMMAND_WORD:
            return prepareDeadlineCommand(arguments);
        case EventCommand.COMMAND_WORD:
            return prepareEventCommand(arguments);
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommand(arguments);
        case FindCommand.COMMAND_WORD:
            return new FindCommand(arguments);
        default:
            return new InvalidCommand("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-("); //Show error because invalid input
        }
    }

    private static Command prepareTodoCommand(String arguments) {
        try {
            if(arguments.equals("")){
                throw new StringIndexOutOfBoundsException();
            }
            return new TodoCommand(arguments);
        } catch (StringIndexOutOfBoundsException e) {
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        }
    }

    private static Command prepareDeadlineCommand (String arguments){
        try {
            String description = arguments.substring(0, arguments.indexOf(" /"));
            String by = arguments.substring(arguments.indexOf("/") + 3);
            if (by.trim().isEmpty()) {
                throw new DukeException();
            }
            return new DeadlineCommand(description, by);
        } catch (StringIndexOutOfBoundsException e) {
            TextUi.showToUser(Messages.MESSAGE_DESCRIPTION_EMPTY);
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            return new InvalidCommand("\u2639 The date/time of a deadline cannot be empty.");
        }
    }

    private static Command prepareEventCommand (String arguments){
        try {
            String description = arguments.substring(0, arguments.indexOf(" /"));
            String at = arguments.substring(arguments.indexOf("/") + 3);
            if (at.trim().isEmpty()) {
                throw new DukeException();
            }
            return new EventCommand(description, at);
        } catch (StringIndexOutOfBoundsException e) {
            TextUi.showToUser(Messages.MESSAGE_DESCRIPTION_EMPTY);
            return new InvalidCommand(Messages.MESSAGE_DESCRIPTION_EMPTY);
        } catch (DukeException e) {
            return new InvalidCommand("\u2639 The date/time of a event cannot be empty.");
        }
    }

}