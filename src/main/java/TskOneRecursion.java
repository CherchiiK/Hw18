public class TskOneRecursion {

    int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    void printArray(int i) {
        if (i == 0) {
            return;
        } else {
            printArray(i - 1);
        }

        System.out.println(values[i - 1]);
    }
}