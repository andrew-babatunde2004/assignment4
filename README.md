Compile:
    javac -d bin Sorting.java SortDriver.java ExperimentRunner.java

Run with a file (Experiment 1):
    java -cp bin SortDriver <filename>

Run with a random array (Experiment 2):
    java -cp bin SortDriver

Algorithm choices when prompted:
    s - Selection Sort
    m - Merge Sort
    h - Heap Sort
    q - Quick Sort (first pivot)
    r - Quick Sort (random pivot)
