import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

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
    //@Spy Animal animal = new Animal();

    @Spy private Feline feline = new Feline();

    //private final Feline felineSpy = Mockito.spy(feline);

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void getFamilyTest(){
        String family = feline.getFamily();
        Assert.assertEquals(family,"Кошачьи");
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
        int number = feline.getKittens(numberOfKittens);
        Assert.assertEquals(number,numberOfKittens);
    }

}
