package DSA;

public class myListTest {
    public static void main(String[] args) {
        myList<String> list = new myList<>();

        // Kiểm tra add(E e)
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Kiểm tra add(int index, E element)
        list.add(1, "JavaScript");

        System.out.println("Kích thước hiện tại: " + list.size());
        System.out.println("Phần tử tại vị trí 1: " + list.get(1));

        // Kiểm tra contains và indexOf
        System.out.println("Có chứa 'Java' không? " + list.contains("Java"));
        System.out.println("Vị trí của 'C++': " + list.indexOf("C++"));

        // Kiểm tra remove
        String removed = list.remove(2);
        System.out.println("Đã xóa: " + removed);
        System.out.println("Kích thước sau khi xóa: " + list.size());

        // Kiểm tra clear
        list.clear();
        System.out.println("Kích thước sau khi clear: " + list.size());
    }
    }

