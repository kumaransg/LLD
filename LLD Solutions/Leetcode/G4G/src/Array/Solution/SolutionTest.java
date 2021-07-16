package Array.Solution;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    /**
     * TODO: Add tests
     */
    @Test
    public void validParanthesis0(){
        String exp = "(]";
        assertFalse(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis1(){
        String exp = "()";
        assertTrue(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis2(){
        String exp = "()[]{}";
        assertTrue(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis3(){
        String exp = "([)]";
        assertFalse(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis4(){
        String exp = "{[]}";
        assertTrue(Solution.isBalanced(exp));
    }@Test
    public void validParanthesis5(){
        String exp = "";
        assertTrue(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis6(){
        String exp = "[";
        assertFalse(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis7(){
        String exp = "){";
        assertFalse(Solution.isBalanced(exp));
    }
    @Test
    public void validParanthesis8(){
        String exp = "]";
        assertFalse(Solution.isBalanced(exp));
    }


}
