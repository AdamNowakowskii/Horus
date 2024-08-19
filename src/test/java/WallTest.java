import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import app.BaseBlock;
import app.BaseCompositeBlock;
import app.Block;
import app.Wall;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WallTest {

    private static Wall wall;
    private static Block block;

    @BeforeAll
    public static void init() {
        Block b1 = new BaseBlock("green", "wood");
        Block b2 = new BaseBlock("blue", "a");
        Block b3 = new BaseBlock("yellow", "c");

        Block b4 = new BaseBlock("orange", "a");
        Block b5 = new BaseBlock("red", "wood");
        Block b6 = new BaseBlock("pink", "c");

        Block b7 = new BaseBlock("white", "a");
        Block b8 = new BaseBlock("black", "b");
        Block b9 = new BaseBlock("purple", "c");

        Block cb1 = new BaseCompositeBlock(List.of(b1, b2, b3));
        Block cb2 = new BaseCompositeBlock(List.of(b4, b5, b6));
        Block cb3 = new BaseCompositeBlock(List.of(cb1, cb2, b7, b8, b9));

        wall = new Wall(List.of(cb3));
        block = b9;
    }

    @Test
    public void shouldWallCountReturn10() {
        Assertions.assertEquals(9, wall.count());
    }

    @Test
    public void shouldWallColorReturnBlue() {
        Optional<Block> blue = wall.findBlockByColor("purple");
        blue.ifPresent(value -> Assertions.assertEquals(value.color(), block.color()));
    }

    @Test
    public void shouldWallMaterialReturn1() {
        List<Block> woodBlocks = wall.findBlocksByMaterial("wood");
        Assertions.assertEquals(2, woodBlocks.size());
    }

    @Test
    public void shouldWallMaterialReturn0() {
        List<Block> woodBlocks = wall.findBlocksByMaterial("glass");
        Assertions.assertEquals(0, woodBlocks.size());
    }

}