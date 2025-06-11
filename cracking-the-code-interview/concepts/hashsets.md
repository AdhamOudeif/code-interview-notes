# Hashsets and Hashmaps

Great question: **`HashSet` vs `HashMap`** — both are based on **hash tables** but are used for different purposes.

Let’s break it down clearly with comparisons, examples, and internals:

---

## 🔍 Quick Summary:

| Feature              | `HashSet<E>`                     | `HashMap<K, V>`                                 |
| -------------------- | -------------------------------- | ----------------------------------------------- |
| Purpose              | Store **unique values only**     | Store **key-value pairs**                       |
| Underlying structure | Backed by a `HashMap<E, Object>` | Backed by a hash table of entries (key → value) |
| Allows duplicates?   | ❌ No                             | ✅ Keys must be unique, values can duplicate     |
| Stores what?         | Just **values**                  | **Keys** (must be unique) and their **values**  |
| Syntax               | `set.add("a")`                   | `map.put("a", 1)`                               |
| Typical usage        | Checking if an item exists       | Associating values with keys                    |

---

## 🧪 Example:

### ✅ HashSet Example – Uniqueness Check:

```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");
set.add("apple");  // ignored because already exists

System.out.println(set);  // Output: [apple, banana]
```

### ✅ HashMap Example – Key-Value Pair:

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 2);
map.put("banana", 3);
map.put("apple", 5);  // Overwrites previous value

System.out.println(map);  // Output: {apple=5, banana=3}
```

---

## 🧠 Internals:

### `HashSet<E>` Internally:

```java
private transient HashMap<E,Object> map;
private static final Object PRESENT = new Object();
```

When you do:

```java
set.add("apple");
```

It actually does:

```java
map.put("apple", PRESENT);
```

So it just stores your element as a **key** with a **dummy constant value**.

---

## 📦 Use Cases:

| Use Case                           | Use `HashSet` | Use `HashMap`              |
| ---------------------------------- | ------------- | -------------------------- |
| Check for duplicates in a list     | ✅             | ❌ (unnecessary complexity) |
| Count frequency of elements        | ❌             | ✅ `map.put(x, count++)`    |
| Store unique usernames             | ✅             | ❌                          |
| Cache values with fast lookup      | ❌             | ✅                          |
| Store configurations (key → value) | ❌             | ✅                          |

---

## 🧠 OOP Insight:

* `HashSet` is a **specialized** version of `HashMap` when you don’t need to associate values.
* Both implement interfaces from Java’s Collection framework:

  * `HashSet` implements `Set`
  * `HashMap` implements `Map`

---

In Java:

---

## ✅ `HashMap<K, V>` → Access by **key**

A `HashMap` stores **key-value pairs**, like a dictionary.

### Example:

```java
Map<String, Integer> map = new HashMap<>();
map.put("apple", 3);
map.put("banana", 5);

// Access value by key
System.out.println(map.get("apple"));  // Output: 3
```

> 💡 You **cannot** access a `HashMap` by index (like `map.get(0)`) because it’s **unordered**.

---

## ✅ `HashSet<E>` → No key or index access

A `HashSet` stores **only unique values**, with no order and no key-value mapping.

### Example:

```java
Set<String> set = new HashSet<>();
set.add("apple");
set.add("banana");

// You cannot do set.get(0); // ❌ No index access
// Instead, you can loop:
for (String item : set) {
    System.out.println(item);
}
```

> 💡 You use `HashSet` when you only care about **existence**, not order or mapping.

---

## 🔁 Summary

| Structure | Access Method    | Example             |
| --------- | ---------------- | ------------------- |
| `HashMap` | By **key**       | `map.get("apple")`  |
| `HashSet` | No direct access | Use `for-each` loop |



