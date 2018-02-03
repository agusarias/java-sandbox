package Problems;

import org.a2.sandbox.Problems.CarSubTracks.Input;
import org.a2.sandbox.Problems.CarSubTracks.Result;
import org.a2.sandbox.Problems.CarSubTracks.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarSubTracksTest {

    private Solution solution;

    @Before
    public void setUp() {
        this.solution = new Solution();
    }

    @Test
    public void testFirst() {
        // GIVEN
        Input input = new Input(
                "2\n" +
                        "5 7\n" +
                        "2 5 4 5 2\n" +
                        "5 4\n" +
                        "1 6 3 5 2");

        // WHEN
        Result result = this.solution.solve(input);

        // THEN
        assertEquals(-1, result.getPetrolUnits(0));
        assertEquals(2, result.getPetrolUnits(1));
    }

    @Test
    public void testSecond() {
        // GIVEN
        Input input = new Input(
                "3\n" +
                        "5 3\n" +
                        "2 5 4 5 2\n" +
                        "5 4\n" +
                        "1 6 3 5 2\n" +
                        "2 4\n" +
                        "8 9\n");

        // WHEN
        Result result = this.solution.solve(input);

        // THEN
        assertEquals(2, result.getPetrolUnits(0));
        assertEquals(2, result.getPetrolUnits(1));
        assertEquals(5, result.getPetrolUnits(2));
    }
    @Test
    public void testThird() {
        // GIVEN
        Input input = new Input(
                "1\n" +
                        "4 56\n" +
                        "37 6 47 30");

        // WHEN
        Result result = this.solution.solve(input);

        // THEN
        assertEquals(-1, result.getPetrolUnits(0));
    }
}
