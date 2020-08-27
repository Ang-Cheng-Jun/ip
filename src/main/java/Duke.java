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
                    list[i - 1].displayList(i);
                }
            }
            else if(command.contains("done")) {
                String[] word = command.split(" ");
                list[Integer.parseInt(word[1]) - 1].markAsDone();
            }
            else {
                list[num] = new Task(command);
                System.out.println("added: " + command);
                num++;
            }
            System.out.println("\n");
            command = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
