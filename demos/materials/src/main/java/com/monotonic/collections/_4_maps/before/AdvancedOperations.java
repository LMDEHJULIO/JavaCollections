package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates advanced operations on a map using Java's HashMap class.
 */
public class AdvancedOperations
{
    public static void main(String[] args)
    {
        // Create a default product to use if the requested product is not found.
        var defaultProduct = new Product(-1, "Whatever the customer wants", 100);

        // Create a HashMap to map product IDs to Product objects.
        var idToProduct = new HashMap<Integer, Product>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        // Demonstrate the 'getOrDefault' method to retrieve a product with a default value.
        var result = idToProduct.getOrDefault(10, defaultProduct);
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();

        // Demonstrate the 'computeIfAbsent' method to add a product if it doesn't exist.
        result = idToProduct
                .computeIfAbsent(10, (id) -> new Product(id, "Custom Product", 10));
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();

        // Demonstrate the 'replaceAll' method to modify values in the map.
        idToProduct.replaceAll((key, oldProduct) ->
                new Product(oldProduct.getId(), oldProduct.getName(), oldProduct.getWeight() + 10));
        System.out.println(idToProduct);
        System.out.println();
    }
}
