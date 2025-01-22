import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    public static final String DEFAULT_SOUND = "Мяу";
    @Mock Feline feline = new Feline();

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals(sound, DEFAULT_SOUND);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
