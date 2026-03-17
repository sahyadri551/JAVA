# 📘 Java OOP & Core Language Concepts — Production-Grade Notes

---

# 🔐 Encapsulation (Visibility + Invariant Control)

## Definition
Encapsulation is the disciplined control of **state visibility and mutation** to protect invariants and prevent invalid object states.

It is not “make everything private.”
It is deliberate visibility design.

---

## The Four Access Levels (You Must Know All)

| Modifier        | Same Class | Same Package | Subclass | World |
|----------------|------------|--------------|----------|--------|
| `private`      | ✅ | ❌ | ❌ | ❌ |
| *(default)*    | ✅ | ✅ | ❌ | ❌ |
| `protected`    | ✅ | ✅ | ✅ | ❌ |
| `public`       | ✅ | ✅ | ✅ | ✅ |

### private
Strict encapsulation. Only accessible inside the declaring class.
Used for:
- Core state
- Critical invariants
- Internal helpers

### Package-private (no modifier)
Intentional intra-package collaboration.
Used for:
- Internal framework classes
- Aggregates inside bounded contexts
- Hiding implementation from external modules

If you never use this intentionally, you are not designing module boundaries.

### protected
Subclass extension hook.
Used for:
- Template method patterns
- Controlled extension
- Framework design

Protected is a design commitment. You are exposing subclass mutation.

### public
Part of your API contract.
Every public member increases your maintenance burden.

---

## State Control Strategies

### Immutable Objects (Preferred When Possible)

```java
public final class Money {
    private final long amount;
    private final String currency;

    public Money(long amount, String currency) {
        if (amount < 0) throw new IllegalArgumentException();
        this.amount = amount;
        this.currency = currency;
    }

    public long amount() { return amount; }
    public String currency() { return currency; }
}
```

Benefits:
- Thread-safe
- Predictable
- Easier reasoning
- Safe as Map keys

---

## Encapsulation Rules

- Validate in constructors
- Never expose mutable internals
- Prefer behavior methods over raw setters
- Guard invariants aggressively

Encapsulation exists to prevent illegal states.

---

# 🧬 Inheritance (Structural Reuse + Runtime Polymorphism)

## Definition
Inheritance models a true **"is-a"** relationship and enables runtime polymorphism.

```java
abstract class Vehicle {
    abstract void move();
}

class Bicycle extends Vehicle {
    @Override
    void move() {
        System.out.println("Pedaling");
    }
}
```

---

## Constructor Chaining (super)

Object construction order:
1. Parent fields
2. Parent constructor
3. Child fields
4. Child constructor

```java
class Vehicle {
    Vehicle(String model) {}
}

class Bicycle extends Vehicle {
    Bicycle(String model) {
        super(model);
    }
}
```

If you don’t understand this order, debugging inheritance becomes guesswork.

---

## Method Overriding Rules

To override:
- Same signature
- Cannot reduce visibility
- Cannot throw broader checked exceptions
- Return type must be compatible

### Covariant Return Types

```java
class Animal {
    Animal reproduce() { return new Animal(); }
}

class Dog extends Animal {
    @Override
    Dog reproduce() { return new Dog(); }
}
```

Return type may be more specific.

---

## When NOT to Use Inheritance

Avoid inheritance when:
- Relationship is not truly hierarchical
- You only want code reuse
- Behavior may vary independently

Prefer composition over inheritance when possible.

---

# 🎯 Polymorphism (Core Pillar)

## Definition
Polymorphism allows objects of related types to be treated uniformly while allowing different behavior at runtime.

---

## 1️⃣ Compile-Time Polymorphism (Overloading)

Resolved at compile time.

```java
int add(int a, int b)
double add(double a, double b)
```

Based on method signature.

---

## 2️⃣ Runtime Polymorphism (Overriding)

Resolved at runtime via dynamic dispatch.

```java
Vehicle v = new Bicycle();
v.move();
```

Reference type → determines accessible methods  
Object type → determines executed method

This is the backbone of extensible systems.

---

# 🧩 Interfaces (Behavioral Contracts + Multiple Inheritance of Type)

## Why They Exist

Java does not support multiple class inheritance.

Interfaces allow:
- Multiple type inheritance
- Decoupling
- Dependency inversion
- Pluggable behavior

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    public void fly() {}
    public void swim() {}
}
```

---

## Default Methods (Java 8+)

Interfaces may provide behavior.

```java
interface Logger {
    default void log(String msg) {
        System.out.println(msg);
    }
}
```

### Diamond Conflict Resolution

```java
interface A { default void m() {} }
interface B { default void m() {} }

class C implements A, B {
    @Override
    public void m() {
        A.super.m();
    }
}
```

Classes must explicitly resolve conflicts.

---

## Interface vs Abstract Class

Use interface when:
- Defining capability
- Allowing multiple implementations
- No shared state required

Use abstract class when:
- Shared base logic
- Partial implementation
- Controlled hierarchy

---

# 🧱 The Object Class (Foundation of Java)

Every class extends `java.lang.Object`.

---

## equals() and hashCode() — Structural Contract

If you override `equals()`, you must override `hashCode()`.

Failing to do so breaks:
- HashMap
- HashSet
- Caches
- Any hashing structure

### Equality Contract

- Reflexive
- Symmetric
- Transitive
- Consistent
- Null-safe

Example:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Person p)) return false;
    return name.equals(p.name);
}

@Override
public int hashCode() {
    return Objects.hash(name);
}
```

---

## toString()

Override for debugging clarity.

Default is unreadable (`Class@hash`).

---

## clone()

Produces shallow copy.
Discouraged in modern Java.
Prefer:
- Copy constructors
- Static factory copy methods

---

## wait(), notify(), notifyAll()

Thread coordination primitives.
Must be used inside synchronized blocks.

Modern alternatives:
- java.util.concurrent utilities

---

# 🏷 final, sealed, and Hierarchy Control

## final

- Class → cannot extend
- Method → cannot override
- Field → assigned once

Encourages immutability and predictability.

---

## sealed (Java 17+)

Restricts inheritance.

```java
sealed abstract class Shape
    permits Circle, Rectangle {}
```

Enforces controlled hierarchy.

---

# 🏭 Static Factory Methods

## Definition
Static methods that return instances instead of using constructors directly.

Advantages:
- Named constructors
- Controlled creation
- Validation
- Caching
- Subtype return flexibility

Example:

```java
public static Bicycle regular(String color, long price) {
    return new Bicycle(color, price);
}
```

---

# 🎛 enum (Advanced Usage)

Enums are:
- Real classes
- Singleton per constant
- Immutable
- Type-safe

---

## Polymorphic Enum

```java
enum Operation {
    ADD { public int apply(int a, int b) { return a + b; } },
    SUB { public int apply(int a, int b) { return a - b; } };

    public abstract int apply(int a, int b);
}
```

Each constant behaves differently.

---

## EnumSet

Optimized set for enums.

- Bit-vector implementation
- Extremely fast
- Type-safe

Use for validation and allowed-state control.

---

# 🧠 Design Principles Summary

- Encapsulation protects invariants
- Inheritance enables structured polymorphism
- Interfaces enable decoupled behavior
- Polymorphism drives extensibility
- equals/hashCode form a strict structural contract
- final and sealed control hierarchy
- Prefer immutability
- Prefer composition when hierarchy is artificial

---

# 🚀 Professional-Level Understanding Means

You understand:

- Visibility as architecture
- Dispatch mechanics
- Contract-based design
- Runtime vs compile-time binding
- Structural equality implications
- Hierarchy control mechanisms
- Behavior abstraction strategies

This is production-grade Java design literacy.

