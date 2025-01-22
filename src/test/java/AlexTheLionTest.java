import com.example.AlexTheLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class AlexTheLionTest {
    private static final List<String> ALEX_FRIENDS = List.of("Марти", "Глория", "Мелман", "Джулиан Тринадцатый");
    private static final String ZOO = "Нью-Йоркский зоопарк";
    private static final int NO_KITTENS = 0;

    Feline feline = new Feline();

    @Test
    public void getFriendsTest() throws Exception {
        AlexTheLion lion = new AlexTheLion(feline);
        List<String> friends = lion.getFriends();
        Assert.assertEquals(friends, ALEX_FRIENDS);
    }

    @Test
    public void getPlaceOfLivingTest() throws Exception {
        AlexTheLion lion = new AlexTheLion(feline);
        String place = lion.getPlaceOfLiving();
        Assert.assertEquals(place, ZOO);
    }

    @Test
    public void getKittensTest() throws Exception{
        AlexTheLion lion = new AlexTheLion(feline);
        int numberOfKittens = lion.getKittens();
        Assert.assertEquals(numberOfKittens, NO_KITTENS);
    }
}
