# minHeap
This project is to show how to implement a min-heap data structure in Java.

The elements of this MinHeap is int. 
  It uses an arry to store the binary tree structure. The index is from 1, not
  from 0. Any element in the array index by i:
     The parent of i-th element is: i/2;
     The left child of the i-th element is: i*2;
     The right child of the i-th element is: i*2+1;
     
     
     
 # NOTICE
  1. If other type of elements want to be processed, two things need to do:
      (1) declear the array of m_container of the desired type array;
      (2) change the compare statements in add(), buildUp(), and sinkDown();
  2. This is a minHeap, which means that the top the elements is the smallest
      in the collection. It can be used to find the Top-K values.

  3. It should be also noted that Java already has an class of min/max-Heap: java.util.PriorityQueue.
       https://docs.oracle.com/javase/7/docs/api/index.html?overview-summary.html

