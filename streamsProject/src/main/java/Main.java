import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Dao dao = new Dao();
        int sumOfNumbers = dao.sumOfNumbers();
        int sumOfEvenNumbers = dao.sumOfEvenNumbers();
        List<Integer> list = dao.removeDuplicates();
        Map<Integer,Integer> map = dao.findDuplicates();

        System.out.println("sum of all numbers : " + sumOfNumbers);
        System.out.println("sum of even numbers : " + sumOfEvenNumbers);
        System.out.println("list without duplicates : " + list);
        System.out.println("map with duplicates : " + map);

    }
}
