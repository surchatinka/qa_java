import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock private final Feline feline;
    @Spy private final Lion lion;

    public LionParameterizedTest(String sex) throws Exception {
        feline = new Feline();
        lion = new Lion(feline,sex);
    }

    @Parameterized.Parameters
    public static Object[][] lionData(){
        return new Object[][]{
                {MALE},{FEMALE}
        };
    }
    @Test
    public void doesHaveManeCallTest() {
        lion.doesHaveMane();
        Mockito.verify(lion).doesHaveMane();
    }
}
