import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;
        String cmd;

        System.out.println("Welcome to ListMaker!");
        do {
            displayList(list);
            System.out.println("\n[A]dd  [D]elete  [P]rint  [Q]uit");

            cmd = SafeInput.getNonZeroLenString(in, "Enter command").toUpperCase();

            switch (cmd) {
                case "A":
                    String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
                    list.add(item);
                    break;

                case "D":
                    if (list.size() == 0) {
                        System.out.println("List is empty. Nothing to delete.");
                    } else {
                        int delIndex = SafeInput.getInt(in, "Enter index to delete (1 - " + list.size() + ")");
                        if (delIndex >= 1 && delIndex <= list.size()) {
                            list.remove(delIndex - 1);
                            System.out.println("Item deleted.");
                        } else {
                            System.out.println("Invalid index.");
                        }
                    }
                    break;

                case "P":
                    displayList(list);
                    break;

                case "Q":
                    done = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command. Try again.");
            }
        } while (!done);
    }

    private static void displayList(ArrayList<String> list) {
        System.out.println("\nCurrent list:");
        if (list.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, list.get(i));
            }
        }
    }
}
