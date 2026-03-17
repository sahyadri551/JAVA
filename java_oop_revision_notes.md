# 📘 Java OOP & Core Language Concepts — Detailed Revision Notes

---

# 🔐 Encapsulation

## Definition
Encapsulation is the principle of **hiding internal state** and controlling how that state is accessed or modified.

> Protect invariants. Prevent invalid states.

## How It Is Achieved
- `private` fields
- Controlled getters
- Validating setters
- Immutable fields (`final`)

### Example
```java
private long price;

public void updatePrice(long newPrice) {
    if (newPrice <= 0) {
        throw new IllegalArgumentException("Invalid price");
    }
    this.price = newPrice;
}
```

## Why It Matters
- Prevents invalid object states
- Makes refactoring safe
- Enforces domain rules
- Reduces debugging complexity

---

# 🧬 Inheritance

## Definition
Inheritance allows a class to reuse and extend another class.

```java
abstract class Vehicle { }
class Bicycle extends Vehicle { }
```

Bicycle **is-a** Vehicle.

## When to Use
- True "is-a" relationship
- Shared behavior across subclasses
- Polymorphic usage required

## Avoid When
- You only want code reuse
- Relationship is not conceptual hierarchy

---

# 🎛 enum

## What It Is
A special class representing a **fixed set of constants**.

```java
enum PowerSource {
    HUMAN_PEDAL,
    ELECTRIC,
    COMBUSTION,
    HYBRID
}
```

Enums are:
- Real classes
- Immutable
- Singleton per constant
- Type-safe

---

# 🔍 Modern Java enum (Deep Dive)

## 1️⃣ Constructor in enum

```java
enum PowerSource {
    HUMAN_PEDAL("Human powered"),
    ELECTRIC("Battery powered");

    private final String description;

    PowerSource(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
```

- Constructor is implicitly private
- Called once per constant

---

## 2️⃣ Fields in enum
- `private`
- Usually `final`
- Immutable recommended

---

## 3️⃣ Methods in enum
Enums can have:
- Instance methods
- Static methods
- Abstract methods

### Polymorphic enum example
```java
enum Operation {
    ADD { public int apply(int a, int b) { return a + b; } },
    SUB { public int apply(int a, int b) { return a - b; } };

    public abstract int apply(int a, int b);
}
```

---

## 4️⃣ Built-in Enum Methods

| Method | Purpose |
|---------|----------|
| `values()` | Returns all constants |
| `valueOf(String)` | Converts string to enum |
| `name()` | Returns exact identifier |
| `ordinal()` | Position index (avoid persisting) |
| `toString()` | Customizable string representation |
| `compareTo()` | Based on ordinal |

---

# 🧱 abstract

## What It Means
- Class cannot be instantiated
- May contain abstract methods

```java
abstract class Vehicle {
    abstract boolean hasMotor();
}
```

Forces subclasses to implement behavior.

---

# 🔐 sealed

## Purpose
Restricts which classes can extend a class.

```java
sealed abstract class TwoWheeler
    permits Bicycle, Motorcycle { }
```

Prevents uncontrolled inheritance.

---

# 📜 permits

Used with `sealed` to declare allowed subclasses.

```java
sealed class A permits B, C {}
```

Only B and C may extend A.

---

# 🧷 final

## On Class
Cannot be extended.

## On Method
Cannot be overridden.

## On Field
Assigned once.

```java
private final PowerSource powerSource;
```

Encourages immutability.

---

# 🏷 getClass().getSimpleName()

## What It Does
Returns runtime class name without package.

```java
@Override
public String toString() {
    return getClass().getSimpleName();
}
```

Supports polymorphism automatically.

---

# 🏭 Static Factory Methods

## Definition
A static method that returns an instance instead of using constructor directly.

```java
public static Bicycle regular(String color, String model, long price) {
    return new Bicycle(color, model, price, PowerSource.HUMAN_PEDAL);
}
```

## Advantages
- Descriptive names
- Controlled object creation
- Validation before creation
- Prevent invalid combinations

---

# 🧩 EnumSet Validation

## Example
```java
if (!EnumSet.of(PowerSource.COMBUSTION,
                PowerSource.ELECTRIC,
                PowerSource.HYBRID)
        .contains(powerSource)) {
    throw new IllegalArgumentException("Motorcycle must have a motor");
}
```

## Why EnumSet?
- Optimized for enums
- Type-safe
- Clean validation logic

Ensures only allowed enum values are accepted.

---

# 🌍 The Object Class (Foundation of Java)

Every class implicitly extends `java.lang.Object`.

---

## 1️⃣ getClass()
Returns runtime type of object.

---

## 2️⃣ toString()
Default: `ClassName@hashcode`

Override for readable output.

---

## 3️⃣ equals(Object obj)
Default: reference equality (`==`).

Override for logical equality.

Contract:
- Reflexive
- Symmetric
- Transitive
- Consistent
- Null-safe

---

## 4️⃣ hashCode()
Used in hash-based collections.

Rule: Equal objects must have equal hashCodes.

---

## 5️⃣ clone()
Creates shallow copy.

Requires:
- Implements Cloneable
- Override clone()

Modern Java prefers copy constructors instead.

---

## 6️⃣ wait()
Pauses thread until notified.
Must be inside synchronized block.

---

## 7️⃣ notify()
Wakes one waiting thread.

---

## 8️⃣ notifyAll()
Wakes all waiting threads.

---

## 9️⃣ finalize()
Deprecated.
Do not use.
Use try-with-resources instead.

---

# 🧠 Concept Summary

- Encapsulation protects invariants
- Inheritance models real hierarchy
- enum replaces boolean flags
- abstract enforces behavior contracts
- sealed + permits lock class hierarchy
- final restricts mutation/extension
- Static factories improve API clarity
- EnumSet validates allowed states
- Object class defines equality, hashing, threading

---

# 🚀 You Now Understand

- Domain modeling
- Type safety
- Runtime polymorphism
- Equality semantics
- Controlled object construction
- Modern Java hierarchy control

These are foundational pillars of professional Java design.

