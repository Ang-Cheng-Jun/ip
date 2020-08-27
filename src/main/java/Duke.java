import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] list = new String[100];
        String exit = new String("bye");
        String display = new String("list");
        int num = 0;

        while(exit.equals(command) == false) {
            if(display.equals(command) == true) {
                for (int i = 1; i <= num; i++) {
                    System.out.println(i + "." + list[i - 1]);
                }
            }
            else {
                list[num] = command;
                System.out.println("added: " + command);
                num++;
            }
            System.out.println("\n");
            command = sc.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!");
    }
}
