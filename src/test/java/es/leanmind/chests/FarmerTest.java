package es.leanmind.chests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FarmerTest {
    @Nested
    @DisplayName("Spell should")
    class SpellShould {
        @Test
        void chests_when_they_are_empty() {
            List<Item> items = List.of(
                    new Item("wood", 5),
                    new Item("wood", 2),
                    new Item("stone", 3),
                    new Item("mushroom", 1),
                    new Item("wheat seed", 4),
                    new Item("potato seed", 2),
                    new Item("trout", 1),
                    new Item("cooper ore", 3)
            );
            Item[] expectedSortedMaterials = new Item[]{
                    new Item("cooper ore", 3),
                    new Item("stone", 3),
                    new Item("wood", 5),
                    new Item("wood", 2)
            };
            Item[] expectedSortedSeeds = new Item[]{
                    new Item("potato seed", 2),
                    new Item("wheat seed", 4)
            };
            Item[] expectedSortedFood = new Item[]{
                    new Item("mushroom", 1),
                    new Item("trout", 1)
            };
            Farmer farmer = new Farmer();
            farmer.fill(items);

            farmer.spell();

            assertThat(farmer.getChest1()).containsExactly(expectedSortedMaterials);
            assertThat(farmer.getChest2()).containsExactly(expectedSortedSeeds);
            assertThat(farmer.getChest3()).containsExactly(expectedSortedFood);
        }

        @Test
        void empty_the_backpack_after_sorting() {
            List<Item> items = List.of(
                    new Item("wood", 5),
                    new Item("wood", 2),
                    new Item("stone", 3),
                    new Item("mushroom", 1),
                    new Item("wheat seed", 4),
                    new Item("potato seed", 2),
                    new Item("trout", 1),
                    new Item("cooper ore", 3)
            );
            Farmer farmer = new Farmer();
            farmer.fill(items);

            farmer.spell();

            assertThat(farmer.getBackpack()).isEmpty();
        }

        @Test
        void discard_items_that_do_not_fit_in_chests() {
            Farmer farmer = new Farmer();
            List<Item> items1 = List.of(
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 2),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 3)
            );
            farmer.fill(items1);
            farmer.spell();

            List<Item> items2 = List.of(
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 4),
                    new Item("coal", 2)
            );
            farmer.fill(items2);
            farmer.spell();

            List<Item> items3 = List.of(
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("coal", 5),
                    new Item("coal", 5),
                    new Item("coal", 5),
                    new Item("cooper ore", 5)
            );
            farmer.fill(items3);

            farmer.spell();

            Item[] expectedSortedMaterials = new Item[]{
                    new Item("coal", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 5),
                    new Item("stone", 2),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5),
                    new Item("wood", 5)
            };
            assertThat(farmer.getChest1()).containsExactly(expectedSortedMaterials);
        }
    }
}