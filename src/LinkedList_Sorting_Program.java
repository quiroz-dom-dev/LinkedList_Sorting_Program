import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Main Class. This class serves as an entry point to the methods implemented. 
 */
Public class Main {

    /**
     * Contructor. Creates an empty linked list. 
     * Asks user to input the integers that need to be sorted. 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> sortedList = new LinkedList<>(); 

        System.out.print("Enter the numbers you wish to add (separated by spaces), then press enter: ");
        String inputLine = scanner.nextLine(); 

        /**
         * While loop intended to collect the numbers entered for sorting until the user submits 'done'.
         * Uses a space to separate the numbers entered. 
         * Converts the string collected into integers. 
         * Includes error handling to only accept inputs that are in integer format. 
         */
        while (!inputLine.equalsIgnoreCase("done")) { 
            String[] numbers = inputLine.split("\\s+"); 

            for (String numStr : numbers) {
                try {
                    int number = Integer.parseInt(numStr); 
                    insertSorted(sortedList, number); 
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + numStr + ". Please enter integers only.");
                }
            }

            System.out.print("Add more numbers (separated by spaces), or enter 'done' to sort your list: ");
            inputLine = scanner.nextLine();
        }
        /**
         * Outputs the sorted list. 
         */
        System.out.println("Sorted Linked List (Smallest to Largest): " + sortedList);
        scanner.close();
    }

    /**
     * Method to sort integers in order.
     * @param list for the linked list to insert into.
     * @param num for the number to insert.
     * Uses binary search to find the index to insert the number into the correct position within the list.
     */
    private static void insertSorted(LinkedList<Integer> list, int num) {
        int index = Collections.binarySearch(list, num); 
        if (index < 0) { 
            index = -(index + 1); 
        }
        list.add(index, num); 
    }
}
