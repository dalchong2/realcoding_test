
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10, 15);
        int result2 = customCalculator.add(1,2);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 25);
        assertFalse(result==20);
        assertThat(result, is(25));



        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23, 10);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 13);
        assertThat(result, is(13));
        assertFalse(result == 13);
        System.out.println("result :: " + result);
    }

    @Test
    public void 빼기테스트() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23, 10);
        assertFalse(result == 12);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5, 9);
        int result2 = customCalculator.multiply(10, 9);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 45);
        assertThat(result, is(45));
        assertFalse(result2 == 10);
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25, 5);
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result == 5);
        assertThat(result, is(5));
        assertFalse( result==4);
        System.out.println("result :: " + result);
    }


    @Test(timeout = 4000)
    public void timeInMethodTest() throws InterruptedException {
        Thread.sleep(3000);
        //Thread.sleep(5000);
    }

    @Test(timeout = 2000)
    public void timeOutMethodTest() throws InterruptedException{
        Thread.sleep(6000);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIsEmptyIndexOutOfBoundException(){
        ArrayList<Object> myList = new ArrayList<>();
        myList.add("adad");
        new ArrayList<Object>().get(0);
        myList.get(1);

    }


    @Test
    public void testMethod(){
        ArrayList<Object> myList = new ArrayList<Object>();
        assertThat(myList.size(), is(0));
        //assertThat(myList.get(0),is(0));
        assertThat(myList,is(empty()));
    }

    @Test
    public void isEmptyArray(){
        ArrayList<Object> myList = new ArrayList<>();
        ArrayList<Object> myList2 = new ArrayList<>();
        assertThat(myList, is(empty()));
        assertThat(myList2, is(empty()));
        myList2.add("asd");
        assertThat(myList2, is(empty()));

    }
}