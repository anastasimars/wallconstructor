package org.test.testmodels;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.test.Block;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SquareBlockTest implements Block {
    String color;
    String material;

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
