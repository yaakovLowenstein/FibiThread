package fibithread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;

public class FibiThread extends Thread {

    static List<BigInteger> list;
    static BigInteger bI;

    @Override
    public void run() {
        synchronized ("lock") {
            for (int i = 2; i < 10000; i++) {
                bI = bI.add(list.get(i - 1));
                bI = bI.add(list.get(i - 2));
                list.add(bI);
                System.out.println(list.get(i));
                bI = new BigInteger("0");
            }
        }
    }

    public static void main(String[] args) {
        list = Collections.synchronizedList(new ArrayList<>());
        list.add(BigInteger.valueOf(1));
        list.add(BigInteger.valueOf(1));
        bI = new BigInteger("0");
        for (int i = 0; i < 10; i++) {
            new FibiThread().start();
        }
    }

}
