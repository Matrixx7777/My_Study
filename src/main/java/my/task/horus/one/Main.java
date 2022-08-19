package my.task.horus.one;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Wall wall = new Wall();

        //Colors
        List<String> listColors = new ArrayList<>();
        listColors.add("Blue");
        listColors.add("Black");
        listColors.add("Purple");

        List<Block> listBlockColors = new ArrayList<>(List.of(wall.findBlockByColor(listColors.get(0)).get()));

        System.out.println("\nReturn elements of color by Optional: ");
        for (Block allElementsColor : listBlockColors) {
            System.out.println("[ " + allElementsColor.getColor() + " | " + allElementsColor.getMaterial() + " ]");
        }

        System.out.println("\n-------------------------\n");

        //Materials
        List<String> listMaterials = new ArrayList<>();
        listMaterials.add("Cotton");
        listMaterials.add("Elastic material");
        listMaterials.add("Silk");
        listMaterials.add("Nylon");

//      Fun
//      List<String> listMaterial = Collections.singletonList(wall.findBlocksByMaterial(listMaterials.get(0)).get(0).getMaterial());

        List<String> listMaterial =
                new ArrayList<>(List.of(wall.findBlocksByMaterial(listMaterials.get(0)).get(0).getMaterial()));
        listMaterial.add(listMaterials.get(1));
        listMaterial.add(listMaterials.get(2));
        listMaterial.add(listMaterials.get(3));

        List<Block> listBlockMaterials = new ArrayList<>(List.of(wall.findBlocksByMaterial(listMaterials.get(0)).get(0)));
        listBlockMaterials.add(wall.findBlocksByMaterial(listMaterials.get(1)).get(0));
        listBlockMaterials.add(wall.findBlocksByMaterial(listMaterials.get(2)).get(0));
        listBlockMaterials.add(wall.findBlocksByMaterial(listMaterials.get(3)).get(0));

        System.out.println("Return elements of material by List: ");
        for (Block allElementsMaterial : listBlockMaterials) {
            System.out.println("[ " + allElementsMaterial.getColor() + " | " + allElementsMaterial.getMaterial() + " ]");
        }

        System.out.println("\n-------------------------\n");

        //Count all blocks
        wall.setListBlock(listBlockColors);
        wall.setListBlock(listBlockMaterials);

        int isList = wall.count();

        System.out.println("Lists are equals --> " + isList);
    }
}