//A0202021L

import java.util.Scanner;

public class Duke {
    //Main Program
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        Task[] list = new Task[100];
        int num = 0;

        while(!command.equals("bye")) {
            String actionType = extractAction(command); //Find out what action to be taken
            switch (actionType) {
            case "list": printList(list, num); //Print the list of tasks
                break;
            case "done": markAsDone(list, command, num); //Put a tick in the task
                break;
            case "todo": num = storeTodo(list, command, num); //Add task under the "td" category
                break;
            case "deadline": num = storeDeadline(list, command, num); //Add task under the "deadline" category
                break;
            case "event": num = storeEvent(list, command, num); //Add task under the "event" category
                break;
            default : System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-("); //Show error because invalid input
                break;
            }
            System.out.println("\n");
            command = sc.nextLine(); //Get the next command
        }

        System.out.println("Bye. Hope to see you again soon!");
    }

    //Find out what action to be taken
    private static String extractAction(String command) {
        command = command.trim();
        String [] keyword = command.split(" ");
        return keyword[0];
    }

    //Print the list of tasks
    private static void printList(Task[] list, int num) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= num; i++) {
            System.out.println(i + "." + list[i - 1]);
        }
    }

    //Put a tick in the task
    private static void markAsDone(Task[] list, String command, int num) {
        try {
            String[] word = command.split(" ");
            if((Integer.parseInt(word[1]) - 1) >= num) {
                throw new ArrayIndexOutOfBoundsException();
            }
            list[Integer.parseInt(word[1]) - 1].putTick();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + list[Integer.parseInt(word[1]) - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
    }

    //Add task under the "td" category
    private static int storeTodo(Task[] list, String command, int num) {
        try {
            String description = command.substring(5);
            list[num] = new Todo(description);
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list[num]);
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\u2639 The description of a todo cannot be empty.");
        }

        return num;
    }

    //Add task under the "deadline" category
    private static int storeDeadline(Task[] list, String command, int num) {
        try {
            String description = command.substring(9, command.indexOf(" /"));
            String by = command.substring(command.indexOf("/") + 3);
            if(by.trim().isEmpty()) {
                throw new DukeException();
            }
            list[num] = new Deadline(description, by);
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list[num]);
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\u2639 The description of a deadline cannot be empty.");
        } catch (DukeException e) {
            System.out.println("\u2639 The date/time of a deadline cannot be empty.");
        }
        return num;
    }

    //Add task under the "event" category
    private static int storeEvent(Task[] list, String command, int num) {
        try {
            String description = command.substring(6, command.indexOf(" /"));
            String at = command.substring(command.indexOf("/") + 3);
            if(at.trim().isEmpty()) {
                throw new DukeException();
            }
            list[num] = new Event(description, at);
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list[num]);
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\u2639 The description of a event cannot be empty.");
        } catch (DukeException e) {
            System.out.println("\u2639 The date/time of a event cannot be empty.");
        }
        return num;
    }
}
