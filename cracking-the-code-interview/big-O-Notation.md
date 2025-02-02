## Big O Notation
Big O (Asymptotic Runtime) is the language and metric we use to describe the efficiency of algorithms.
- Note: _Asymptotic_ in math means a function approaches a certain value or curve arbitrarily closely as a variable (usually "x") tends towards infinity, essentially getting closer and closer without ever actually reaching it.

*Analogy:* You need to send a 10TB video file to a friend as soon as possible. You can do it in three ways:
- Electronic Transfer: O(n) _The Bigger the file, n, the longer it would take_
- Airplane/Drive Transfer: O(1) _File size will not make a difference at all_
  
![image](https://github.com/user-attachments/assets/27112669-c514-474e-8264-51de4f6bf914)

There is no fixed list of possible runtimes. For example you can have a runtime of O(whp) for painting a fence; width, height, paint layers.

![image](https://github.com/user-attachments/assets/1914b13c-7e7d-4cd2-ba46-60999839b591)


1. **O(1)**  
   This is the constant time notation. The runtime remains steady regardless of input size. For example, accessing an element in an array by index and inserting/deleting an element in a hash table.
   
   ![image](https://github.com/user-attachments/assets/1d4946ad-6183-4419-b431-5e42d56453f2)


3. **O(n)**  
   Linear time notation. The runtime grows in direct proportion to the input size. For example, finding the max or min element in an unsorted array.

   ![image](https://github.com/user-attachments/assets/5ceecc5b-ac62-4496-ba1a-e1a056739ffb)


5. **O(log n)**  
   Logarithmic time notation. The runtime increases slowly as the input grows. For example, a binary search on a sorted array and operations on balanced binary search trees.

   ![image](https://github.com/user-attachments/assets/c168ace2-7a7d-4ee9-ac0a-9f37018b995d)


7. **O(n²)**  
   Quadratic time notation. The runtime grows exponentially with input size. For example, simple sorting algorithms like bubble sort, insertion sort, and selection sort.

   ![image](https://github.com/user-attachments/assets/ce3ec6d6-6354-46ba-a15e-8f2a3fc4df9b)


9. **O(n³)**  
   Cubic time notation. The runtime escalates rapidly as the input size increases. For example, multiplying two dense matrices using the naive algorithm.

   ![image](https://github.com/user-attachments/assets/9a448e6e-a6ac-42cc-a693-7690cbd43145)


11. **O(n log n)**  
   Linearithmic time notation. This is a blend of linear and logarithmic growth. For example, efficient sorting algorithms like merge sort, quick sort, and heap sort.

![image](https://github.com/user-attachments/assets/cc276156-fb82-4c1b-a8f5-8903df42ac79)


13. **O(2ⁿ)**  
   Exponential time notation. The runtime doubles with each new input element. For example, recursive algorithms solve problems by dividing them into multiple subproblems.

![image](https://github.com/user-attachments/assets/a4bb43ce-98d9-4d4d-b3ee-074328b6e85a)


15. **O(n!)**  
   Factorial time notation. Runtime skyrockets with input size. For example, permutation-generation problems.

![image](https://github.com/user-attachments/assets/3121d669-c79f-4e03-b91e-3360ad716e50)


17. **O(√n)**  
   Square root time notation. Runtime increases relative to the input’s square root. For example, searching within a range such as the Sieve of Eratosthenes for finding all primes up to n.

![image](https://github.com/user-attachments/assets/eb00bba4-9d5c-492c-9bec-20d352785642)

## Space Complexity
Time is not the only thing that matters in an algorithm, Memory and Space are imporatant too. Space complexity is a parallel concept to time complexity. If we need to create an array of size n, this will 
require 0( n) space. If we need a two-dimensional array of size nxn, this will require O( n^2) space.

![image](https://github.com/user-attachments/assets/1bed2e2a-fb2a-4c40-a7e1-a4a637961a60)

However, n calls =/= O(n) space, because there can be O(n) time complexity but O(1) space complexity. Take The pairSum for example, where you add adjacent elements between 0 and n. 
There will be n calls, but they do not exist simultaneously on the call stack. 

### Extra Note: Call Stacks
The call stack is a special region of memory used by a program to store information about the functions that are currently being executed. 
When a function is called, an entry (called a "stack frame") is added to the call stack. 
This entry contains information like the function's local variables, its parameters, and where to return after the function finishes. 
As functions call other functions, new stack frames are pushed onto the stack, and as they return, those frames are popped off the stack.

In the PairSum example, the calls dont exist simultaneously because each call is sequential, on each return value the stack frame is popped off the stack because the funtion does not need to be
perserved for the next sequence, it just uses the value of the last sequence in the next step of the operation (locked in alien). 

In contrast, if you had a situation where functions called each other recursively (e.g., a function calls itself), 
each recursive call would be stacked on top of the previous one, increasing the space needed on the call stack.

#### Drop the constants:
O(N) can run faster than O(1). O(2N) can be described as O(N).
- O(N2 + N) becomesO(N2). 
- O(N + log N) becomesO(N).
- 0(5*2N + 1000N100 ) becomes0(2N)

In Big O notation, we don't care about exact numbers of operations or constants like 2N because we're focused on the rate of growth as input size increases. 
Both O(N) and O(2N) represent linear growth. The constant factor doesn't change the fact that the time increases linearly with N.

When you see expressions like O(N² + N), the term N is considered less important than N² for large inputs, so we drop it, leaving us with O(N²).
Similarly, for O(N + log N), N dominates log N as N gets larger, so it simplifies to O(N).


O(log x) grows very slowly.
O(N) grows linearly.
O(N²) grows quadratically (which becomes much worse than O(N)).
O(2^x) grows exponentially, which is much worse than O(N²).
O(x!) (factorial time) grows extremely quickly and is much worse than all of the above.

#### Multi-Part Algorithms: Add vs Multiply
Suppose you have an algorithm that has two steps. When do you multiply the runtimes and when do you 
add them? 

![image](https://github.com/user-attachments/assets/3800ca3d-6c9a-44d3-bf8a-2cfea93a643c)

On the left, we do A chunks of work, _then_ B chunks of work. O(A+B)
On the Right, we do B chunks of work _for each_ element in A. O(A*B)

## Amortized Time
ArrayList is an Array that you can dynamically grow with built in methods. Arrays are faster and use less memory due to direct allocation though. 
How does one calculate the runtime of creating an ArrayList from an Array (it will allocate the original arrays elements to the new arrayList). 
If the array contains N elements, then inserting a new element will take O(N) time. Creating a new array of size 2N and copying N elements over.

##### What is Amortized Time?
Amortized time complexity analyzes the average time per operation over a sequence of operations, rather than just the worst-case time of a single operation. This helps provide a more accurate estimate of performance for certain algorithms and data structures.

##### Why Use Amortized Analysis?
Some operations might be costly individually but are rare compared to cheaper operations. Amortized analysis helps show that, on average, the time per operation is still efficient.

##### Example: Dynamic Array (ArrayList in Java)
In an **ArrayList**, adding an element (`add()`) is generally **O(1)**. However, when the internal array reaches capacity, a new, larger array must be allocated, and all elements are copied over, making that insertion **O(n)**. But since this resizing happens infrequently, the **amortized** time complexity remains **O(1)**.

##### Breakdown:
1. Most `add()` operations: **O(1)**
2. Occasional resizing operation: **O(n)**
3. Over a large number of insertions, the **average cost per operation remains O(1)**.

##### Amortized Complexity in Other Data Structures:
- **Stack with Dynamic Array**: `push()` remains **O(1)** amortized despite occasional resizing.
- **HashMap Resizing**: Insertions are typically **O(1)** but can be **O(n)** when resizing occurs.
- **Splay Trees**: Individual operations may be **O(n)**, but over time, the average cost is **O(log n)**.

##### Summary:
Amortized analysis provides a realistic view of an algorithm’s efficiency over time, ensuring that occasional expensive operations don’t skew overall performance estimates.

## Log N Runtimes
The "log" of a number, or logarithm, represents the exponent to which a fixed base number must be raised to produce that number; essentially, it answers the question "how many times must a base number be multiplied by itself to get the given number?"

so how does that relate to Big O? We often see O(log N) in runtimes. Think of a binary search for example, where you compare an element to the middle of a sorted array of N length. If it's equal to the mid point, return, else search on the side that it is greater or less than, and keep doing that until you find the value.

Search for 56 in an N-Element _sorted_ array (fibbonaci sequence): {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 56, 90}
1. compare 56 with 5 -> it's bigger so we search the right side of the array: {8, 13, 21, 34, 56, 90}
2. compare 56 with 21 -> bigger so again we search the right side of the array: {34, 56, 90}
3. compare 56 with 56 -> equal, so return.

We started with N elements, then down to N/2, then N/4 and so on. The *total runtime* is then a matter of how many steps we can take until N becomes 1. In the above example:
N = 12, N= 6, N = 3. So How many steps can we take until N becomes 1 (or on the reverse side, how many times can we multiple 1 by 2 till we get N?)

![image](https://github.com/user-attachments/assets/b3128f92-6c6c-4751-8c71-f268c0fb1311)

### Recursive Runtimes
```
int f(int n){
  if (n <= 1) {
    return 1;
  }
  return f(n - 1) + f(n -1);
}
```
What is the runtime of this code? 

![image](https://github.com/user-attachments/assets/3275eeae-e7fc-442d-a456-2823c63721fa)

2^N+1 - 1 = 15 calls where N = 4 

Remember this pattern, when you have a recursive function that makes multiple calls, the runtime will look like O(branches^depth) where branches = # of times each recursive call branches out. In this case its O(2^N). The space complexity of this will be O(N) , due to the call stack. 




