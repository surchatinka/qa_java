import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private final String sex;
    private final boolean mane;
    @Spy Feline feline = new Feline();

    public LionParameterizedTest(String sex, boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    @Parameterized.Parameters
    public static Object[][] lionData(){
        return new Object[][]{
                {MALE,true},{FEMALE,false}
        };
    }
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline,sex);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals(actual,mane);
    }
}
