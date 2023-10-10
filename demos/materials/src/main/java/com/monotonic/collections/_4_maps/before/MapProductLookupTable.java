package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the ProductLookupTable interface using a HashMap for product lookup.
 */
public class MapProductLookupTable implements ProductLookupTable
{
    private final Map<Integer, Product> idToProduct = new HashMap<>();

    /**
     * Adds a product to the lookup table.
     *
     * @param productToAdd The product to add.
     * @throws IllegalArgumentException if a product with a duplicate ID already exists.
     */
    @Override
    public void addProduct(final Product productToAdd)
    {
        var id = productToAdd.getId();
        if (idToProduct.containsKey(id))
        {
            throw new IllegalArgumentException(
                    "Unable to add product, duplicate id for: " + productToAdd);
        }

        idToProduct.put(id, productToAdd);
    }

    /**
     * Looks up a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The product associated with the given ID, or null if not found.
     */
    @Override
    public Product lookupById(final int id)
    {
        return idToProduct.get(id);
    }

    /**
     * Clears all products from the lookup table.
     */
    public void clear()
    {
        idToProduct.clear();
    }
}
