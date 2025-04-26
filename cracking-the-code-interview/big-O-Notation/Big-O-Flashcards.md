Here’s a **🔥 1-minute Big O guessing cheat sheet** you can use when you look at any algorithm:

---

# 🧠 Big O Cheat Sheet

| If you see...                          | It's probably...  | Why                                           |
|-----------------------------------------|-------------------|-----------------------------------------------|
| A **single simple loop** over data      | **O(n)**           | One touch per element                        |
| A **loop inside a loop** (nested)       | **O(n²)**          | Touching every pair of elements              |
| **Divide and Conquer** (split in half) + small work | **O(log n)**  | Cutting problem in half each time            |
| **Divide and Conquer** + **touch all elements** at each split | **O(n log n)** | Work across whole array each level |
| A **fixed number of steps** (no matter the size of input) | **O(1)**      | Constant time — doesn’t depend on `n`        |
| **Two separate loops** (not nested)     | **O(n + n) = O(n)**| Just twice as much linear work               |
| **Multiple inputs** (like m and n)      | **O(m + n)** or **O(m * n)** | Depends if loops are nested or separate |
| **Recursion with all branches**      | **O(2^n)** | Each element can be included/excluded (exponential growth) |

---

# 🛠️ Quick examples

- Simple for loop? → `O(n)`
- Two nested for loops? → `O(n²)`
- Binary search? → `O(log n)`
- Merge sort? → `O(n log n)`
- Hash table get/insert? → `O(1)` (most cases)
- Two seperate arrays processed -> `O(n + m)`
- Matrix Traversal (Grid problems) -> `O(n x m)`
- Subset Generateion -> `O(2^n)`

---

# 🚀 10-second mental steps when you see a new problem:

1. **Am I looping once?** ➔ O(n)
2. **Am I looping inside another loop?** ➔ O(n²)
3. **Am I cutting the input down?** ➔ O(log n)
4. **Am I cutting input AND doing work across everything?** ➔ O(n log n)
5. **Am I doing stuff unrelated to size?** ➔ O(1)

---

# 📈 Visual (Mental Map)

```
Touch each item once ➔ O(n)
Touch every pair ➔ O(n²)
Cut problem size each step ➔ O(log n)
Cut and touch everything ➔ O(n log n)
Constant small steps ➔ O(1)
Work between two inputs ➔ O(n × m)
Branch out exponentially ➔ O(2ⁿ)
```

---

✅ If you can internalize *just this*, you’ll be able to guess **90%** of Big O complexities when practicing LeetCode without overthinking it.
