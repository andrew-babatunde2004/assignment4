import java.util.Random;

public class Sorting {

    private long count;
    private static final Random rand = new Random();

    public long getCount() {
        return count;
    }

    public void selectionSort(int[] arr) {
        count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                count++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public void mergeSort(int[] arr) {
        count = 0;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            count++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public void heapSort(int[] arr) {
        count = 0;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n) {
            count++;
            if (arr[left] > arr[largest]) largest = left;
        }
        if (right < n) {
            count++;
            if (arr[right] > arr[largest]) largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public void quickSortFP(int[] arr) {
        count = 0;
        quickSortFPHelper(arr, 0, arr.length - 1);
    }

    private void quickSortFPHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionFP(arr, low, high);
            quickSortFPHelper(arr, low, pi - 1);
            quickSortFPHelper(arr, pi + 1, high);
        }
    }

    private int partitionFP(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            count++;
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;
        return i;
    }

    public void quickSortRP(int[] arr) {
        count = 0;
        quickSortRPHelper(arr, 0, arr.length - 1);
    }

    private void quickSortRPHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionRP(arr, low, high);
            quickSortRPHelper(arr, low, pi - 1);
            quickSortRPHelper(arr, pi + 1, high);
        }
    }

    private int partitionRP(int[] arr, int low, int high) {
        int randIdx = low + rand.nextInt(high - low + 1);
        int temp = arr[randIdx];
        arr[randIdx] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            count++;
            if (arr[j] <= pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[low];
        arr[low] = arr[i];
        arr[i] = temp;
        return i;
    }
}
