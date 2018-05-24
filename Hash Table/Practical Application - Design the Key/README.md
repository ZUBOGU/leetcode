# Practical Application - Design the Key

Another problem you might encounter is that when you meet some problems which you thought can be solved by a hash table, you are not able to figure out a proper key.

In this chapter, we are going to solve this problem. We will discuss with some examples, provide some exercise and finally, come to a conclusion to give you some tips to solve some classical problems.

## Design the Key

In the previous problems, the choice of key is comparatively straightforward. Unfortunately, sometimes you have to think it over to design a suitable key when using a hash table.

## An Example

Let's look at an example:

- Given an array of strings, group anagrams together.

As we know, a hash map can perform really well in grouping information by key. But we cannot use the original string as key directly. We have to design a proper key to present the type of anagrams. For instance, there are two strings "eat" and "ate" which should be in the same group. While "eat" and "act" should not be grouped together.

## Solution

Actually, designing a key is to build a mapping relationship by yourself between the original information and the actual key used by hash map. When you design a key, you need to guarantee that:

1. All values belong to the same group will be mapped in the same group.

2. Values which needed to be separated into different groups will not be mapped into the same group.

This process is similar to design a hash function, but here is an essential difference. A hash function satisfies the first rule but might not satisfy the second one. But your mapping function should satisfy both of them.

In the example above, our mapping strategy can be: sort the string and use the sorted string as the key. That is to say, both "eat" and "ate" will be mapped to "aet".

The mapping strategy can be really tricky sometimes. We provide some exercise for you in this chapter and will give a summary after that.

## [Group Anagrams](../../Medium%20Collection/Array%20and%20Strings/Group%20Anagrams.java)

## [Valid Sudoku](../../Easy%20Collection/Array/Valid%20Sudoku.java)

## [Find Duplicate Subtrees](Find%20Duplicate%20Subtrees.java)

## Design the Key - Summary

Here are some takeaways about how to design the key for you.

    When the order of each element in the string/array doesn't matter, you can use the sorted string/array as the key.
    If you only care about the offset of each value, usually the offset from the first value, you can use the offset as the key.
    In a tree, you might want to directly use the TreeNode as key sometimes. But in most cases, the serialization of the subtree might be a better idea.
    In a matrix, you might want to use the row index or the column index as key.
    In a Sudoku, you can combine the row index and the column index to identify which block this element belongs to.
    Sometimes, in a matrix, you might want to aggregate the values in the same diagonal line. 

