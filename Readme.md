Data Structures in Java Collections
Data structures in Java Collections provide functionalities like ordering, pairing, and ensuring uniqueness of elements. The Java Collections Framework is mainly categorized into interfaces and their corresponding implementations.

Interfaces
Interfaces in the Collections Framework define various types of data structures and their functional characteristics. When using them as a variable type, it is common to have a popular implementation that backs the interface. Here are the primary interfaces:

List: Represents a collection that has an order and can contain duplicate elements.
Set: Represents a collection of unique elements.
SortedSet: A Set that maintains its elements in a sorted order.
Queue: Represents a collection designed for holding elements prior to processing.
Deque: Represents a double-ended queue, which can add/remove elements from both ends.
Map: Represents a collection of key-value pairs.
SortedMap: A Map that maintains its key-value pairs in a sorted order based on keys.
Implementations
Each interface has one or more concrete implementations. These implementations determine the performance characteristics of the data structures and are concrete and instantiable:

List: ArrayList, LinkedList
Set: HashSet
SortedSet: TreeSet
Queue: PriorityQueue
Deque: LinkedList, ArrayDeque
Map: HashMap
SortedMap: TreeMap
Choosing the Right Data Structure
If elements are keyed, use Map/SortedMap.
If the order is important, opt for SortedMap.
For uniqueness, go for Set/SortedSet.
If order matters, SortedSet is the choice.
If neither uniqueness nor insertion order matters, use List.
For uniqueness and insertion order, choose Deque.
Working with Iterables
Iterables provide several methods:

remove(): Removes an element.
removeIf(): Removes elements based on a condition.
contains(): Checks if an element is present.
removeAll(): Removes all elements that are also contained in another collection.
sort(): Sorts the elements based on their natural order or a comparator.
For creating immutable values, Lists provide static factory methods:

copyOf(): Returns an immutable List containing the elements of the given collection.
of(): Returns an immutable List containing its arguments.
Iterating over Collections
Java Collections provide an iterator class, allowing us to loop over a collection. Lists, being collections with index/iteration order, offer methods like indexOf(). To replace an element in a List:

Get the index of the element with indexOf().
Set the new element at the position of the former element using .set(position, obj).
sublist: Used to get a portion of the list based on the start and end index.

Maps
Maps are collections of key-value pairs. The main methods include put(), putAll(), get(), containsKey(), containsValue(), and remove().

For creating immutable Maps:

Map.of(): Returns an immutable map.
Map.ofEntries(Map.entry()): Returns an immutable map containing the given entries.
Map.copyOf(): Returns an immutable map containing the entries of the given map.
keySet(): Returns a Set of the keys contained in the map.
values(): Returns a Collection of the values contained in the map.
forEach(k, v -> ): Allows iterating over the key-value pairs.

Sets
Sets represent collections of distinct elements without duplicates. Always ensure the objects used in a set adhere to the hashCode and equals contract. HashSet is a general-purpose implementation, while TreeSet offers sorted and navigable features.


Sets in Java Collections
Sets in Java Collections are designed to store collections of distinct elements, ensuring that there are no duplicates. A Set does not allow duplicate elements, which makes it useful when you want to have a collection that ensures uniqueness.

Characteristics of Sets:
No Duplicates: Sets ensure that there are no duplicate elements. This is enforced by the hashCode and equals contract. When an element is added to a set, its hashCode is computed and checked against existing elements. If an element with the same hash code and deemed equal (based on the equals method) exists, the new element will not be added.

Order: Some implementations of the Set interface maintain order (either insertion order or a defined order), while others do not.

Null Values: Most Set implementations allow one null element, but this can vary based on the specific implementation.

Primary Implementations:
HashSet: This is the most common implementation of the Set interface. It uses a hash table to store elements, which gives it constant-time performance for basic operations (add, remove, contains). However, it doesn't guarantee any specific order of elements.

LinkedHashSet: Extends HashSet but also maintains a linked list of entries. This ensures that elements are ordered by their insertion order. It's slightly slower than HashSet but is useful when you want to maintain the order of elements.

TreeSet: This is a NavigableSet implemented as a red-black tree. Elements are stored in a sorted order (natural order or using a provided comparator). It offers log(n) time for common operations. Apart from basic Set operations, TreeSet provides several methods to navigate the set, such as first(), last(), lower(), higher(), etc.

Important Considerations:
Hashcode/Equals Contract: Always ensure that objects used in a set have properly overridden hashCode and equals methods. Breaking this contract can lead to unexpected behavior, such as allowing duplicate elements in the set.

Value-Based vs. Reference-Based Equality: By default, objects check for reference-based equality. If you want value-based equality, you need to override the equals method. For example, two different Person objects with the same name and age should be considered equal based on their values.

Natural Ordering: If you're using a TreeSet, the elements should either implement the Comparable interface for natural ordering or you should provide a Comparator for custom ordering.

Performance: While HashSet provides constant-time performance, TreeSet offers log(n) time for most operations due to its tree structure.

Use Cases:

Use HashSet when you need a general-purpose set without any ordering.
Use LinkedHashSet when insertion order is important.
Use TreeSet when you need a sorted set or when you want to leverage navigable set features.
In summary, the Set interface in Java Collections provides a powerful way to deal with unique elements. Choosing the right Set implementation depends on the specific requirements of order, performance, and functionality.

Conclusion
In Java Collections, interfaces define the behavior, and their implementations determine the performance. Understanding the functional characteristics and performance implications of each data structure is crucial. Always ensure the objects used in collections follow the hashCode and equals contract for consistent behavior.




data structures proivde ordering, pairs, uniqueness 

interfaces 

multiple data structures
functional charactersistics 
prefer as a vraible type 
often has popular implementation 

vs 

implemenstatio

specific data structure 
performance characteristics 
concrete and instantiable 

List - ArrayList/LinkedList

Set - HashSet
SortedSet - TreeSet 

Queue - PriorityQueue 
Deque - LinkedLsit & ARrayDeque 

Map - HashMap | SortedMap / TreeMap

Elements keyed -> Map/Sorted MAp
Order important -> Sorted Map

Unique? Set/Sorted Set
Order imporant - Sorted Set 

Unqiueness/insertion order doesn't matter - List
Unique + Insertion orders matter - Deque 

Iterables - 

remove
removeIf
contains 
removeAll
sort()

list static factory methods for immutable values 
copyOf()
Of() - overloads 0-10 arguments 

iterator class that allows us to loop over a collection 

Lists - collections with index/iteration order 

assertThat() 

indexOf()

replace 
- get index of element
- set new element at position of former element
- return true

.set(position, obj)


sublist 

Interfaces define behavior 

Implementations determine performance 

ArrayList's sympathetic to CPU Cache 

Linked list - 

headnode tail node 

worse performance 

Avoid vector / stack - 

Maps collections of pairs 

Key -> Value 

adding and replacing 

put()
putAll()
get()
containsKey()
containsValue()
remove()


Map.entry()
Map.of()
Map.ofEntries(Map.entry())

Map.copyOf()

Map is the only collection that doesn't extend or implement the Collection
interface 

keySet()
values() 
forEach(k, v -> )
setValue()
.remove()
 

getOrDefault(value, defaultValue)
computeIfAbsent()
putIfAbsent()
computeIfPresent()
compute() 
merge()

HasHmap - good general purpose implementation
Tree map- defines sort order and adds functionality 

TM - key elements have a sort order 
Red.Black tree - balanced binary tree 
Navigable and sorted - provides functionality that HashMap does not 

LinkedHashMap - useful for implementing sized based cache's 

Maintains order - either insertion or access 

removeEldestEntry - sublclass and override method in order to control cache

Identity HashMap - useful for serialisation or graphs 

Faster & Lower Memory 
Low Collision Likelihood 

Vioaltes Map Contract - 

Mostly use hashmapp 
avoid coupling map to keys 

WeakHashMap - useful for a memory bounded cache 

keys have weak references, can be collected if nothing else references them 

Entries can be removed after the key is collected 

EnumMap
Keys are Enums - Faster and Lower Memory Usage 

Bitset Implementation - only a single long if < 63 elements

Keys rely on having the same hashcode 

Whatever types you use as the keys in your map, you wnat to be immutable objects 

always return the same hashcode & equals methods as they strat with 

Sets are collections of distinct elements. There are no duplicates 

Set removes need to have to removeduplicates manually 

Hashcode / equals contract 

breaking ocntract can get duplicate code 

Equality - value-base / reference-based. Reference-based just needs  to inherit equals from Object 

Value based requires a custom equals method 

always use the same fields as equals 

uses hashCode and looks up location 

HashSet is good general purpose implementation 

TreeSet - red/black binary tree with defined sort order 

Provides extra features - implements sortedset and navidgable set 

Linked hash set 

When: copying set to modify
deduping list or queue 

Maintains order -only insertion 

Sorted set - defines an order 
No indexes, but sobset views possible 

first()
last()

tailSet, headSet(), subSet()

Navigable set - extends sorted set 
Provides a way to move through the order 
lower()
higher()

floor()
ceiling() 

pollFist(); 
pollLast(); 

NavigableSet implemented by TreeSet 
