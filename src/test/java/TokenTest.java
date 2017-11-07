import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TokenTest {

    @Spy
    Token token = new Token(1, "Name");

    @Test
    // US-31
    public void testSetCoords() throws Exception {
        token.setCoords(0, 0);
        Mockito.verify(token).setBounds(0, 0, 20, 39);
    }

    @Test
    // US-31
    public void testSetSize() throws Exception {
        token.setSize(0, 0);
        Mockito.verify(token).setBounds(20, 20, 0, 0);
    }

    @Test
    // US-31
    public void testGetName() throws Exception {
        Assert.assertEquals("Name", token.getName());
    }

}