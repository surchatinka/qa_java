import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String FAMILY_NAME = "Кошачьи";
    private static final int DEFAULT_NUMBER_OF_KITTENS = 1;
    private static final int NUMBER_OF_KITTENS = 10;
    private static final String FOR_PREDATOR = "Хищник";
    @Spy private Feline feline = new Feline();

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood(FOR_PREDATOR);
    }

    @Test
    public void getFamilyTest(){
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }

    @Test
    public void getKittensTest(){
        feline.getKittens();
        Mockito.verify(feline).getKittens(DEFAULT_NUMBER_OF_KITTENS);
    }

    @Test
    public void getNumberKittensTest(){
        feline.getKittens(NUMBER_OF_KITTENS);
        Mockito.verify(feline).getKittens(NUMBER_OF_KITTENS);
    }

}
