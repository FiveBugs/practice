package service;

import inter.PrintApple;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Apple {
    public String color;
    public int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public String printApple() {
        String result = "color:" + color + ",weight:" + weight;
        //System.out.println(result);
        return result;
    }

    public static boolean isRed(Apple apple) {
        if (apple.color.equals("red")) {
            return true;
        }
        return false;
    }

    public static<T> String prettyPrintApple(List<T> appleList, PrintApple<T> printApple) {
        for (T apple : appleList) {
            String output = printApple.testApple(apple);
            System.out.println(output);
        }
        return "";
    }

    public int compSort(Apple t1) {
        return t1.weight - this.weight;
    }
}