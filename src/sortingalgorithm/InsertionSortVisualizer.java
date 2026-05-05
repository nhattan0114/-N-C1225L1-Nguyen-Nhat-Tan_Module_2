package sortingalgorithm;

import java.util.Arrays;

public class InsertionSortVisualizer {
    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6};

        insertionSortWithSteps(numbers);
    }

    public static void insertionSortWithSteps(int[] arr) {
        int n = arr.length;
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("--------------------------------------------------");

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Bước " + i + ": Đang xét phần tử '" + key + "' tại vị trí index " + i);

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;

            System.out.println("Trạng thái mảng: " + Arrays.toString(arr));
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Mảng sau khi sắp xếp hoàn tất: " + Arrays.toString(arr));
    }
    }

