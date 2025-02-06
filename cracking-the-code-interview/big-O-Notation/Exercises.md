# Big O Analysis Examples

## Example 1
**Code:**
```java
void foo(int[] array) {
    int sum = 0;
    int product = 1;
    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    for (int i = 0; i < array.length; i++) {
        product *= array[i];
    }
    System.out.println(sum + ", " + product);
}
```
**Runtime:** O(N). Even though we iterate twice, it remains O(N).

## Example 2
**Code:**
```java
void printPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[i] + "," + array[j]);
        }
    }
}
```
**Runtime:** O(N²). Nested loops iterate N² times.

## Example 3
**Code:**
```java
void printUnorderedPairs(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = i + 1; j < array.length; j++) {
            System.out.println(array[i] + "," + array[j]);
        }
    }
}
```
**Runtime:** O(N²). Iterates through all pairs where j > i.

## Example 4
**Code:**
```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            if (arrayA[i] < arrayB[j]) {
                System.out.println(arrayA[i] + "," + arrayB[j]);
            }
        }
    }
}
```
**Runtime:** O(ab), where a = arrayA.length and b = arrayB.length.

## Example 5
**Code:**
```java
void printUnorderedPairs(int[] arrayA, int[] arrayB) {
    for (int i = 0; i < arrayA.length; i++) {
        for (int j = 0; j < arrayB.length; j++) {
            for (int k = 0; k < 100000; k++) {
                System.out.println(arrayA[i] + "," + arrayB[j]);
            }
        }
    }
}
```
**Runtime:** O(ab). The constant factor (100,000) is ignored in Big O notation.

## Example 6
**Code:**
```java
void reverse(int[] array) {
    for (int i = 0; i < array.length / 2; i++) {
        int other = array.length - i - 1;
        int temp = array[i];
        array[i] = array[other];
        array[other] = temp;
    }
}
```
**Runtime:** O(N). Iterates through half the array but still O(N).

## Example 7
**Equivalent to O(N)?**
- O(N + P), where P < N → **O(N)** (P is insignificant).
- O(2N) → **O(N)** (constant factors are ignored).
- O(N + log N) → **O(N)** (log N is insignificant).
- O(N + M) → **Not necessarily O(N), depends on M**.

## Example 8
**Sorting Strings and Array:**
- Sorting each string: O(s log s), where s = max string length.
- Sorting the array: O(a log a * s), where a = number of strings.
- **Total Runtime:** O(a * s (log a + log s)).

## Example 9
**Code:**
```java
int sum(Node node) {
    if (node == null) return 0;
    return sum(node.left) + node.value + sum(node.right);
}
```
**Runtime:** O(N). Each node is visited once.

## Example 10
**Code:**
```java
boolean isPrime(int n) {
    for (int x = 2; x * x <= n; x++) {
        if (n % x == 0) return false;
    }
    return true;
}
```
**Runtime:** O(√N). Iterates up to sqrt(n).

## Example 11
**Code:**
```java
int factorial(int n) {
    if (n < 0) return -1;
    else if (n == 0) return 1;
    else return n * factorial(n - 1);
}
```
**Runtime:** O(N). Recursive calls go from n down to 1.

## Example 12
**Code:**
```java
void permutation(String str) {
    permutation(str, "");
}

void permutation(String str, String prefix) {
    if (str.length() == 0) System.out.println(prefix);
    else {
        for (int i = 0; i < str.length(); i++) {
            String rem = str.substring(0, i) + str.substring(i + 1);
            permutation(rem, prefix + str.charAt(i));
        }
    }
}
```
**Runtime:** O(N * N!). Calls are O(N!) and each does O(N) work.

