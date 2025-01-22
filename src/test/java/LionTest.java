import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    public static final int DEFAULT_NUMBER_CUBS = 1;
    public static final String MALE = "Самец";
    public static final String WRONG_SEX_TYPE = "Самурай";

    @Spy private Feline feline = new Feline();

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, MALE);
        int numberOfCubs = lion.getKittens();
        Mockito.verify(feline).getKittens();
        Assert.assertEquals(numberOfCubs, DEFAULT_NUMBER_CUBS);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, MALE);
        lion.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void createLionTestThrowsException() {
       try{
            new Lion(feline,WRONG_SEX_TYPE);
        } catch(Exception e){
            Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка",e.getMessage());
        }
        }
}
