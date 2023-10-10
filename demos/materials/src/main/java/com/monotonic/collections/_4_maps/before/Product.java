package com.monotonic.collections._4_maps.before;
import java.util.Objects;

/**
 * Represents a product with an ID, name, and weight.
 */
public class Product
{
    private final int id;
    private final String name;
    private final int weight;

    /**
     * Initializes a new instance of the Product class.
     *
     * @param id     The unique ID of the product.
     * @param name   The name of the product.
     * @param weight The weight of the product.
     */
    public Product(final int id, final String name, final int weight)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    /**
     * Get the name of the product.
     *
     * @return The product name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the weight of the product.
     *
     * @return The product weight.
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Get the unique ID of the product.
     *
     * @return The product ID.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return A string in the format "Product{id, name, weight}".
     */
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    /**
     * Compares this product to another object for equality.
     *
     * @param o The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(final Object o)
    {
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        return Objects.equals(id, product.id)
                && Objects.equals(weight, product.weight)
                && Objects.equals(name, product.name);
    }

    /**
     * Generates a hash code for the product.
     *
     * @return The hash code.
     */
    public int hashCode()
    {
        return Objects.hash(id, name, weight);
    }
}
