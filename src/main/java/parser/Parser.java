package parser;


import commands.*;
import data.duke.Task;
import storage.Storage;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private static final String SPACE =" ";

    public static void runCommandLoopUntilByeCommand(ArrayList<Task> list, int num) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine().trim();

        while (!command.equals(ByeCommand.COMMAND_WORD)) {
            String commandWord = extractAction(command); //Find out what action to be taken
            switch (commandWord) {
            case ListCommand.COMMAND_WORD:
                ListCommand.printList(list,num); //Print the list of tasks
                break;
            case DoneCommand.COMMAND_WORD:
                DoneCommand.markAsDone(list,command, num); //Put a tick in the task
                break;
            case TodoCommand.COMMAND_WORD:
                num = TodoCommand.storeTodo(list,command, num); //Add task under the "td" category
                break;
            case DeadlineCommand.COMMAND_WORD:
                num = DeadlineCommand.storeDeadline(list,command, num); //Add task under the "deadline" category
                break;
            case EventCommand.COMMAND_WORD:
                num = EventCommand.storeEvent(list,command, num); //Add task under the "event" category
                break;
            case DeleteCommand.COMMAND_WORD:
                num = DeleteCommand.deleteTask(list,command, num);
                break;
            default :
                System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-("); //Show error because invalid input
                break;
            }
            Storage.writeToFile(list);
            System.out.println("\n");
            command = sc.nextLine(); //Get the next command
        }
    }

    //Find out what action to be taken
    private static String extractAction(String command) {
        command = command.trim();
        String [] keyword = command.split(SPACE);
        return keyword[0];
    }

}
