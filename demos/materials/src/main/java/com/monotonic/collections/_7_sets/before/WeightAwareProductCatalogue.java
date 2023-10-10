package com.monotonic.collections._7_sets.before;

import com.monotonic.collections.common.Product;
import com.monotonic.collections.common.Supplier;

import java.util.*;

/**
 * A catalog of products sorted by weight, allowing retrieval of lighter products.
 */
public class WeightAwareProductCatalogue implements Iterable<Product>
{
    // Initialize TreeSet of products, inherently sorted by Product weight
    private final NavigableSet<Product> products =
            new TreeSet<>(Product.BY_WEIGHT);

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
     * Finds and returns a set of products lighter than the given product.
     *
     * @param product The reference product to compare weights with.
     * @return A set of products lighter than the reference product.
     */
    public Set<Product> findLighterProducts(final Product product)
    {
        return products.headSet(product);
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
