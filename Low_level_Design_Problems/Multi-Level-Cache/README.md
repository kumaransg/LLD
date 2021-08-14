# Multi-Level-Cache
Multi Level Cache - Coded during a 2 Hour Live Coding Interview (No Changes)

Cache Manager

Design and implement a Multiple Level Cache Management System with N levels, say:
L1 -> L2 -> L3 … -> LN. 

Each layer will store Key-Value pairs of data. Both KEY and VALUE are of type String. L1 is the top most layer with most priority. LN is the last layer with least priority. You can choose any replacement policy for the cache.

You are given following details about the system:
1. The number of levels of cache.
2. The capacity of each layer, i.e. number of elements that can be stored.
3. Read time of each layer.
4. Write time for each layer.

This Cache system should be able to perform following operations:

1. READ KEY Operation

Read will start from L1 level. If KEY is found at this layer, then this value will be returned. If KEY is not found at this layer, then try to read from the next layer. Keep doing this until the value of KEY is found at any level or the last level has been reached. If the value of KEY is found at any level, then this VALUE should also be written into all previous levels of cache which have higher priority than this level. 

Total Read time is the sum of Read time of all levels where READ operation was attempted and Write time of all levels where WRITE operation was attempted. You have to print the VALUE of KEY and total time taken to read it.

2. WRITE KEY Operation

Writes will start from L1 level. Write the value of KEY at this level and all levels below it. If at any level, the  value of KEY is the same as the given VALUE then don’t write again and return. 

Total Write time is the sum of WRITE time of all levels where WRITE operation was attempted and Read time of levels where READ operation was attempted. You have to print total time taken to write this KEY-VALUE information.

3. STAT Operation ( Bonus point / Optional )

Stat operations prints three information:
a) What is the current usage of each level of cache, i.e. Filled / Total size
b) What is the average read time of this Multi-Level Cache System for the last 10 READ operations?
c) What is the average write time of this Multi-Level Cache System for the last 10 WRITE operations?
