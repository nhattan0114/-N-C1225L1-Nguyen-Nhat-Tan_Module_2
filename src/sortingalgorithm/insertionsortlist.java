package sortingalgorithm;

import java.util.Arrays;

public class insertionsortlist {
    public static void main(String[] args) {
        int[] arr = {8,2,3,7,5,6,4,15,1,10};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] list) {
        // Duyệt từ phần tử thứ 2 (index 1) đến hết mảng
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int j = i - 1;

            // Dịch chuyển các phần tử phía trước lớn hơn currentElement sang phải 1 vị trí
            while (j >= 0 && list[j] > currentElement) {
                list[j + 1] = list[j];
                j--;
            }

            // Chèn currentElement vào khoảng trống đã tạo ra
            list[j + 1] = currentElement;
        }
    }
}
