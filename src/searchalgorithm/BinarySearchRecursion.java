package searchalgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr=inpuArray();
        Arrays.sort(arr);
        System.out.println("Mảng đã được sắp xếp: "+Arrays.toString(arr));
        System.out.print("Nhập giá trị muốn tìm: ");
        int target=Integer.parseInt(sc.nextLine());
        int index=binarySearch(arr,0,arr.length-1,target);
        if(index == -1){
            System.out.println("Không tìm thấy "+target);
        }else{
            System.out.println("Tìm thấy phần tử "+target+" tại ví trí "+index);
        }

    }
    public static int[] inpuArray(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử trong mảng: ");
        int n=Integer.parseInt(sc.nextLine());
        int[] arr= new int[n];
        for (int i = 0; i <arr.length ; i++) {
            System.out.println("Nhập phần tử ["+(i+1)+"]: ");
            arr[i]=Integer.parseInt(sc.nextLine());
        }
        return arr;
    }
    public static int binarySearch(int[] array, int left, int right, int value){
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (array[mid] == value) return mid;
        if (value > array[mid]) return binarySearch(array, mid + 1, right, value);
        if (value < array[mid]) return binarySearch(array, left, mid - 1, value);
        return 0;
    }
}
