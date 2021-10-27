import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Practie {
    public static void main(String[] args) {

    }

    private List<Apple> getResult (List<Apple> in, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : in) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

