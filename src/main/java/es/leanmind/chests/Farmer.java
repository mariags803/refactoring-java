package es.leanmind.chests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Farmer {
    private final List<Item> backpack = new ArrayList<>();
    private final List<Item> chest1 = new ArrayList<>();
    private final List<Item> chest2 = new ArrayList<>();
    private final List<Item> chest3 = new ArrayList<>();

    public List<Item> getBackpack() {
        return backpack;
    }

    public List<Item> getChest1() {
        return chest1;
    }

    public List<Item> getChest2() {
        return chest2;
    }

    public List<Item> getChest3() {
        return chest3;
    }

    void fill(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            if (backpack.size() < 16) {
                backpack.add(items.get(i));
            }
        }
    }

    void spell() {
        backpack.forEach(item -> {
            switch (item.getName()) {
                // materials
                case "wood":
                case "stone":
                case "coal":
                case "cooper ore":
                case "iron ore":
                    List<Item> items1 = chest1.stream().filter(chestItem -> chestItem.getName().equals(item.getName())).toList();
                    // if not exist any item with the same name, add the item to the chest
                    if (items1.isEmpty() && chest1.size() < 16) {
                        chest1.add(item);
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (int i = 0; i < items1.size(); i++) {
                            if (items1.get(i).getQuantity() < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.getQuantity() != 0 && items1.get(i).getQuantity() < 5) {
                                    items1.get(i).setQuantity(items1.get(i).getQuantity() + 1);
                                    item.setQuantity(item.getQuantity() - 1);
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.getQuantity() != 0 && chest1.size() < 16) {
                            chest1.add(item);
                        }
                    }
                    break;
                // seeds
                case "wheat seed":
                case "potato seed":
                case "carrot seed":
                case "corn seed":
                case "kale seed":
                    List<Item> items2 = chest2.stream().filter(chestItem -> chestItem.getName().equals(item.getName())).toList();
                    // if not exist any item with the same name, add the item to the chest
                    if (items2.isEmpty() && chest2.size() < 16) {
                        chest2.add(item);
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (int i = 0; i < items2.size(); i++) {
                            if (items2.get(i).getQuantity() < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.getQuantity() != 0 && items2.get(i).getQuantity() < 5) {
                                    items2.get(i).setQuantity(items2.get(i).getQuantity() + 1);
                                    item.setQuantity(item.getQuantity() - 1);
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.getQuantity() != 0 && chest2.size() < 16) {
                            chest2.add(item);
                        }
                    }
                    break;
                // food
                case "raspberry":
                case "apricot":
                case "wild onion":
                case "mushroom":
                case "trout":
                    List<Item> items3 = chest3.stream().filter(chestItem -> chestItem.getName().equals(item.getName())).toList();
                    // if not exist any item with the same name, add the item to the chest
                    if (items3.isEmpty() && chest3.size() < 16) {
                        chest3.add(item);
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (int i = 0; i < items3.size(); i++) {
                            if (items3.get(i).getQuantity() < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.getQuantity() != 0 && items3.get(i).getQuantity() < 5) {
                                    items3.get(i).setQuantity(items3.get(i).getQuantity() + 1);
                                    item.setQuantity(item.getQuantity() - 1);
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.getQuantity() != 0 && chest3.size() < 16) {
                            chest3.add(item);
                        }
                    }
                    break;
                default:
                    // if the object not in the list, do nothing
                    break;
            }
        });

        chest1.sort(Comparator.comparing(Item::getName));
        chest2.sort(Comparator.comparing(Item::getName));
        chest3.sort(Comparator.comparing(Item::getName));

        backpack.clear();
    }
}
