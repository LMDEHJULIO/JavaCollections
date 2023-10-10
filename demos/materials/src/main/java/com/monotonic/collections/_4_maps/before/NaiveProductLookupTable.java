package com.monotonic.collections._4_maps.before;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the ProductLookupTable interface using a naive approach with a List for product lookup.
 */
public class NaiveProductLookupTable implements ProductLookupTable
{
    private final List<Product> products = new ArrayList<>();

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
        for (var product : products)
        {
            if (product.getId() == id)
            {
                throw new IllegalArgumentException(
                        "Unable to add product, duplicate id for: " + productToAdd);
            }
        }

        products.add(productToAdd);
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
        for (var product : products)
        {
            if (product.getId() == id)
            {
                return product;
            }
        }

        return null;
    }

    /**
     * Clears all products from the lookup table.
     */
    public void clear()
    {
        products.clear();
    }
}
