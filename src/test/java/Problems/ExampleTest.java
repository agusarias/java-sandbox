package Problems;

import org.a2.sandbox.Problems.Example.Input;
import org.a2.sandbox.Problems.Example.Result;
import org.a2.sandbox.Problems.Example.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private Solution solution;

    @Before
    public void setUp() {
        this.solution = new Solution();
    }

    @Test
    public void testExampleSimple() {
        // GIVEN
        Input input = new Input("elpmaxe");

        // WHEN
        Result result = this.solution.solve(input);

        // THEN
        assertEquals("example", result.getResult());
    }

    @Test
    public void testExampleWords() {
        // GIVEN
        Input input = new Input("elpmaxe na si siht");

        // WHEN
        Result result = this.solution.solve(input);

        // THEN
        assertEquals("this is an example", result.getResult());
    }
}
