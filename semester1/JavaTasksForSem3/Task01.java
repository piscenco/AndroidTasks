package com.piscenco;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task01 {

    /**
     * Реализуйте метод, который возвращает новую коллекцию,
     * но уже без дубликатов.
     * Дубликаты, если equals true.
     */
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        // Create a new LinkedHashSet
        Set<T> set = new HashSet();

        // Add the elements to set
        set.addAll(collection);

        // Clear the list
        collection.clear();

        // add the elements of set
        // with no duplicates to the list
        collection.addAll(set);

        // return the list
        return collection;
    }

}