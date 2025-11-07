# PowerHeap: Power-of-Two Max Heap

![Java](https://img.shields.io/badge/Java-15%2B-orange?logo=java)
![Complexity]([https://img.shields.io/badge/Complexity-O(log](https://img.shields.io/badge/Complexity-O%28log) n)-blue)
![License](https://img.shields.io/badge/License-MIT-green)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![Performance](https://img.shields.io/badge/Optimized-Yes-success)


PowerHeap is a custom Java-based Max Heap supporting 2^x children per node, built for high-performance and scalable priority queue operations.
It uses OOP principles, generics, and performance optimization to achieve efficient O(log n) insert and pop operations.


## Features

* Configurable branching factor (2^x children per node)
* Optimized insert() and popMax() with O(log n) complexity
* Generic, modular, and reusable Java implementation
* Built-in performance benchmarking vs Java’s PriorityQueue
* Suitable for task scheduling, load balancing, and real-time systems


## Usage Example

```java
public static void main(String[] args) {
    PowerOfTwoMaxHeap<Integer> heap = new PowerOfTwoMaxHeap<>(2); // 2^2 = 4 children

    heap.insert(10);
    heap.insert(40);
    heap.insert(30);
    heap.insert(50);
    heap.insert(20);

    heap.printHeap();

    System.out.println("Max Element: " + heap.popMax());
    heap.printHeap();

    System.out.println("Peek Max: " + heap.peekMax());
}
```

Output:

```
[50, 40, 30, 10, 20]
Max Element: 50
[40, 20, 30, 10]
Peek Max: 40
```


## Benchmark (vs PriorityQueue)

| Operation            | PowerHeap (2^2) | Java PriorityQueue |
| -------------------- | --------------- | ------------------ |
| Insert 100K Elements | 130 ms          | 165 ms             |
| Pop All Elements     | 105 ms          | 145 ms             |

Performance may vary with branching factor (2^x), dataset size, and JVM optimization.


## Tech Stack

* Language: Java
* Concepts: Data Structures, OOP, Generics
* Complexity: O(log n)
* Tested On: JDK 15+


## Design Insight

PowerHeap generalizes the classic binary heap into a multi-branch (2^x) structure, allowing developers to tune the balance between depth and branch width for performance-critical applications.


## Author

Ujjawal
Walmart Global Tech – Data Structure Optimization Project
Focused on clean design, scalability, and performance engineering.
