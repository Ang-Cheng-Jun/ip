import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        Task[] list = new Task[100];
        int num = 0;

        while(!command.equals("bye")) {
            if(command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i <= num; i++) {
                    System.out.println(i + "." + list[i - 1]);
                }
            } else if(command.contains("done")) {
                String[] word = command.split(" ");
                list[Integer.parseInt(word[1]) - 1].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(" " + list[Integer.parseInt(word[1]) - 1]);
            } else if(command.contains("todo")){
                String description = command.substring(5, command.length());
                list[num] = new Todo(description);
                System.out.println("Got it. I've added this task:");
                System.out.println(" " + list[num]);
                num++;
                System.out.println("Now you have " + num + " tasks in the list.");
            } else if(command.contains("deadline")) {
                String description = command.substring(9, command.indexOf(" /"));
                String by = command.substring(command.lastIndexOf("by ") + 3, command.length());
                list[num] = new Deadline(description, by);
                System.out.println("Got it. I've added this task:");
                System.out.println(" " + list[num]);
                num++;
                System.out.println("Now you have " + num + " tasks in the list.");
            } else if(command.contains("event")) {
                String description = command.substring(6, command.indexOf(" /"));
                String at = command.substring(command.indexOf("at") + 3, command.length());
                list[num] = new Event(description, at);
                System.out.println("Got it. I've added this task:");
                System.out.println(" " + list[num]);
                num++;
                System.out.println("Now you have " + num + " tasks in the list.");
            }
            System.out.println("\n");
            command = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
