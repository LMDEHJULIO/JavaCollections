package com.monotonic.collections._3_lists.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a shipment of products and provides methods to manage and categorize them.
 */
public class Shipment implements Iterable<Product>
{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int MISSING_PRODUCT = -1;

    // A list to store the products in the shipment.
    private final List<Product> products = new ArrayList<>();

    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    /**
     * Adds a product to the shipment.
     *
     * @param product The product to add.
     */
    public void add(Product product)
    {
        products.add(product);
    }

    /**
     * Replaces an old product with a new one in the shipment.
     *
     * @param oldProduct The old product to be replaced.
     * @param newProduct The new product to replace the old one.
     * @return True if the replacement was successful, false otherwise.
     */
    public boolean replace(Product oldProduct, Product newProduct)
    {
        int position = products.indexOf(oldProduct);
        if (position == MISSING_PRODUCT) {
            return false;
        } else {
            products.set(position, newProduct);
            return true;
        }
    }

    // Find the index where the shipment should be split into two categories: light and heavy vans.
    private int findSplitPoint()
    {
        int size = products.size();
        for (int i = 0; i < size; i++)
        {
            var product = products.get(i);
            if (product.weight() > LIGHT_VAN_MAX_WEIGHT)
            {
                return i;
            }
        }
        return 0;
    }

    /**
     * Prepares the shipment by sorting products by weight and splitting them into light and heavy van products.
     */
    public void prepare()
    {
        // Sort the product list
        products.sort(Product.BY_WEIGHT);

        // find the split point
        int splitPoint = findSplitPoint();

        // create two subviews of the list
        lightVanProducts = products.subList(0, splitPoint);
        heavyVanProducts = products.subList(splitPoint, products.size());
    }

    /**
     * Gets a list of products suitable for heavy vans.
     *
     * @return List of products for heavy vans.
     */
    public List<Product> getHeavyVanProducts()
    {
        return heavyVanProducts;
    }

    /**
     * Gets a list of products suitable for light vans.
     *
     * @return List of products for light vans.
     */
    public List<Product> getLightVanProducts()
    {
        return lightVanProducts;
    }

    /**
     * Iterator implementation to iterate through the products in the shipment.
     *
     * @return An iterator over the products in the shipment.
     */
    public Iterator<Product> iterator()
    {
        return products.iterator();
    }

    /**
     * Removes heavy products from the shipment and returns true if any products were removed.
     *
     * @return True if heavy products were removed, false otherwise.
     */
    public boolean stripHeavyProducts()
    {
        return products.removeIf(product -> product.weight() > LIGHT_VAN_MAX_WEIGHT);
    }
}
