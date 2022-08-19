package my.task.horus.one;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> listBlock;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Block block = new Block() {
            @Override
            public String getColor() {
                return color;
            }
            @Override
            public String getMaterial() {
                return null;
            }
        };
        return Optional.of(block);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        Block block = new Block() {
            @Override
            public String getColor() {
                return null;
            }
            @Override
            public String getMaterial(){
                return material;
            }
        };
        return List.of(block);
    }

    @Override
    public int count(){
        CompositeBlock compositeBlock = new CompositeBlock() {
            @Override
            public List<Block> getBlocks(){
                if (!listBlock.isEmpty()){
                    return listBlock;
                }
                else return null;
            }
            @Override
            public String getColor() { return null; }

            @Override
            public String getMaterial() {
                return null;
            }
        };
        return compositeBlock.getBlocks().size() + 1;
    }

    public void setListBlock(List<Block> listBlock) {
        this.listBlock = listBlock;
    }
}