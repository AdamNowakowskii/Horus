package app;


import java.util.List;

public class Wall extends CompositeBlock {

    public Wall(List<Block> blocks) {
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
