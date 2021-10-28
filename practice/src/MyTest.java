import common.Encrypt.DesEncryption;
import constants.Constants;
import dto.Phone;
import impl.InterfaceDefaultImpl;
import org.junit.Test;
import service.Apple;
import service.AppleConsume;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        try {
            new Thread(()->{
                try {
                    phone.sendEmail();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            },"A").start();
            TimeUnit.MILLISECONDS.sleep(40);
            new Thread(()->{
                phone.sendSMS();
            },"A").start();
        }catch (Exception exception) {

        }
    }

    @Test
    public void test1() {
        InterfaceDefaultImpl interfaceDefault = new InterfaceDefaultImpl();

        interfaceDefault.interfaceDefaultImplPrint();
        interfaceDefault.defaultPrint();
    }

    @Test
    public void test2() {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("green", 10));
        list.add(new Apple("red", 20));

        Comparator<Apple> t = (Apple a1, Apple a2) -> a2.weight - a1.weight;
        list.sort(Apple::compSort);

        AppleConsume appleConsume = new AppleConsume();

        Apple.prettyPrintApple(list, appleConsume::applePrint);
    }
    @Test
    public void enumTest() {
        Integer t = 1;
        Constants.Type type = Constants.Type.getType(t);

        switch (type) {
            case FORUM :
                System.out.println("hello");
                break;
            default:
                break;
        }

    }

    @Test
    public void testThread() {
        Phone phone = new Phone();
        try {
            new Thread(()->{
                try {
                    phone.sendEmail();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            },"A").start();
            TimeUnit.MILLISECONDS.sleep(40);
            new Thread(()->{
                phone.sendSMS();
            },"A").start();
        }catch (Exception exception) {

        }

    }

    @Test
    public void testStream() {
        List<Integer> lists = new LinkedList<>();

        lists.add(1);
        lists.add(2);
        lists.add(3);

        Map<Integer, Integer> map = lists.stream().collect(Collectors.toMap(integer -> integer, integer -> integer * integer));


    }

    @Test
    public void testEncrypt() {
        String srcString = "DES解密字符串";

        String encryptKey = DesEncryption.DESGetKey();

        String encryptString = DesEncryption.DESEncrypt(srcString, encryptKey);

        String plain = DesEncryption.DESDecipher(encryptString, encryptKey);

        System.out.println(encryptString);
    }
}
