import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TreeTest {

    @Test
    public void treeSizeTest() {
        ArrayList<? super Number> integers = new ArrayList<>();
        integers.add(2.3);
        integers.add(null);
        integers.add(3);
        integers.add(null);
        integers.add(null);
        integers.add(6);
        integers.add(7);
        integers.add(null);

        Tree<? super Number> tree = new Tree<>(integers);
        Assertions.assertThat(tree.size()).isEqualTo(4);
    }

    @Test
    public void dfsPreOrderTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);

        Tree<Integer> tree = new Tree<>(integers);

        final List<Number> dfsResult = new ArrayList<>();
        tree.dfsPreOrder(x -> {
            dfsResult.add(x.getValue());
        });
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(3);
        expectedResult.add(6);
        expectedResult.add(7);
        Assertions.assertThat(dfsResult).isEqualTo(expectedResult);
    }

    @Test
    public void dfsInOrderTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);

        Tree<Integer> tree = new Tree<>(integers);

        final List<Number> dfsResult = new ArrayList<>();
        tree.dfsInOrder(x -> {
            dfsResult.add(x.getValue());
        });
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(4);
        expectedResult.add(2);
        expectedResult.add(5);
        expectedResult.add(1);
        expectedResult.add(6);
        expectedResult.add(3);
        expectedResult.add(7);
        Assertions.assertThat(dfsResult).isEqualTo(expectedResult);
    }

    @Test
    public void dfsPostOrderTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);

        Tree<Integer> tree = new Tree<>(integers);

        final List<Number> dfsResult = new ArrayList<>();
        tree.dfsPostOrder(x -> {
            dfsResult.add(x.getValue());
        });
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(4);
        expectedResult.add(5);
        expectedResult.add(2);
        expectedResult.add(6);
        expectedResult.add(7);
        expectedResult.add(3);
        expectedResult.add(1);
        Assertions.assertThat(dfsResult).isEqualTo(expectedResult);
    }

    @Test
    public void rootIsNullTest() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(null);
        integers.add(null);

        Tree<Integer> tree = new Tree<>(integers);
        Assertions.assertThat(tree.size()).isEqualTo(0);
    }

    @Test
    public void incorrectTreeTest() {
        Assertions.assertThatThrownBy(() -> {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(null);
            integers.add(3);
            integers.add(4);

            new Tree<>(integers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}