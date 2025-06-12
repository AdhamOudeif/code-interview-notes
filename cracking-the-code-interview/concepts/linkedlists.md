
---

## 📘 What is a Linked List?

A **Linked List** is a linear data structure where each element (called a **node**) contains:

* The **data** (value)
* A **reference (pointer)** to the **next node**

Unlike arrays, linked lists:

* Don’t need a fixed size
* Allow efficient insertion/removal at head/tail
* Take **O(n)** time to access by index (no direct indexing)

---

## 🧱 Singly Linked List - Basic Node Class

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

---

## 🔁 Creating and Using a Linked List

```java
public class SinglyLinkedList {
    Node head;

    // Insert at end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Print list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Delete node by value
    public void delete(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
```

### 👇 Usage

```java
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList(); // 1 -> 2 -> 3 -> null

        list.delete(2);
        list.printList(); // 1 -> 3 -> null
    }
}
```

---

## 🔄 Doubly Linked List

Each node stores:

* Data
* Pointer to **next**
* Pointer to **previous**

```java
class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode prev;

    DoubleNode(int data) {
        this.data = data;
    }
}
```

```java
public class DoublyLinkedList {
    DoubleNode head;

    // Insert at end
    public void append(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DoubleNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void printForward() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void delete(int key) {
        DoubleNode current = head;
        while (current != null) {
            if (current.data == key) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                return;
            }
            current = current.next;
        }
    }
}
```

---

## 🏃‍♂️ The Runner Technique

Used in problems where one pointer is "faster" than the other.

**Example: Detect Cycle (Floyd’s Algorithm)**

```java
public boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true; // cycle detected
    }
    return false;
}
```

Other examples:

* Find middle node
* Detect loop
* Palindrome check (with stack + runner)

---

## 🌀 Why Linked Lists Work Well With Recursion

Linked lists are naturally **recursive** in structure:

* Each node points to a smaller list (its `.next`)

Example: Recursively print a linked list:

```java
public void printRecursive(Node node) {
    if (node == null) return;
    System.out.print(node.data + " -> ");
    printRecursive(node.next);
}
```

---

## 🧠 Summary Table

| Concept            | Usage                                                   |
| ------------------ | ------------------------------------------------------- |
| `Node` class       | Holds `data` and `next` pointer                         |
| Singly Linked List | Linear structure, one direction                         |
| Doubly Linked List | Forward and backward traversal                          |
| `append()`         | Add node at the end                                     |
| `delete()`         | Remove node by value                                    |
| Runner technique   | One fast/one slow pointer for middle or cycle detection |
| Recursive power    | Naturally lends itself to recursion via `.next`         |

---

