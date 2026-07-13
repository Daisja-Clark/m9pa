//ConceptDemo.java
// Daisja Clark
// 7-12-2026
// Demonstration of the Adapter pattern and ue of generics.

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConceptDemo {

    public static void main(String[] args) {

        //original Integer Array
        Integer[] numberArray = {5,2,9,1,4,7};

        //Adapter Object
        ArrayAdapter adapter = new ArrayAdapter(numberArray);

        //Convert to a list
        List<Integer> numbers = adapter.toList();

        //Print list
        System.out.println("Before sorting: " + numbers);

        //Sort the list
        Collections.sort(numbers);
        System.out.println("After sorting: " + numbers);

        //Remove value 4
        numbers.remove(Integer.valueOf(4));
        System.out.println("After removing 4: " + numbers);

        //Print list
        printList(numbers);
    }
    public static void printList(List<?> list) {
        System.out.println(
                "Printing list using unbounded wildcard: " + list);
    }
}

//Object Adapter Class
class ArrayAdapter {

    private Integer[] array;

    public ArrayAdapter (Integer[] array) {
        this.array = array;
    }
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}
