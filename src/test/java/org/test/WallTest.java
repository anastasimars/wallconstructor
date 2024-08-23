package org.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.test.testmodels.TestData;

import java.util.List;
import java.util.Optional;

import static org.test.testmodels.TestData.*;

class WallTest {


    @Test
    void findBlockByColor_withoutCompositeBlocks_shouldReturnBlockByColor() {
        //given
        Wall givenWallWithoutCompositeBlocks = TestData.createTestObjectWithoutCompositeBlocks();
        //when
        Optional<Block> foundBlockByColor = givenWallWithoutCompositeBlocks.findBlockByColor(GIVEN_COLOR);
        // then
        Optional<Block> expectedResult = Optional.of(EXPECTED_BLOCK);
        Assertions.assertEquals(expectedResult, foundBlockByColor);
    }

    @Test
    void findBlockByColor_withCompositeBlocks_shouldReturnBlockByColor() {
        //given
        Wall givenWallWithCompositeBlocks = TestData.createTestObjectWithOnlyCompositeBlocks();
        //when
        Optional<Block> foundBlock = givenWallWithCompositeBlocks.findBlockByColor(GIVEN_COLOR);
        //then

        Assertions.assertEquals(EXPECTED_COLOR, foundBlock.get().getColor());
    }

    @Test
    void findBlockByColor_withMixedTypeBlocks_shouldReturnBlockByColor() {
        //given
        Wall givenWallWithMixedBlocks = TestData.createTestObjectWithMixedTypeBlocks();
        //when
        Optional<Block> foundBlock = givenWallWithMixedBlocks.findBlockByColor(GIVEN_COLOR);
        //then
        Assertions.assertEquals(EXPECTED_COLOR, foundBlock.get().getColor());
    }


    @Test
    void findBlockByMaterial_withoutCompositeBlocks_shouldReturnBlocksByMaterial() {
        //given
        Wall givenWallWithoutCompositeBlocks = TestData.createTestObjectWithoutCompositeBlocks();
        //when
        List<Block> foundBlocksByMaterial = givenWallWithoutCompositeBlocks.findBlocksByMaterial(GIVEN_MATERIAL);
        //then
        Assertions.assertEquals(EXPECTED_LIST_OF_BLOCKS_WITHOUT_COMPOSITE_BLOCKS, foundBlocksByMaterial);
    }

    @Test
    void findBlockByMaterial_withCompositeBlocks_shouldReturnBlocksByMaterial() {
        //given
        Wall givenWallWithCompositeBlocks = TestData.createTestObjectWithOnlyCompositeBlocks();
        //when
        List<Block> foundBlocksByMaterial = givenWallWithCompositeBlocks.findBlocksByMaterial(GIVEN_MATERIAL);
        //then
        Assertions.assertEquals(EXPECTED_LIST_OF_BLOCKS_WITH_COMPOSITE_BLOCKS, foundBlocksByMaterial);
    }

    @Test
    void findBlockByMaterial_withMixedTypeBlocks_shouldReturnBlocksByMaterial() {
        //given
        Wall givenWallWithMixedBlocks = TestData.createTestObjectWithMixedTypeBlocks();
        //when
        List<Block> foundBlocksByMaterial = givenWallWithMixedBlocks.findBlocksByMaterial(GIVEN_MATERIAL);
        //then
        Assertions.assertEquals(EXPECTED_LIST_OF_BLOCKS_WITH_MIXED_BLOCKS, foundBlocksByMaterial);
    }

    @Test
    void count_withoutCompositeBlocks_shouldReturnSumOfBlock() {
        //given
        Wall givenWallWithoutCompositeBlocks = TestData.createTestObjectWithoutCompositeBlocks();
        //when
        int sumOfBlocks = givenWallWithoutCompositeBlocks.count();
        //then
        Assertions.assertEquals(EXPECTED_SIZE_FOR_LIST_WITHOUT_COMPOSITE_BLOCKS, sumOfBlocks);
    }

    @Test
    void count_withCompositeBlocks_shouldReturnSumOfBlock() {
        //given
        Wall givenWallWithCompositeBlocks = TestData.createTestObjectWithOnlyCompositeBlocks();
        //when
        int sumOfBlocks = givenWallWithCompositeBlocks.count();
        //then
        Assertions.assertEquals(EXPECTED_SIZE_FOR_LIST_WITH_COMPOSITE_BLOCKS, sumOfBlocks);
    }

    @Test
    void count_withMixedTypeBlocks_shouldReturnSumOfBlock() {
        //given
        Wall givenWallWithMixedBlocks = TestData.createTestObjectWithMixedTypeBlocks();
        //when
        int sumOfBlocks = givenWallWithMixedBlocks.count();
        //then
        Assertions.assertEquals(EXPECTED_SIZE_FOR_LIST_WITH_MIXED_BLOCKS, sumOfBlocks);
    }


}