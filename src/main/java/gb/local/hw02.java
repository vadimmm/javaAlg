package gb.local;
import java.util.ArrayList;
import java.util.Random;

public class hw02 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(random.nextInt(100));
        }
        System.out.println("Входящий список: \n    " + array + "\n");
        hw02 ob = new hw02();
        ob.heapifySort(array);
        System.out.println("\nОтсортированный список: \n    " + array);
    }
    public void heapifySort(ArrayList<Integer> array) {
        int n = array.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            heapify(array, i, 0);
            System.out.println(i + "i: " + array);
        }
    }
    void heapify(ArrayList<Integer> array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array.get(l) > array.get(largest))
            largest = l;
        if (r < n && array.get(r) > array.get(largest))
            largest = r;
        if (largest != i) {
            int swap = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, swap);
            heapify(array, n, largest);
        }
    }
}
