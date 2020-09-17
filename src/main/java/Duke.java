//A0202021L

import duke.*;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    //Main Program
    public static void main(String[] args) {
        String file1 = "data/duke.txt";
        ArrayList<Task> list = new ArrayList<Task>();
        int num = 0;

        num = importFileContents(file1, list);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while (!command.equals("bye")) {
            String actionType = extractAction(command); //Find out what action to be taken
            switch (actionType) {
            case "list":
                printList(list, num); //Print the list of tasks
                break;
            case "done":
                markAsDone(list, command, num); //Put a tick in the task
                break;
            case "todo":
                num = storeTodo(list, command, num); //Add task under the "td" category
                break;
            case "deadline":
                num = storeDeadline(list, command, num); //Add task under the "deadline" category
                break;
            case "event":
                num = storeEvent(list, command, num); //Add task under the "event" category
                break;
            case "delete":
                num = deleteTask(list, command, num);
                break;
            default :
                System.out.println("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-("); //Show error because invalid input
                break;
            }
            writeToFile(file1, list);
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
    private static void printList(ArrayList<Task> list, int num) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= num; i++) {
            System.out.println(i + "." + list.get(i - 1));
        }
    }

    //Put a tick in the task
    private static void markAsDone(ArrayList<Task> list, String command, int num) {
        try {
            String[] word = command.split(" ");
            int index = Integer.parseInt(word[1]) - 1;
            if (index >= num) {
                throw new ArrayIndexOutOfBoundsException();
            }
            list.get(index).putTick();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(" " + list.get(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
    }

    //Add task under the "td" category
    private static int storeTodo(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(5);
            list.add(new Todo(description));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\u2639 The description of a todo cannot be empty.");
        }

        return num;
    }

    //Add task under the "deadline" category
    private static int storeDeadline(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(9, command.indexOf(" /"));
            String by = command.substring(command.indexOf("/") + 3);
            if (by.trim().isEmpty()) {
                throw new DukeException();
            }
            list.add(new Deadline(description, by));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
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
    private static int storeEvent(ArrayList<Task> list, String command, int num) {
        try {
            String description = command.substring(6, command.indexOf(" /"));
            String at = command.substring(command.indexOf("/") + 3);
            if(at.trim().isEmpty()) {
                throw new DukeException();
            }
            list.add(new Event(description, at));
            System.out.println("Got it. I've added this task:");
            System.out.println(" " + list.get(num));
            num++;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\u2639 The description of a event cannot be empty.");
        } catch (DukeException e) {
            System.out.println("\u2639 The date/time of a event cannot be empty.");
        }
        return num;
    }


    //Delete the task
    private static int deleteTask(ArrayList<Task> list, String command, int num) {
        try {
            String[] word = command.split(" ");
            int index = Integer.parseInt(word[1]) - 1;
            if (index >= num) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.out.println("Noted. I've removed this task: ");
            System.out.println(" " + list.get(index));
            list.remove(index);
            num--;
            System.out.println("Now you have " + num + " tasks in the list.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 The number is not in the list");
        }
        return num;
    }

    private static void writeToFile(String filePath, ArrayList<Task> list) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (Task t : list) {
                switch (t.getCategory()) {
                case "T":
                    fw.write(t.getCategory() + "|" + t.getIsDone() + "|" + t.getDescription() + System.lineSeparator());
                    break;
                case "D":
                    fw.write(t.getCategory() + "|" + t.getIsDone() + "|" + t.getDescription() + "|" + t.getBy()+ System.lineSeparator());
                    break;
                case "E":
                    fw.write(t.getCategory() + "|" + t.getIsDone() + "|" + t.getDescription() + "|" + t.getAt()+ System.lineSeparator());
                    break;
                default:
                    break;
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private static int importFileContents(String filePath, ArrayList<Task> list) {
        int num = 0;
        try {
            File d = new File("data");
            if (d.mkdir()) {
                System.out.println("Directory created successfully");
            }
            File f = new File(filePath); // create a File for the given file path
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            if (f.createNewFile()) {
                throw new IOException();
            }
            while (s.hasNext()) {
                String[] words = s.nextLine().split("\\|");
                switch (words[0]) {
                case "T":
                    list.add(new Todo(words[2]));
                    break;
                case "D":
                    list.add(new Deadline(words[2], words[3]));
                    break;
                case "E":
                    list.add(new Event(words[2], words[3]));
                    break;
                default:
                    break;
                }
                if (words[1].equals("1")) {
                    list.get(num).putTick();
                }
                num++;
            }
        } catch (IOException e) {
            System.out.println("File not found. Created a new file \n");
        }
        return num;
    }
}
