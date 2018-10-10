## Sorted Array Collection
> Dale, Joyce, Weems (4th) p342 #26

Add the following methods to the `SortedArrayCollection` class, and create a 
test driver for each to show that they work correctly. Code each of these methods by 
accessing the internal variables of the `SortedArrayCollection`, not by calling 
the previously defined methods of the class.  
    1. `String toString()` creates and returns a string that correctly represents the 
current collection. Such a method could prove useful for testing and debugging 
the class and for testing and debugging applications that use the class. Assume 
each stored element already provides its own reasonable `toString` method.  
    2. `T smallest()` returns null if the collection is empty, otherwise returns the 
smallest element of the collection.  
    3. `int greater(T element)` returns a count of the number of  elements e in the  
collection that are greater than element, that is such that `e.compareTo
(element)` is > 0.  
    4. `SortedArrayCollection<T> combine(SortedArrayCollection<T> 
other)` creates and returns a new `SortedArrayCollection` object that is a 
combination of this object and the argument object.  