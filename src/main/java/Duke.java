import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String exit = new String("bye");

        while(exit.equals(command) == false) {
            System.out.println(command + "\n");
            command = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
