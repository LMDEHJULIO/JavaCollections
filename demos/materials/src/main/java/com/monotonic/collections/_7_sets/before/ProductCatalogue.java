package com.monotonic.collections._7_sets.before;

import com.monotonic.collections.common.Product;
import com.monotonic.collections.common.Supplier;

import java.util.*;

/**
 * A simple product catalog that stores products from suppliers.
 */
public class ProductCatalogue implements Iterable<Product>
{
    private final Set<Product> products = new HashSet<>();

    /**
     * Adds products from a supplier to the catalog.
     *
     * @param supplier The supplier to add products from.
     */
    public void addSupplier(final Supplier supplier)
    {
        products.addAll(supplier.getProducts());
    }

    /**
     * Returns an iterator for iterating through the products in the catalog.
     *
     * @return An iterator for products in the catalog.
     */
    @Override
    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}
