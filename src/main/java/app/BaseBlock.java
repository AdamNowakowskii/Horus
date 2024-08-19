package app;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public record BaseBlock(String color, String material) implements Block {

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return this.color.equalsIgnoreCase(color)
                ? Optional.of(this)
                : Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return this.material.equalsIgnoreCase(material)
                ? Collections.singletonList(this)
                : Collections.emptyList();
    }

    @Override
    public int count() {
        return 1;
    }

}
