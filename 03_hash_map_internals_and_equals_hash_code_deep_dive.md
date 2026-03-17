# 📘 HashMap Internals + equals()/hashCode() Failure Demonstration — Industry-Grade Deep Dive

---

# 1️⃣ Why This Topic Separates Juniors from Seniors

If you override `equals()` incorrectly, your code may:

- Randomly fail lookups
- Leak memory in caches
- Break deduplication
- Corrupt sets

And the worst part?

The code compiles.
Tests may even pass.

Understanding `HashMap` internally is mandatory for professional Java work.

---

# 2️⃣ Core Structure of HashMap (JDK 8+)

Internally, `HashMap` is:

- An array of buckets (`Node<K,V>[] table`)
- Each bucket holds either:
  - A linked list of nodes
  - Or a red-black tree (after threshold)

Conceptually:

```
index → bucket → Node → Node → Node
```

Each Node contains:

- final int hash
- final K key
- V value
- Node<K,V> next

---

# 3️⃣ How put() Actually Works

When you call:

```java
map.put(key, value);
```

Steps:

1. Compute `hash = spread(key.hashCode())`
2. Determine index:
   
   ```
   index = (n - 1) & hash
   ```

   where `n` = table length (power of 2)

3. If bucket empty → insert
4. If collision →
   - Traverse linked list
   - If equal key found → replace value
   - Else append node

If bucket size exceeds 8 and table >= 64 → convert to red-black tree.

---

# 4️⃣ Load Factor and Resizing

Default load factor = 0.75

Resize condition:

```
size > capacity * loadFactor
```

Default capacity = 16
Threshold = 16 × 0.75 = 12

When exceeded:

- Capacity doubles
- All entries rehashed

Resizing is expensive.
Proper sizing prevents performance degradation.

---

# 5️⃣ Treeification (Collision Optimization)

Before Java 8:
Collisions formed long linked lists → O(n)

Since Java 8:

If a bucket exceeds 8 nodes:

- Converted into red-black tree
- Lookup becomes O(log n)

But only if table size >= 64.
Otherwise resizing preferred.

This prevents hash collision attacks.

---

# 6️⃣ The equals()/hashCode() Contract

Two rules:

1. If `a.equals(b)` is true → `a.hashCode() == b.hashCode()` must be true
2. If `a.hashCode() != b.hashCode()` → equals() must return false

Breaking rule #1 corrupts hash-based collections.

---

# 7️⃣ Real Failure Demonstration

## Broken Implementation

```java
class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person p)) return false;
        return name.equals(p.name);
    }
}
```

`hashCode()` NOT overridden.

---

## What Happens Internally

```java
Map<Person, String> map = new HashMap<>();

map.put(new Person("Alice"), "Engineer");

map.get(new Person("Alice"));
```

Step-by-step:

1. First Person("Alice")
   - hashCode() from Object → identity-based
   - Suppose hash = 12345
   - Stored in bucket X

2. Second Person("Alice")
   - New object → different identity hash
   - Suppose hash = 67890
   - Maps to bucket Y

3. equals() never even checked

Result: returns null.

The object appears missing.

Map is logically corrupted.

---

# 8️⃣ Why equals() Alone Is Useless in HashMap

HashMap lookup flow:

1. Compute hash
2. Find bucket by hash
3. Only inside bucket → compare using equals()

If hash differs, equals() is irrelevant.

This is why overriding equals() without hashCode() is catastrophic.

---

# 9️⃣ Subtle Failure: Mutable Keys

Even worse case:

```java
class User {
    String email;

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return email.equals(((User)o).email);
    }
}
```

```java
User u = new User("a@x.com");
map.put(u, "data");

u.email = "b@x.com";

map.get(u); // null
```

Why?

Hash changed after insertion.

Object is stored in bucket for old hash.
Lookup uses new hash.

Key becomes unreachable.

This causes memory leaks and ghost entries.

---

# 🔟 Correct Implementation Pattern

```java
@Override
public int hashCode() {
    return Objects.hash(name);
}
```

Rules:

- Use same fields in equals() and hashCode()
- Prefer immutable keys
- Never include volatile/mutable fields

---

# 1️⃣1️⃣ Performance Pathology: Poor hashCode()

Bad implementation:

```java
@Override
public int hashCode() {
    return 1;
}
```

All entries land in same bucket.

Before treeification → O(n)
After treeification → O(log n)

Still far slower than O(1).

Hash quality directly affects performance.

---

# 1️⃣2️⃣ Internal Hash Spreading

HashMap uses:

```java
h ^ (h >>> 16)
```

To spread high bits into low bits.

Why?

Index calculation uses low bits.
Poor hash functions often vary only in high bits.

Spreading reduces clustering.

---

# 1️⃣3️⃣ Why Capacity Is Power of Two

Index formula:

```
(n - 1) & hash
```

Bitwise AND is faster than modulo.

Power-of-two capacity ensures uniform distribution.

---

# 1️⃣4️⃣ When Treeification Triggers

Conditions:

- Bucket size ≥ 8
- Table capacity ≥ 64

Else resize instead.

Prevents premature tree creation.

---

# 1️⃣5️⃣ Real Production Failure Example

Scenario:

- Custom cache key
- equals() overridden
- hashCode() forgotten

Symptoms:

- Cache miss rates unexpectedly high
- Memory usage grows
- Duplicate logical keys stored

Root cause:

Broken hashing contract.

These bugs survive for months.

---

# 1️⃣6️⃣ HashSet Is Just HashMap

`HashSet` internally uses:

```
HashMap<E, Object>
```

Value is dummy constant.

So breaking equals/hashCode corrupts sets too.

---

# 1️⃣7️⃣ Industry-Grade Key Design Rules

1. Keys must be immutable
2. equals() and hashCode() must use identical fields
3. Never rely on Object hash
4. Avoid heavy computation in hashCode()
5. Prefer records for value keys (Java 16+)

Example:

```java
public record UserKey(String email, int tenantId) {}
```

Records generate correct equals/hashCode automatically.

---

# 1️⃣8️⃣ Final Summary

HashMap lookup is:

hash → bucket → equals comparison

If hash is wrong, everything breaks.

Understanding this means you:

- Prevent silent data corruption
- Avoid performance degradation
- Design safe domain keys
- Debug cache failures confidently

This is not academic detail.

This i