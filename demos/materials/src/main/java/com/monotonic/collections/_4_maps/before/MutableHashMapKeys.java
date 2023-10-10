package com.monotonic.collections._4_maps.before;

import java.util.HashMap;
import java.util.Objects;

/**
 * Demonstrates the behavior of mutable objects as keys in a HashMap.
 */
public class MutableHashMapKeys
{
    public static void main(String[] args)
    {
        // Create a HashMap with mutable keys.
        var brokenMap = new HashMap<MutableString, String>();

        var value = "abc";

        // Create a mutable key and associate it with a value in the HashMap.
        var key = new MutableString(value);
        brokenMap.put(key, value);

        // Print the value associated with the key.
        System.out.println(brokenMap.get(key));
        // Print the contents of the HashMap.
        System.out.println(brokenMap);

        // Modify the mutable key.
        key.set("def");

        // Print the value associated with the modified key (which may be unexpected).
        System.out.println(brokenMap.get(key));
        // Print the contents of the HashMap (which may also be unexpected).
        System.out.println(brokenMap);
    }

    /**
     * A mutable string class that can be used as keys in a HashMap.
     */
    private static class MutableString
    {
        private String value;

        public MutableString(final String value)
        {
            set(value);
        }

        /**
         * Get the current value of the mutable string.
         *
         * @return The current string value.
         */
        public String get()
        {
            return value;
        }

        /**
         * Set the value of the mutable string.
         *
         * @param value The new string value.
         */
        public void set(final String value)
        {
            Objects.requireNonNull(value);
            this.value = value;
        }

        /**
         * Compare this mutable string to another object for equality.
         *
         * @param o The object to compare.
         * @return True if the objects are equal, false otherwise.
         */
        public boolean equals(final Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final MutableString that = (MutableString) o;

            return value.equals(that.value);
        }

        /**
         * Generate a hash code for this mutable string.
         *
         * @return The hash code.
         */
        public int hashCode()
        {
            return value.hashCode();
        }

        /**
         * Get a string representation of the mutable string.
         *
         * @return The string value.
         */
        public String toString()
        {
            return value;
        }
    }
}
