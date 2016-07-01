package com.xxstudy.test.algorithms;

import com.xxbase.test.BaseTest;
import org.junit.Test;

/**
 * Created by admin on 16/06/13.
 */
public class AlgorithmsTest extends BaseTest{



    @Test
    public void testBubbleSort(){
        int[] nums = {102, 10, 12, 8, 111, 39, 38, 50, 40, 10, 22, 17, 22, 18, 47, 45};

        for(int i = 0, len = nums.length; i < len; i++){

            for(int j = i; j < len; j++){

                if(nums[i] > nums[j]){

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;

                }

            }

        }

        for(int i = 0; i < nums.length; i++){
            System.out.printf("%s, ", nums[i]);
        }
        System.out.println();
    }


    @Test
    public void testInsertSort(){
        int[] nums= {102, 10, 12, 8, 111, 39, 38, 50, 40, 10, 22, 17, 22, 18, 47, 45};

        for(int i = 1, len = nums.length; i < len; i++){

            int temp = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > temp){
                // 后 -- 前
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;

        }

        for(int i = 0; i < nums.length; i++){
            System.out.printf("%s, ", nums[i]);
        }
        System.out.println();
    }


    /**
     * 求每行的最大值的最小值
     */
    @Test
    public void testFind(){

        Integer[][] numArr = {
                {4, 10, 8, 11, 16},
                {8, 3, 6, 7, 1},
                {9, 8, 2, 18, 5},
                {7, 12, 4, 8, 2},
        };

        int min = 0;

        for(int i = 0; i < 4; i++){

            int max = numArr[i][0];

            for(int j = 0; j < 5; j++){

                if(max < numArr[i][j]){
                    max = numArr[i][j];
                }

            }

            System.out.printf("max : %s\n", max);

            if(i == 0 || min > max){
                min = max;
            }

        }

        System.out.println("min : " + min);
    }

}
