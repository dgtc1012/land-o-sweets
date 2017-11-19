import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**************************************************************************
 * All tests are for US-42, implemented by the Timer.java class
 **************************************************************************/
public class TimerTest {
    Timer timer;

    @Before
    public void setup() {
        timer = new Timer(875, 100);
    }

    @Test
    public void startTimeTest() throws Exception {
        assertEquals(0, timer.getSeconds());
        assertEquals(0, timer.getMinutes());
        assertEquals(0, timer.getHours());
    }

    @Test
    public void secondToMinTransition() throws Exception {
        for (int i = 1; i < 60; i++) {
            timer.incrementTime();
        }

        assertEquals(59, timer.getSeconds());
        assertEquals(0, timer.getMinutes());

        timer.incrementTime();

        assertEquals(0, timer.getSeconds());
        assertEquals(1, timer.getMinutes());
    }

    @Test
    public void minToHourTransition() throws Exception {
        for (int i = 1; i < 60 * 60; i++) {
            timer.incrementTime();
        }

        assertEquals(59, timer.getSeconds());
        assertEquals(59, timer.getMinutes());
        assertEquals(0, timer.getHours());

        timer.incrementTime();

        assertEquals(0, timer.getSeconds());
        assertEquals(0, timer.getMinutes());
        assertEquals(1, timer.getHours());
    }

    @Test
    public void loadExistingTime() throws Exception {
        timer = new Timer(850, 100, 12, 33, 1);
        assertEquals(12, timer.getSeconds());
        assertEquals(33, timer.getMinutes());
        assertEquals(1, timer.getHours());
    }

    @Test
    public void testPaintTimer() throws Exception {
        timer.paintTimer(12, 33, 1);
        assertEquals("01:33:12", timer.gui.getText());
    }
}
