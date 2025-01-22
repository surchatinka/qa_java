import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    public static final String FAMILY_NAME = "Кошачьи";
    public static final int DEFAULT_KITTENS_COUNT = 1;
    public static final int KITTENS_COUNT = 10;
    @Spy private Feline feline = new Feline();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void getFamilyTest(){
        String family = feline.getFamily();
        Assert.assertEquals(family, FAMILY_NAME);
    }

    @Test
    public void getKittensTest(){
        feline.getKittens();
        Mockito.verify(feline,Mockito.times(1)).getKittens(DEFAULT_KITTENS_COUNT);
    }

    //отключить
//    @Parameterized.Parameters
//    public static Object[][] kittensParameters(){
//        return new Object[][]{
//               {0},{1},{1000000}
//        };
//    }

    @Test
    public void getNumberKittensTest(){
        int number = feline.getKittens(KITTENS_COUNT);
        Assert.assertEquals(number,KITTENS_COUNT);
    }

}
