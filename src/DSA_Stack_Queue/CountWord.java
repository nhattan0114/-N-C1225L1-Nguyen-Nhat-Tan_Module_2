package DSA_Stack_Queue;

import java.util.Map;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        Map<String,Integer> worldMap = new TreeMap<>();
        String input="My journey bring sunshine and smile to start my journey";

        String[] words=input.split("\\s+");

        for (String w:words){
            String word =w.toLowerCase();
            if(!word.isEmpty()){
                if (worldMap.containsKey(word)){
                    worldMap.put(word,worldMap.get(word)+1);
                }
                else{
                    worldMap.put(word,1);
                }
            }
        }

        System.out.println("Ket qua: ");
        for (Map.Entry<String,Integer> entry:worldMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
