import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class Dao {

    private List<Integer> myList= Arrays.asList(10,15,8,29,25,98,98,22,15);

    public int sumOfNumbers(){
        int sum = myList.stream()
                .mapToInt(i -> i)
                .sum();
        return sum;
    }

    public int sumOfEvenNumbers(){
        int sum = myList.stream()
                .mapToInt(i -> i)
                .filter(i -> i%2==0)
                .sum();
        return sum;
    }

    public List<Integer> removeDuplicates(){
        List<Integer> list = myList.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return list;
    }

    public Map<Integer,Integer> findDuplicates(){
        Map<Integer,Integer> map = myList.stream()
                .filter(n -> Collections.frequency(myList,n)>1)
                .collect(Collectors.toMap(Function.identity(), number -> 1, Math::addExact));
        return map;
    }

}
