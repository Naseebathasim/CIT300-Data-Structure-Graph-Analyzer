import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayOperations array = new ArrayOperations(20);
    static Stack stack = new Stack(10);
    static Queue queue = new Queue(10);
    static LinkedList linkedList = new LinkedList();
    static Graph graph = new Graph();

    public static void main(String[] args) {

        int choice;

        do {

            displayMainMenu();

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    arrayMenu();
                    break;

                case 2:
                    stackMenu();
                    break;

                case 3:
                    queueMenu();
                    break;

                case 4:
                    linkedListMenu();
                    break;

                case 5:
                    searchingMenu();
                    break;

                case 6:
                    graphMenu();
                    break;

                case 7:
                    performanceMenu();
                    break;

                case 8:
                    displayAllResults();
                    break;

                case 9:
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }

    // ================= MAIN MENU =================

    public static void displayMainMenu() {

        System.out.println("\n=============================================");
        System.out.println("     DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
        System.out.println("=============================================");
    }

    // ================= ARRAY =================

    public static void arrayMenu() {

        int choice;

        do {

            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int insertValue = getIntInput("Enter value to insert: ");
                    array.insert(insertValue);
                    break;

                case 2:
                    int deleteValue = getIntInput("Enter value to delete: ");
                    array.delete(deleteValue);
                    break;

                case 3:
                    int searchValue = getIntInput("Enter value to search: ");

                    int result = array.search(searchValue);

                    if (result == -1) {
                        System.out.println("Value not found.");
                    } else {
                        System.out.println("Value found at index: " + result);
                    }

                    break;

                case 4:
                    array.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // ================= STACK =================

    public static void stackMenu() {

        int choice;

        do {

            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int value = getIntInput("Enter value to push: ");
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // ================= QUEUE =================

    public static void queueMenu() {

        int choice;

        do {

            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int value = getIntInput("Enter value to enqueue: ");
                    queue.enqueue(value);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.peek();
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // ================= LINKED LIST =================

    public static void linkedListMenu() {

        int choice;

        do {

            System.out.println("\n------------- LINKED LIST OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int value = getIntInput("Enter value to insert: ");
                    linkedList.insert(value);
                    break;

                case 2:
                    int deleteValue = getIntInput("Enter value to delete: ");
                    linkedList.delete(deleteValue);
                    break;

                case 3:
                    int searchValue = getIntInput("Enter value to search: ");
                    linkedList.search(searchValue);
                    break;

                case 4:
                    linkedList.display();
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }

    // ================= SEARCHING =================

    public static void searchingMenu() {

        if (array.getSize() == 0) {
            System.out.println("\nArray is empty.");
            System.out.println("Please insert values into the Array first.");
            return;
        }

        int choice;

        do {

            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Display Sorted Array");
            System.out.println("4. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int linearTarget =
                            getIntInput("Enter value to search: ");

                    Searching.linearSearch(
                            array.getArray(),
                            linearTarget
                    );

                    break;

                case 2:
                    int binaryTarget =
                            getIntInput("Enter value to search: ");

                    Searching.binarySearch(
                            array.getArray(),
                            binaryTarget
                    );

                    break;

                case 3:
                    Searching.displaySortedArray(
                            array.getArray()
                    );

                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    // ================= GRAPH =================

    public static void graphMenu() {

        int choice;

        do {

            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    int vertex =
                            getIntInput("Enter vertex: ");

                    graph.addVertex(vertex);
                    break;

                case 2:
                    int vertex1 =
                            getIntInput("Enter first vertex: ");

                    int vertex2 =
                            getIntInput("Enter second vertex: ");

                    graph.addEdge(vertex1, vertex2);
                    break;

                case 3:
                    graph.displayGraph();
                    break;

                case 4:
                    int bfsStart =
                            getIntInput("Enter starting vertex: ");

                    graph.bfs(bfsStart);
                    break;

                case 5:
                    int dfsStart =
                            getIntInput("Enter starting vertex: ");

                    graph.dfs(dfsStart);
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // ================= PERFORMANCE =================

    public static void performanceMenu() {

        if (array.getSize() == 0) {

            System.out.println("\nArray is empty.");
            System.out.println(
                    "Please insert values before performance testing."
            );

            return;
        }

        int target =
                getIntInput("Enter value to search for performance test: ");

        PerformanceAnalyzer.compareSearching(
                array.getArray(),
                target
        );

        System.out.println("\nGraph Performance Test");

        int startVertex =
                getIntInput("Enter starting graph vertex: ");

        PerformanceAnalyzer.compareGraphTraversal(
                graph,
                startVertex
        );
    }

    // ================= DISPLAY ALL =================

    public static void displayAllResults() {

        System.out.println("\n=============================================");
        System.out.println("             ALL CURRENT RESULTS");
        System.out.println("=============================================");

        System.out.println("\nArray:");
        array.display();

        System.out.println("\nStack:");
        stack.display();

        System.out.println("\nQueue:");
        queue.display();

        System.out.println("\nLinked List:");
        linkedList.display();

        System.out.println("\nGraph:");
        graph.displayGraph();

        System.out.println("=============================================");
    }

    // ================= INPUT VALIDATION =================

    public static int getIntInput(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                return scanner.nextInt();

            } else {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.next();
            }
        }
    }
}