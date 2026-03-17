# 📘 Liskov Substitution Principle — Industry-Grade Deep Dive

---

# 1️⃣ Formal Definition

The Liskov Substitution Principle (LSP), introduced by Barbara Liskov (1987), states:

> If S is a subtype of T, then objects of type T should be replaceable with objects of type S without altering the correctness of the program.

In practical terms:

Subtypes must honor the behavioral expectations established by their base types.

Not just method signatures.
Not just return types.
Behavioral contracts.

---

# 2️⃣ Why LSP Is Not About Syntax

Most developers think inheritance correctness means:

- Method signature matches
- Visibility rules respected
- Covariant returns used properly

That is syntactic correctness.

LSP is semantic correctness.

If substituting a subclass breaks client assumptions, the hierarchy is wrong.

---

# 3️⃣ The Classic Rectangle–Square Failure

## ❌ Broken Design

```java
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```

## Client Code

```java
void resize(Rectangle r) {
    r.setWidth(5);
    r.setHeight(10);
    assert r.area() == 50;
}
```

Passing a Square breaks the assumption.

Expected: 5 × 10 = 50  
Actual: 10 × 10 = 100

The program compiles.
The hierarchy is logically invalid.

Square is not a behavioral subtype of Rectangle.

---

# 4️⃣ Behavioral Contract Requirements

A subtype must not:

- Strengthen preconditions
- Weaken postconditions
- Break invariants
- Change expected side effects


## 4.1 Strengthening Preconditions (Illegal)

Base class:

```java
class PaymentProcessor {
    void process(double amount) {
        if (amount <= 0) throw new IllegalArgumentException();
    }
}
```

Subclass:

```java
class CryptoProcessor extends PaymentProcessor {
    @Override
    void process(double amount) {
        if (amount < 100) throw new IllegalArgumentException();
    }
}
```

Now callers passing 50 (valid in base) break.

That violates LSP.

---

## 4.2 Weakening Postconditions (Illegal)

Base contract guarantees a non-null return.

Subclass returning null breaks the guarantee.

---

# 5️⃣ Real-World Industry Failure: Collections

Consider Java’s `List` contract.

`ArrayList` allows element replacement.
`List.of()` returns immutable list.

Calling:

```java
List<String> list = List.of("A");
list.add("B");
```

Throws `UnsupportedOperationException`.

Why is this not an LSP violation?

Because mutability is not guaranteed by the List contract.

The contract defines behavior.
Not convenience assumptions.

Understanding LSP requires reading contracts, not guessing intent.

---

# 6️⃣ Real-World Case Study: Bird Example (Common Interview Trap)

```java
class Bird {
    void fly() {}
}

class Ostrich extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

Ostrich cannot fly.

But Bird promises flight capability.

Hierarchy is conceptually wrong.

Correct design:

```java
interface Bird {}
interface FlyingBird extends Bird {
    void fly();
}
```

Now Ostrich implements Bird only.

Behavior-driven abstraction.

---

# 7️⃣ LSP and Polymorphism

Polymorphism relies on safe substitution.

```java
Vehicle v = new ElectricCar();
v.start();
```

If ElectricCar throws unexpected exceptions or alters start semantics,
polymorphism collapses.

LSP is the safety guarantee behind runtime polymorphism.

---

# 8️⃣ Detecting LSP Violations in Code Reviews

Look for:

- Overridden methods throwing new runtime exceptions
- Subclasses adding validation not present in base
- Conditionals checking concrete subtype

Example smell:

```java
if (vehicle instanceof Bicycle) {
    ...
}
```

This indicates broken polymorphism.

---

# 9️⃣ LSP and Domain Modeling

Bad hierarchy example:

Employee
 ├── PermanentEmployee
 └── Contractor

If Contractor does not receive benefits but base class assumes benefits,
the abstraction is wrong.

Model capabilities, not labels.

---

# 🔟 Composition as an LSP Fix

Instead of inheritance:

```java
class Square {
    private final Rectangle rectangle;
}
```

Or redesign around Shape interface.

Composition avoids false hierarchies.

---

# 1️⃣1️⃣ Formal Behavioral Subtyping Rules

For subtype S of T:

1. Preconditions(S) ≤ Preconditions(T)
2. Postconditions(S) ≥ Postconditions(T)
3. Invariants preserved
4. History constraints respected

If any fail, the hierarchy is invalid.

---

# 1️⃣2️⃣ LSP and Testing Strategy

To verify LSP:

- Write tests against base type
- Run same tests against all subtypes
- No test should fail

This is subtype contract testing.

---

# 1️⃣3️⃣ Key Takeaways

- LSP is behavioral, not structural
- Compilation does not guarantee substitutability
- Most inheritance misuse violates LSP
- Composition often avoids LSP pitfalls
- Safe polymorphism depends on LSP

---

# 🚀 Industry-Level Understanding Means

You:

- Design hierarchies from behavior outward
- Avoid convenience inheritance
- Validate contracts explicitly
- Test substitutability
- Refactor aggressively when LSP is broken

If you violate LSP, your architecture will accumulate conditional logic, runtime exceptions, and fragile code.

LSP is not theoretical.
It is the line between scalable architecture and inheritance chaos.

