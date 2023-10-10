package com.monotonic.collections._4_maps.before;

import com.monotonic.collections._4_maps.after.Product;
import com.monotonic.collections._4_maps.after.ProductFixtures;


import java.util.HashMap;


/**
 * Demonstrates the usage of various views over a map, such as keySet, values, and entrySet, and their behavior.
 */
public class ViewsOverMaps
{
    public static void main(String[] args)
    {
        // Create a HashMap to store products by ID.
        var idToProduct = new HashMap<Integer, Product>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        // Obtain a set of keys (product IDs) from the map.
        var ids = idToProduct.keySet();
        System.out.println(ids);
        System.out.println(idToProduct);
        System.out.println();

        // Attempt to remove a key (product ID) from the key set and observe the impact on the map.
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);

        // Attempting to add a key to the key set would be invalid and is commented out.
        // ids.add(5);

        // Obtain a collection of values (products) from the map.
        var products = idToProduct.values();
        System.out.println(products);
        System.out.println(idToProduct);

        // Attempt to remove a value from the collection of values and observe the impact on the map.
        products.remove(ProductFixtures.window);

        System.out.println(products);
        System.out.println(idToProduct);

        // Attempting to add a value to the collection of values would be invalid and is commented out.
        // products.add(ProductFixtures.window);

        // Obtain a set of entries (key-value pairs) from the map.
        var entries = idToProduct.entrySet();
        for (var entry : entries)
        {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

            // Attempting to set the value of an entry is valid and is commented out.
            // entry.setValue(ProductFixtures.window);
        }

        // Creating a new entry and adding it to the set of entries is invalid and is commented out.
        // var entry = Map.entry(3, ProductFixtures.window);
        // entries.add(entry);

        System.out.println(idToProduct);
    }
}
