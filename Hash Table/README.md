# Introduction

Hash Table is a data structure which organizes data using hash functions in order to support quick insertion and search.

There are two different kinds of hash tables: hash set and hash map.

    The hash set is one of the implementations of a set data structure to store no repeated values.
    The hash map is one of the implementations of a map data structure to store (key, value) pairs.

It is easy to use a hash table with the help of standard template libraries. Most common languages such as Java, C++ and Python support both hash set and hash map.

By choosing a proper hash function, the hash table can achieve wonderful performance in both insertion and search.

In this card, we will answer the following questions:

    What is the principle of a hash table?
    How to design a hash table?
    How to use hash set to solve duplicates related problems?
    How to use hash map to aggregate information by key?
    How to design a proper key when using a hash table?

And we also provide exercises for you to be familiar with hash table.

## Design a Hash Table

In this chapter, we will discuss the underlying principle of the hash table.

After completing this chapter, you should be able to answer the following questions:

    What is the principle of hash table?
    Which factors will influence the choice of hash function and collision resolution strategy?
    Understand the difference between a hash set and a hash map.
    How to design a simple version of hash set and a hash map as in a typical standard template library.
    What is the complexity of insertion and lookup operations?

### The Principle of Hash Table
    
As we mentioned in the introduction,  Hash Table is a data structure which organizes data using hash functions in order to support quick insertion and search. In this article, we will take a look at the principle of the hash table.
 
#### The Principle of Hash Table

The key idea of Hash Table is to use a hash function to map keys to buckets. To be more specific,

    When we insert a new key, the hash function will decide which bucket the key should be assigned and the key will be stored in the corresponding bucket;
    When we want to search for a key, the hash table will use the same hash function to find the corresponding bucket and search only in the specific bucket.
 
#### An Example

In the example, we use y = x % 5 as our hash function. Let's go through the insertion and search strategies using this example:

    Insertion: we parse the keys through the hash function to map them into the corresponding bucket.
        e.g. 1987 is assigned to bucket 2 while 24 is assigned to bucket 4.
    Search: we parse the keys through the same hash function and search only in the specific bucket.
        e.g. if we search for 1987, we will use the same hash function to map 1987 to 2. So we search in bucket 2 and we successfully find out 1987 in that bucket.
        e.g. if we search for 23, will map 23 to 3 and search in bucket 3. And We find out that 23 is not in bucket 3 which means 23 is not in the hash table.

### Keys to Design a Hash Table

There are two essential factors that you should pay attention to when you are going to design a hash table.

#### 1. Hash Function

The hash function is the most important component of a hash table which is used to map the key to a specific bucket. In the example in previous article, we use y = x % 5 as a hash function, where x is the key value and y is the index of the assigned bucket.

The hash function will depend on the range of key values and the number of buckets.

Here are some examples of hash functions:

It is an open problem to design a hash function. The idea is to try to assign the key to the bucket as uniform as you can. Ideally, a perfect hash function will be a one-one mapping between the key and the bucket. However, in most cases a hash function is not perfect and it is a tradeoff between the amount of buckets and the capacity of a bucket.

#### 2. Collision Resolution

Ideally, if our hash function is a perfect one-one mapping, we will not need to handle collisions. Unfortunately, in most cases, collisions are almost inevitable. For instance, in our previous hash function (y = x % 5), both 1987 and 2 are assigned to bucket 2. That is a collision.

A collision resolution algorithm should solve the following questions:

 How to organize the values in the same bucket?
 What if too many values are assigned to the same bucket?
 How to search a target value in a specific bucket?

These questions are related to the capacity of the bucket and the number of keys which might be mapped into the same bucket according to our hash function.

Let's assume that the bucket, which holds the maximum number of keys, has N keys.

Typically, if N is constant and small, we can simply use an array to store keys in the same bucket. If N is variable or large, we might need to use height-balanced binary search tree instead.

#### Exercise

By now, you should be able to implement a basic hash table. We provide the exercise for you to implement a hash set and a hash map. Read the requirement, determine your hash function and solve the collision if needed. 

 If you are not familiar with the concepts of hash set and hash map, you can go back to the introduction part to find out the answer.

Insertion and search are two basic operations in a hash table.

Besides, there are operations which are based on these two operations. For example, when we remove an element, we will first search the element and then remove the element from the corresponding position if the element exists.

### [Design HashSet](Design%20HashSet.java).
### [Design HashMap](Design%20HashMap.java).

### Complexity Analysis - Hash Table

In this article, we are going to discuss the performance of hash table.

#### Complexity Analysis

If there are M keys in total, we can achieve the space complexity of O(M) easily when using a hash table.

However, you might have noticed that the time complexity of hash table has a strong relationship with the design.

Most of us might have used an array in each bucket to store values in the same bucket. Ideally, the bucket size is small enough to be regarded as a constant. The time complexity of both insertion and search will be O(1).

But in the worst case, the maximum bucket size will be N. And the time complexity will be O(1) for insertion but O(N) for search.
 
#### The Principle of Built-in Hash Table

The typical design of built-in hash table is:

     The key value can be any hashable type. And a value which belongs to a hashable type will have a hashcode. This code will be used in the mapping function to get the bucket index.
     Each bucket contains an array to store all the values in the same bucket initially.
     If there are too many values in the same bucket, these values will be maintained in a height-balanced binary search tree instead.

The average time complexity of both insertion and search is still O(1). And the time complexity in the worst case is O(logN) for both insertion and search by using height-balanced BST. It is a trade-off between insertion and search.

## Practical Application - Hash Set

In the previous chapter, we talked about how to design a hash table and the great performance of insertion and search in a hash table.

From this chapter on, we will focus on the practical applications.

In this chapter, we are going to talk about how to use the hash set with the help of standard template libraries and when we should use a hash set.

### Hash Set - Usage

The hash set is one of the implementations of a set which is a data structure to store no repeated values. 

We provide an example of using the hash set in Java, C++ and Python. If you are not familiar with the usage of the hash set, it will be helpful to go through the example.

```C++
#include <unordered_set>                // 0. include the library

int main() {
    // 1. initialize a hash set
    unordered_set<int> hashset;   
    // 2. insert a new key
    hashset.insert(3);
    hashset.insert(2);
    hashset.insert(1);
    // 3. delete a key
    hashset.erase(2);
    // 4. check if the key is in the hash set
    if (hashset.count(2) <= 0) {
        cout << "Key 2 is not in the hash set." << endl;
    }
    // 5. get the size of the hash set
    cout << "The size of hash set is: " << hashset.size() << endl; 
    // 6. iterate the hash set
    for (auto it = hashset.begin(); it != hashset.end(); ++it) {
        cout << (*it) << " ";
    }
    cout << "are in the hash set." << endl;
    // 7. clear the hash set
    hashset.clear();
    // 8. check if the hash set is empty
    if (hashset.empty()) {
        cout << "hash set is empty now!" << endl;
    }
}
```

```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();     
        // 2. add a new key
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);
        // 3. remove the key
        hashSet.remove(2);        
        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }
        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());     
        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");
        // 7. clear the hash set
        hashSet.clear();
        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }
    }
}
```

```Python
# 1. initialize the hash set
hashset = set() 
# 2. add a new key
hashset.add(3)
hashset.add(2)
hashset.add(1)
# 3. remove a key
hashset.remove(2)
# 4. check if the key is in the hash set
if (2 not in hashset):
    print("Key 2 is not in the hash set.")
# 5. get the size of the hash set
print("Size of hashset is:", len(hashset)) 
# 6. iterate the hash set
for x in hashset:
    print(x, end=" ")
print("are in the hash set.")
# 7. clear the hash set
hashset.clear()                         
print("Size of hashset:", len(hashset))
```

### Find Duplicates By Hash Set

As we know, it is easy and effective to insert a new value and check if a value is in a hash set or not.

Therefore, typically, a hash set is used to check if a value has ever appeared or not.
 
#### An Example

Let's look at an example:

    Given an array of integers, find if the array contains any duplicates. 

This is a typical problem which can be solved by a hash set.

You can simply iterate each value and insert the value into the set. If a value has already been in the hash set, there is a duplicate.

#### Template

Here we provide a template for you to solve this kind of problems:

```C++
/*
 * Template for using hash set to find duplicates.
 */
bool findDuplicates(vector<Type>& keys) {
    // Replace Type with actual type of your key
    unordered_set<Type> hashset;
    for (Type key : keys) {
        if (hashset.count(key) > 0) {
            return true;
        }
        hashset.insert(key);
    }
    return false;
}
```

```Java
/*
 * Template for using hash set to find duplicates.
 */
boolean findDuplicates(List<Type>& keys) {
    // Replace Type with actual type of your key
    Set<Type> hashset = new HashSet<>();
    for (Type key : keys) {
        if (hashset.contains(key)) {
            return true;
        }
        hashset.insert(key);
    }
    return false;
}

```

### [Contains Duplicate](../Easy%20Collection/Array/Contains%20Duplicate.java)

### [Single Number](../Easy%20Collection/Array/Single%20Number.java)

### [Happy Number](Medium%20Collection/Math/Happy%20Number.java