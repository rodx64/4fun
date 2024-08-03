package domain.my_implementation;

import java.util.ArrayList;
import java.util.List;

public class _ArrayList {

    public static void main(String[] args) {
        bigOInOperations();
    }

    static List<Integer> arrList = new ArrayList(); // Dynamic Array

    public static void bigOInOperations() {
        arrList.add(0); // O(1)
        arrList.add(1); // O(1)
        arrList.add(2); // O(1)
        arrList.add(3); // O(1)
        arrList.add(4); // O(1)
        System.out.println(arrList);

        // Removing the last one from the list, as it is not necessary to reposition indexes.
        arrList.remove(4); // O(1)
        System.out.println(arrList);


        // Removing the first one from a list, you must reposition the indexes of the others.
        // Touching each one of them, therefore we have O(n)
        arrList.remove(0); // O(n)
        System.out.println(arrList);

        // Adding the first one to a list, you must reposition the indexes of the others.
        // Touching each of them, we also have O(n)
        arrList.add(0, 11);
        System.out.println(arrList);

        // Contains must touch all items to find the one
        System.out.println(arrList.contains(11)); // O(n)
        System.out.println(arrList);
    }


}
