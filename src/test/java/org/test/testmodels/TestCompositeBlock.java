package org.test.testmodels;

import lombok.AllArgsConstructor;
import org.test.Block;
import org.test.CompositeBlock;

import java.util.List;

@AllArgsConstructor
public class TestCompositeBlock implements CompositeBlock {
    private List<Block> blocks;

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return "color";
    }

    @Override
    public String getMaterial() {
        return "material";
    }
}
