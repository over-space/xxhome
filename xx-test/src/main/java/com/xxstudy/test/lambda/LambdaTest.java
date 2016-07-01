package com.xxstudy.test.lambda;

import com.xxbase.test.BaseTest;
import com.xxbase.vo.SimpleDataVO;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by admin on 16/06/20.
 */
public class LambdaTest extends BaseTest{


    protected static List<SimpleDataVO> datas = new ArrayList<>();
    protected static List<Integer> integers = new ArrayList<>();

    @BeforeClass
    public static void beforeClass(){
        for(int i = 0; i < 10; i++){
            integers.add(i);
            datas.add(new SimpleDataVO(i + "", "TEST-" + i, i));
        }
    }

    @Test
    public void testLambda02(){
        logger.info("int max : {}", integers.stream().reduce(Integer::max).get());
        IntSummaryStatistics summary = datas.stream().mapToInt((a) -> a.getSort()).summaryStatistics();
        logger.info("data max : {}", summary);

    }

    @Test
    public void testLambda01(){
        logger.info("lambda count : {}", datas.stream().filter(obj -> (
            obj.getSort() > 5
        )).count());
    }
}
