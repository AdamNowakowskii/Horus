package app;

import java.util.List;

public class BaseCompositeBlock extends CompositeBlock {

    public BaseCompositeBlock(List<Block> blocks) {
        super(blocks);
    }

    @Override
    public String color() {
        return "";
    }

    @Override
    public String material() {
        return "";
    }

}
