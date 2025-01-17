import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class FelineTest {

    public FelineTest(int numberOfKittens) {
        this.numberOfKittens = numberOfKittens;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    private final int numberOfKittens;

    @Spy
    private Feline feline = new Feline();

    //private final Feline felineSpy = Mockito.spy(feline);

    @Test
    public void eatMeatTest() throws Exception {

        feline.eatMeat();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFamilyTest(){
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }

    //parameters getKittens() getKittens(int i)
    @Test
    public void getKittensTest(){
        feline.getKittens();
        Mockito.verify(feline,Mockito.times(1)).getKittens(1);
    }

    @Parameterized.Parameters
    public static Object[][] kittensParameters(){
        return new Object[][]{
                {0},{1},{1000000}
        };
    }

    @Test
    public void getNumberKittensTest(){
        feline.getKittens(numberOfKittens);
        Mockito.verify(feline).getKittens(numberOfKittens);
    }

}
