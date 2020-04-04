package org.milan.datastructure.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link Flattening}
 *
 * @author Milan Rathod
 */
public class FlatteningTest {

    @Test
    public void testFlatten() {
        Flattening.Node<Integer> head = new Flattening.Node<>(5);

        // First down list
        Flattening.Node<Integer> firstDownList = new Flattening.Node<>(7);
        firstDownList.down = new Flattening.Node<>(8);
        firstDownList.down.down = new Flattening.Node<>(30);

        head.down = firstDownList;

        // Second down list
        Flattening.Node<Integer> secondDownList = new Flattening.Node<>(20);

        Flattening.Node<Integer> secondNode = new Flattening.Node<>(10);
        secondNode.down = secondDownList;
        head.right = secondNode;

        // Third down list
        Flattening.Node<Integer> thirdDownList = new Flattening.Node<>(22);
        thirdDownList.down = new Flattening.Node<>(50);

        Flattening.Node<Integer> thirdNode = new Flattening.Node<>(19);
        thirdNode.down = thirdDownList;
        secondNode.right = thirdNode;

        Flattening flattening = new Flattening();

        Flattening.Node<Integer> newHead = flattening.flatten(head);

        List<Integer> result = new ArrayList<>();

        while (newHead != null) {
            result.add(newHead.data);
            newHead = newHead.down;
        }

        Assert.assertEquals(result, Arrays.asList(5, 7, 8, 10, 19, 20, 22, 30, 50));
    }
}