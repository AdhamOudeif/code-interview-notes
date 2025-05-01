## Interview Prep Chapters
#### MUST KNOW Data Structures and Algorithms:
![image](https://github.com/user-attachments/assets/7664f471-9629-4b3d-952a-1be00d59ffbb)
#### Powers of Two Table:
![image](https://github.com/user-attachments/assets/d46101d3-788d-41b0-8a24-e681e04ca3a7)
________________________________________
## Optimize and Solve Techniques
### BUD
- **Bottlenecks:** A part of your algorithm that slows down overall runtime, try to reduce this. Example: O(N log N) -> O(N)
- **Unecessary Work:** Usually repeated steps that can be reduced to one. Example: for loop for a,b,c,d can be reduced to for loop for a,b and calculate c,d with formula
- **Duplicated Work:** Remove or consolidate any duplicated work

### DIY
Do it yourself! Try a real life example of the problem and see how you intuitively solve it. For example how would you find peter smiths test in a huge stack of papers? How would you find S permuations in the string B? Then try to make an algorithim of it

### Simplify and Generalize
First we simplify or tweak some 
constraint, such as the data type. Then, we solve this new simplified version of the problem. Finally, once we 
have an algorithm for the simplified problem, we try to adapt it for the more complex version

### Base Case and Build
Solve for the most simple case, such as n=1, then try to build up from there

### Data Structure Brainstorm
We can simply run through a list of data structures and 
try to apply each one. This approach is useful because solving a problem may be trivial once it occurs to us 
to use, say, a tree. 

### Best Conceivable Runtime
The best conceivable runtime is, literally, the best runtime you could conceive of a solution to a problem 
having. You can easily prove that there is no way you could beat the BCR. 
For example, suppose you want to compute the number of elements that two arrays (of length A and B) 
have in common. You immediately know that you can't do that in better than O ( A + B) time because you 
have to "touch" each element in each array. O(A + B) is the BCR. 
Or, suppose you want to print all pairs of values within an array. You know you can't do that in better than 
0 ( N2) time because there are N^2 pairs to print. 
