package org.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.test.testmodels.TestData;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.test.testmodels.TestData.*;

class WallTest {

    @ParameterizedTest
    @MethodSource("shouldReturnBlockByColor")
    @DisplayName("should return correct block by color")
    public void findBlockByColor_shouldReturnBlockByColor(Wall givenWall,
                                                          String givenColor,
                                                          String expectedColor) {
        //when
        Optional<Block> foundBlockByColor = givenWall.findBlockByColor(givenColor);
        //then
        Assertions.assertEquals(expectedColor, foundBlockByColor.get().getColor());

    }

    @Test
    @DisplayName("should return empty optional if color not found")
    void findBlockByColor_withNonExistColor_shouldReturnEmptyOptional() {
        //given
        Wall givenWall = createTestObjectWithMixedTypeBlocks();
        //when
        Optional<Block> blockByColor = givenWall.findBlockByColor(GIVEN_NON_EXIST_COLOR);
        //then
        Assertions.assertEquals(Optional.empty(), blockByColor);
    }

    @ParameterizedTest
    @MethodSource("shouldReturnBlocksByMaterial")
    @DisplayName("should return list of blocks by material or empty list if not found")
    public void findBlockByMaterial_shouldReturnBlocksByMaterial(Wall givenWall,
                                                                 String givenMaterial,
                                                                 List<Block> expectedBlocks) {
        //when
        List<Block> blocksByMaterial = givenWall.findBlocksByMaterial(givenMaterial);
        //then
        Assertions.assertEquals(expectedBlocks, blocksByMaterial);
    }


    @ParameterizedTest
    @MethodSource("shouldReturnSumOfBLocks")
    @DisplayName("should return correct sum of blocks")
    public void count_shouldReturnSumOfBlocks(Wall givenWall, int expectedSum) {
        //when
        int sumOfBlocks = givenWall.count();
        //then
        Assertions.assertEquals(expectedSum, sumOfBlocks);

    }

    private static Stream<Arguments> shouldReturnBlockByColor() {
        return Stream.of(Arguments.of(TestData.createTestObjectWithoutCompositeBlocks(),
                        GIVEN_COLOR, EXPECTED_COLOR),
                Arguments.of(TestData.createTestObjectWithOnlyCompositeBlocks(),
                        GIVEN_COLOR, EXPECTED_COLOR),
                Arguments.of(TestData.createTestObjectWithMixedTypeBlocks(),
                        GIVEN_COLOR, EXPECTED_COLOR));
    }

    private static Stream<Arguments> shouldReturnBlocksByMaterial() {
        return Stream.of(Arguments.of(TestData.createTestObjectWithoutCompositeBlocks(),
                        GIVEN_MATERIAL, EXPECTED_LIST_OF_BLOCKS_WITHOUT_COMPOSITE_BLOCKS),
                Arguments.of(TestData.createTestObjectWithOnlyCompositeBlocks(),
                        GIVEN_MATERIAL, EXPECTED_LIST_OF_BLOCKS_WITH_COMPOSITE_BLOCKS),
                Arguments.of(TestData.createTestObjectWithMixedTypeBlocks(),
                        GIVEN_MATERIAL, EXPECTED_LIST_OF_BLOCKS_WITH_MIXED_BLOCKS),
                Arguments.of(TestData.createTestObjectWithMixedTypeBlocks(), GIVEN_NON_EXIST_MATERIAL, List.of()));
    }

    private static Stream<Arguments> shouldReturnSumOfBLocks() {
        return Stream.of(Arguments.of(TestData.createTestObjectWithoutCompositeBlocks(),
                        EXPECTED_SIZE_FOR_LIST_WITHOUT_COMPOSITE_BLOCKS),
                Arguments.of(TestData.createTestObjectWithOnlyCompositeBlocks(),
                        EXPECTED_SIZE_FOR_LIST_WITH_COMPOSITE_BLOCKS),
                Arguments.of(TestData.createTestObjectWithMixedTypeBlocks(),
                        EXPECTED_SIZE_FOR_LIST_WITH_MIXED_BLOCKS));
    }

}