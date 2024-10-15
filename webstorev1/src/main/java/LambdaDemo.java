import com.siemens.webstore.facades.GenerateOTP;

import java.util.Random;

public class LambdaDemo {

    public static void main(String... args){
        String name="Parameswari";
        Runnable runnable=()->{
            for(char ch : name.toCharArray())
            {
                System.out.println(ch);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();

        GenerateOTP generateOTP=(min,max)->{
            return new Random().nextInt(min,max);
        };
        System.out.println(generateOTP.getOTP(1000,9999));


    }
}
