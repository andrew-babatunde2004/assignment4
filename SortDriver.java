import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class SortDriver {

    static void main(String[] args) {

        Sorting sorter = new Sorting();

        if (args.length == 0) {
            runExperiment2(sorter);
        } else {
            runExperiment1(sorter, args[0]);
        }
    }

    private static void runExperiment1(Sorting sorter, String fileName) {

        int[] arr;
        try {
            arr = readFile(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        printMenu();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        String choice = input.nextLine().trim();

        switch (choice) {
            case "s":
                sorter.selectionSort(arr);
                printArray(arr);
                System.out.println("Selection-sort comparisons: " + sorter.getCount());
                break;

            case "m":
                sorter.mergeSort(arr);
                printArray(arr);
                System.out.println("Merge-sort comparisons: " + sorter.getCount());
                break;

            case "h":
                sorter.heapSort(arr);
                printArray(arr);
                System.out.println("Heap-sort comparisons: " + sorter.getCount());
                break;

            case "q":
                sorter.quickSortFP(arr);
                printArray(arr);
                System.out.println("Quick-sort-fp comparisons: " + sorter.getCount());
                break;

            case "r":
                sorter.quickSortRP(arr);
                printArray(arr);
                System.out.println("Quick-sort-rp comparisons: " + sorter.getCount());
                break;

            default:
                System.out.println("Invalid algorithm choice.");
                break;
        }

        input.close();
    }

    private static void runExperiment2(Sorting sorter) {

        Scanner input = new Scanner(System.in);

        printMenu();

        System.out.print("Enter the algorithm: ");
        String choice = input.nextLine().trim();

        System.out.print("Enter the size of the input array: ");
        int n;
        try {
            n = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid size.");
            input.close();
            return;
        }

        int[] arr = generateRandomArray(n);
        printArray(arr);

        switch (choice) {
            case "s":
                sorter.selectionSort(arr);
                System.out.println("#Selection-sort comparisons: " + sorter.getCount());
                break;

            case "m":
                sorter.mergeSort(arr);
                System.out.println("#Merge-sort comparisons: " + sorter.getCount());
                break;

            case "h":
                sorter.heapSort(arr);
                System.out.println("#Heap-sort comparisons: " + sorter.getCount());
                break;

            case "q":
                sorter.quickSortFP(arr);
                System.out.println("#Quick-sort-fp comparisons: " + sorter.getCount());
                break;

            case "r":
                sorter.quickSortRP(arr);
                System.out.println("#Quick-sort-rp comparisons: " + sorter.getCount());
                break;

            default:
                System.out.println("Invalid algorithm choice.");
                break;
        }

        input.close();
    }

    private static int[] readFile(String fileName) throws FileNotFoundException {
        Scanner counter = new Scanner(new File(fileName));
        int size = 0;
        while (counter.hasNextInt()) {
            counter.nextInt();
            size++;
        }
        counter.close();

        int[] arr = new int[size];
        Scanner reader = new Scanner(new File(fileName));
        for (int i = 0; i < size; i++) {
            arr[i] = reader.nextInt();
        }
        reader.close();

        return arr;
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }

    private static void printMenu() {
        System.out.println("selection-sort (s)   merge-sort (m)   heap-sort (h)   quick-sort-fp (q) quick-sort-rp (r)");
    }
}
