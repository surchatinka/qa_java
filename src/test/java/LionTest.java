import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionTest {

    public LionTest(String sex,boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Rule public final MockitoRule rule = MockitoJUnit.rule();
    private final String sex;
    private final boolean mane;
    @Mock private Feline feline = new Feline();

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline,sex);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline,sex);
        boolean check = lion.doesHaveMane();
        Assert.assertEquals(check,mane);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline,sex);
        lion.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Parameterized.Parameters
    public static Object[][] lionData(){
        return new Object[][]{
                {"Самец",true},{"Самка",false}
        };
    }

    //Lion(Predator predator,String sex) sex - Самец, Самка, Undefined
//    @Test
//    public void createLionTest() throws Exception {
//        try{
//            new Lion(feline,sex);
//        } catch(Exception e){
//            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка",e.getMessage());
//        }
//
//        }
}
