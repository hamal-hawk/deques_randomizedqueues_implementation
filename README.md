# Deque and Randomized Queue Implementation

This project implements two fundamental data structures: a Double-Ended Queue (Deque) and a Randomized Queue, as well as a client program `Permutation.java` to demonstrate the usage of these data structures.


- **Deque**: A double-ended queue that supports adding and removing items from both the front and the back in constant worst-case time, with a memory usage of at most 48n + 192 bytes for n items.
  
- **Randomized Queue**: Similar to a stack or queue but removes items uniformly at random. It supports operations in constant amortized time, with a memory usage of at most 48n + 192 bytes for n items.

- **Permutation Client**: A client program that takes an integer `k` as a command-line argument, reads a sequence of strings from standard input, and prints exactly `k` of them, uniformly at random. Each item from the sequence is printed at most once.
