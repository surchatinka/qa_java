import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final int DEFAULT_NUMBER_CUBS = 1;
    private static final String MALE = "Самец";
    private static final String WRONG_SEX_TYPE = "Самурай";
    @Mock private Feline felineMock = new Feline();

    @Test
    public void getKittensCallTest() throws Exception {
        Lion lion = new Lion(felineMock, MALE);
        lion.getKittens();
        Mockito.verify(felineMock).getKittens();
    }
    @Test
    public void getKittensValuesTest() throws Exception {
        Lion lion = new Lion(felineMock, MALE);
        Mockito.when(felineMock.getKittens()).thenReturn(DEFAULT_NUMBER_CUBS);
        int expected = lion.getKittens();
        Assert.assertEquals(expected,DEFAULT_NUMBER_CUBS);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(felineMock, MALE);
        lion.getFood();
        Mockito.verify(felineMock).eatMeat();

    }

    @Test(expected = Exception.class)
    public void createLionTestThrowsException() {
        RuntimeException caughtException =
                (RuntimeException) Assert.assertThrows(Exception.class, () -> new Lion(felineMock,WRONG_SEX_TYPE));
        Assert.assertEquals("Используйте допустимые значения пола животного - Самец или Самка", caughtException.getMessage());
    }
}
