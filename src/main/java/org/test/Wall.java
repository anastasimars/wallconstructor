package org.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


@AllArgsConstructor
@Getter
public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColor(blocks, color);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findBlocksByMaterial(blocks, material);
    }

    @Override
    public int count() {
        return count(blocks);
    }

    private Optional<Block> findBlockByColor(List<Block> blocks, String color) {
        return blocks.stream()
                .flatMap(block -> {
                    if (block instanceof CompositeBlock) {
                        return findBlockByColor(((CompositeBlock) block).getBlocks(), color).stream();
                    } else {
                        return block.getColor().equals(color) ? Stream.of(block) : Stream.empty();
                    }
                })
                .findAny();
    }

    private List<Block> findBlocksByMaterial(List<Block> blocks, String material) {
        return blocks.stream().flatMap(block -> {
            if (block instanceof CompositeBlock) {
                return findBlocksByMaterial(((CompositeBlock) block).getBlocks(), material).stream();
            } else {
                return block.getMaterial().equals(material) ? Stream.of(block) : Stream.empty();
            }
        }).toList();
    }

    private int count(List<Block> blocks) {
        return blocks.stream().mapToInt(block -> {
            if (block instanceof CompositeBlock) {
                return count(((CompositeBlock) block).getBlocks());
            } else {
                return 1;
            }
        }).sum();
    }
}
