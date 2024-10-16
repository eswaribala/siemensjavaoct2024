import com.siemens.webstore.facades.GenerateOTP;
import com.siemens.webstore.models.Category;
import com.siemens.webstore.models.Product;
import com.siemens.webstore.services.CategoryService;
import com.siemens.webstore.services.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

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

        //Function
        Function<ArrayList<Category>,ArrayList<String>> function=(categories)->{

            ArrayList<String> names=new ArrayList<>();
            for(Category category: categories)
            {
                if(category.getCategoryName().startsWith("L"))
                    names.add(category.getCategoryName());
            }
            return names;
        };
         //Function invocation
      for(String name1  :   function.apply(CategoryService.generateCategories())){
          System.out.println(name1);
        }



    }
}
