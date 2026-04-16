public class Sorting {

    private long count;

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
    }

    private void merge(int[] arr, int left, int mid, int right) {
    }

    public void heapSort(int[] arr) {
        count = 0;
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            count++;
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
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            count++;
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
    }

    private int partitionFP(int[] arr, int low, int high) {
        return low;
    }

    public void quickSortRP(int[] arr) {
        count = 0;
        quickSortRPHelper(arr, 0, arr.length - 1);
    }

    private void quickSortRPHelper(int[] arr, int low, int high) {
    }

    private int partitionRP(int[] arr, int low, int high) {
        return low;
    }
}
