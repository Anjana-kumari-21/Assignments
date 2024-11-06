package week3.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class GoogleSet {

    public static void main(String[] args) {
        String var = "google";
        char[] arr = var.toCharArray();
        
        Set<Character> unique = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {  
            unique.add(arr[i]);
        }
        
        System.out.println("Unique Elements of Google are:- " + unique);
    }
}
