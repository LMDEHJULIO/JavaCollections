package com.monotonic.collections._4_maps.before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class compares the performance of different product lookup table implementations.
 */
public class LookupTableComparison
{
    private static final int ITERATIONS = 5;
    private static final int NUMBER_OF_PRODUCTS = 20_000;

    // Generate a list of products to be used for testing lookup tables.
    private static final List<Product> products = generateProducts();

    public static void main(String[] args)
    {
        // Run lookups using different product lookup table implementations.
        runLookups(new MapProductLookupTable());
        runLookups(new NaiveProductLookupTable());
    }

    /**
     * Generates a list of random products with unique IDs.
     *
     * @return A list of randomly generated products.
     */
    private static List<Product> generateProducts()
    {
        final List<Product> products = new ArrayList<>();
        final Random weightGenerator = new Random();
        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++)
        {
            products.add(new Product(i, "Product" + i, 10 + weightGenerator.nextInt(10)));
        }
        // Shuffle the products to make their order random.
        Collections.shuffle(products);
        Collections.shuffle(products);
        Collections.shuffle(products);
        return products;
    }

    /**
     * Perform product lookups and measure their performance.
     *
     * @param lookupTable The product lookup table implementation to test.
     */
    private static void runLookups(final ProductLookupTable lookupTable)
    {
        final List<Product> products = LookupTableComparison.products;
        System.out.println("Running lookups with " + lookupTable.getClass().getSimpleName());

        for (int i = 0; i < ITERATIONS; i++)
        {
            final long startTime = System.currentTimeMillis();

            // Add products to the lookup table.
            for (Product product : products)
            {
                lookupTable.addProduct(product);
            }

            // Perform lookups and verify the results.
            for (Product product : products)
            {
                final Product result = lookupTable.lookupById(product.getId());
                if (result != product)
                {
                    throw new IllegalStateException("Lookup Table returned the wrong result for " + product);
                }
            }

            // Clear the lookup table for the next iteration.
            lookupTable.clear();

            System.out.println(System.currentTimeMillis() - startTime + "ms");
        }
    }
}
