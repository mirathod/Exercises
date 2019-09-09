package org.milan.datastructure.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test Class for {@link PostfixEvaluation}
 *
 * @author Milan Rathod
 */
public class PostfixEvaluationTest {

    @Test
    public void testEvaluate() {
        PostfixEvaluation postfixEvaluation = new PostfixEvaluation();

        Assert.assertEquals(288, postfixEvaluation.evaluate("6523+8*+3+*"));

        Assert.assertEquals(4, postfixEvaluation.evaluate("231*+9-"));
    }
}