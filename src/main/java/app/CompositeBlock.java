package app;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CompositeBlock implements Block {

    private final List<Block> blocks;

    public CompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> blocks() {
        return blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .map(block -> block.findBlockByColor(color))
                .filter(foundBlock -> foundBlock.isPresent() && foundBlock.get().color().equalsIgnoreCase(color))
                .findFirst()
                .orElse(Optional.empty());
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .flatMap(block -> block.findBlocksByMaterial(material).stream())
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(Block::count)
                .sum();
    }

}
