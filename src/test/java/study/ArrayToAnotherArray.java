package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2017/5/24.
 */
public class ArrayToAnotherArray {
    public static void main(String[] args) {
        int []a = {3, 1, 2, 3};
        int []b = {7, 5, 9, 10};
        //check & preCalculate
        if (a.length != b.length){
            System.out.println("array lenth is not equal!");
            return;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [][]c = new int [3][30];
        //
        for (int i=0; i<a.length; i++){
            if (a[i] > b[i]){
                System.out.println("error");
                return;
            }else {
                c[0][i] = ArrayToAnotherArray.get(a[i], b[i])[0];
                c[1][i] = ArrayToAnotherArray.get(a[i], b[i])[1];
                c[2][i] = ArrayToAnotherArray.get(a[i], b[i])[2];
                System.out.println(c[0][i] + " " + c[1][i] + " " + c[2][i]);
            }
        }
        System.out.println("----");
    }

    public static int[] get(int srcNum, int destNum){
        int countAdd = 0;
        int countMulti = 0;
        int countOther = 0;
        if (destNum % 2 != 0){
            destNum = destNum - 1;
            countOther = 1;
        }
        while (Boolean.TRUE){
            if (destNum/2 >= srcNum){
                countMulti++;
                destNum = destNum / 2 ;
            }else {
                countAdd = destNum % srcNum;
                break;
            }
        }
        int[] result = new int[3];
        result[0] = countAdd;
        result[1] = countMulti;
        result[2] = countOther;
        return result;
    }
}
