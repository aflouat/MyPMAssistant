import fr.aflouat.Activity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActivityTests {

    @Test
    public void shouldReturnZeroWhenCreateActivityWithName(){
        Assertions.assertEquals(0, Activity.createActivity("Ordre du jour de la réunion de Kick off"));
    }

}
