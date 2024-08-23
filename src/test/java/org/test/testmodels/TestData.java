package org.test.testmodels;

import org.test.Block;
import org.test.Wall;

import java.util.List;

public class TestData {
    public static final Block EXPECTED_BLOCK = new CircleBlockTest("yellow", "paper");
    public static final String EXPECTED_COLOR = "yellow";
    public static final String GIVEN_COLOR = "yellow";
    public static final String GIVEN_MATERIAL = "paper";
    public static final int EXPECTED_SIZE_FOR_LIST_WITHOUT_COMPOSITE_BLOCKS = 2;
    public static final int EXPECTED_SIZE_FOR_LIST_WITH_COMPOSITE_BLOCKS = 5;
    public static final int EXPECTED_SIZE_FOR_LIST_WITH_MIXED_BLOCKS = 4;
    public static final List<Block> EXPECTED_LIST_OF_BLOCKS_WITHOUT_COMPOSITE_BLOCKS = List.of(new CircleBlockTest("yellow", "paper"));
    public static final List<Block> EXPECTED_LIST_OF_BLOCKS_WITH_COMPOSITE_BLOCKS = List.of(new CircleBlockTest("yellow", "paper"),
            new SquareBlockTest("green", "paper"),
            new SquareBlockTest("white", "paper"));
    public static final List<Block> EXPECTED_LIST_OF_BLOCKS_WITH_MIXED_BLOCKS = List.of(new CircleBlockTest("yellow", "paper"),
            new SquareBlockTest("white", "paper"));

    public static Wall createTestObjectWithoutCompositeBlocks() {
        return new Wall(preparedTestDataWithoutCompositeBlocks());
    }

    public static Wall createTestObjectWithOnlyCompositeBlocks() {
        return new Wall(preparedTestDataWithOnlyCompositeBlocks());
    }

    public static Wall createTestObjectWithMixedTypeBlocks() {
        return new Wall(preparedTestDataWithMixedTypeBlocks());
    }

    private static List<Block> preparedTestDataWithoutCompositeBlocks() {
        return List.of(testCircle(), testSquare());
    }

    private static List<Block> preparedTestDataWithOnlyCompositeBlocks() {
        return List.of(testCompositeBlock1(), testCompositeBlock2());
    }

    private static List<Block> preparedTestDataWithMixedTypeBlocks() {
        return List.of(testCircle(), testCompositeBlock2(), testSquare());
    }

    private static CircleBlockTest testCircle() {
        return new CircleBlockTest("yellow", "paper");
    }

    private static SquareBlockTest testSquare() {
        return new SquareBlockTest("green", "rock");
    }

    private static TestCompositeBlock testCompositeBlock1() {
        return new TestCompositeBlock(List.of(
                new CircleBlockTest("yellow", "paper"),
                new SquareBlockTest("blue", "rock"),
                new SquareBlockTest("green", "paper")));
    }

    private static TestCompositeBlock testCompositeBlock2() {
        return new TestCompositeBlock(List.of(
                new CircleBlockTest("yellow", "glass"),
                new SquareBlockTest("white", "paper")));
    }

}
