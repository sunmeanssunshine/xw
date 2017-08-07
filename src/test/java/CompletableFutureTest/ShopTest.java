package CompletableFutureTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by xuwei on 2017/7/31.
 */
public class ShopTest {
    List<Shop> shops = Arrays.asList(
            new Shop("BestPrice1"),
            new Shop("LetsSaveBig1"),
            new Shop("MyFavoriteShop1"),
            new Shop("BuyItAll1"),
            new Shop("LetsSaveBig2"),
            new Shop("MyFavoriteShop2"));
    @Test
    public void test(){

        long start = System.nanoTime();
        System.out.println(Shop.findPrices(shops,"myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Stream Done in " + duration + " msecs");
    }

    @Test
    public void test2(){
        long start = System.nanoTime();
        System.out.println(Shop.findPricesParallel(shops,"myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Parallel Done in " + duration + " msecs");
    }

    @Test
    public void test3(){
        long start = System.nanoTime();
        System.out.println(Shop.findPricesAsync(shops,"myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Async Done in " + duration + " msecs");
    }

}
