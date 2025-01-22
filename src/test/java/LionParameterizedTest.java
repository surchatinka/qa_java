import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    public LionParameterizedTest(String sex, boolean mane) {
        this.sex = sex;
        this.mane = mane;
    }

    private final String sex;
    private final boolean mane;
    @Spy Feline feline = new Feline();

    @Parameterized.Parameters
    public static Object[][] lionData(){
        return new Object[][]{
                {"Самец",true},{"Самка",false}
        };
    }
    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(feline,sex);
        boolean check = lion.doesHaveMane();
        Assert.assertEquals(check,mane);
    }
}
