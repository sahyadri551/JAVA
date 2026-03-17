# 📘 Composition vs Inheritance — Real Enterprise Refactoring Case Study

---

# 1️⃣ Context: A Realistic Enterprise Scenario

Imagine a mid-sized SaaS billing platform.

The system started simple.
Then features were added:

- Discount codes
- Regional tax rules
- Subscription tiers
- Trial accounts
- Enterprise contracts
- Promotional campaigns

Instead of redesigning carefully, the team kept extending the inheritance hierarchy.

What started clean became fragile.

---

# 2️⃣ The Original Inheritance-Based Design

## Initial Version (Reasonable)

```java
abstract class Account {
    protected String id;

    abstract double calculateMonthlyFee();
}

class BasicAccount extends Account {
    @Override
    double calculateMonthlyFee() {
        return 10.0;
    }
}

class PremiumAccount extends Account {
    @Override
    double calculateMonthlyFee() {
        return 25.0;
    }
}
```

So far, fine.

---

## Then Requirements Explode

New subclasses appear:

```
Account
 ├── BasicAccount
 ├── PremiumAccount
 ├── TrialAccount
 ├── DiscountedPremiumAccount
 ├── EnterpriseAccount
 ├── EnterpriseDiscountedAccount
 ├── RegionalEnterpriseAccount
 ├── RegionalEnterpriseDiscountedAccount
```

The hierarchy becomes combinatorial.

Each new feature multiplies subclasses.

---

# 3️⃣ Production Symptoms

After 18 months:

### ❌ Symptom 1: Conditional Logic Everywhere

```java
if (account instanceof EnterpriseDiscountedAccount) {
    ...
}
```

Polymorphism is breaking.

---

### ❌ Symptom 2: Feature Interaction Bugs

Discount logic duplicated across multiple subclasses.
Tax rules inconsistently applied.

---

### ❌ Symptom 3: Fear of Change

Adding "LoyaltyDiscountAccount" means touching 5 subclasses.
Regression risk high.

---

### ❌ Symptom 4: LSP Violations

Example:

```java
class TrialAccount extends Account {
    @Override
    double calculateMonthlyFee() {
        throw new UnsupportedOperationException();
    }
}
```

Now base contract is broken.

Hierarchy is semantically invalid.

---

# 4️⃣ Root Cause Analysis

The team modeled:

Account TYPES.

But the domain actually consists of:

- Pricing strategy
- Discount strategy
- Tax strategy
- Trial behavior

These are independent dimensions.

Inheritance forces single-axis classification.

The domain is multi-dimensional.

---

# 5️⃣ Refactoring Strategy: Move to Composition

Goal:

Replace rigid hierarchy with interchangeable behaviors.

---

# 6️⃣ Step 1: Extract Pricing Strategy

```java
interface PricingStrategy {
    double basePrice();
}

class BasicPricing implements PricingStrategy {
    public double basePrice() { return 10.0; }
}

class PremiumPricing implements PricingStrategy {
    public double basePrice() { return 25.0; }
}
```

---

# 7️⃣ Step 2: Extract Discount Strategy

```java
interface DiscountStrategy {
    double apply(double amount);
}

class NoDiscount implements DiscountStrategy {
    public double apply(double amount) { return amount; }
}

class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double apply(double amount) {
        return amount * (1 - percent);
    }
}
```

---

# 8️⃣ Step 3: Extract Tax Strategy

```java
interface TaxStrategy {
    double applyTax(double amount);
}

class NoTax implements TaxStrategy {
    public double applyTax(double amount) { return amount; }
}

class RegionalTax implements TaxStrategy {
    private final double rate;

    RegionalTax(double rate) {
        this.rate = rate;
    }

    public double applyTax(double amount) {
        return amount * (1 + rate);
    }
}
```

---

# 9️⃣ Step 4: Rebuild Account Using Composition

```java
class Account {

    private final PricingStrategy pricing;
    private final DiscountStrategy discount;
    private final TaxStrategy tax;

    Account(PricingStrategy pricing,
            DiscountStrategy discount,
            TaxStrategy tax) {
        this.pricing = pricing;
        this.discount = discount;
        this.tax = tax;
    }

    double calculateMonthlyFee() {
        double base = pricing.basePrice();
        double discounted = discount.apply(base);
        return tax.applyTax(discounted);
    }
}
```

No subclasses required.

Behavior assembled at runtime.

---

# 🔟 Usage Example

```java
Account enterpriseAccount = new Account(
    new PremiumPricing(),
    new PercentageDiscount(0.15),
    new RegionalTax(0.20)
);
```

New combinations require no new classes.

---

# 1️⃣1️⃣ Benefits Observed After Refactor

### ✅ No subclass explosion

### ✅ No instanceof checks

### ✅ Independent feature evolution

### ✅ Easier unit testing

Each strategy tested separately.

### ✅ LSP preserved

Account contract never broken.

---

# 1️⃣2️⃣ Performance Considerations

Strategy pattern introduces:

- Extra indirection
- More small objects

But JIT often inlines small strategy methods.

Maintainability gain outweighs negligible overhead.

---

# 1️⃣3️⃣ When Inheritance IS Still Correct

Inheritance is valid when:

- True "is-a" relationship
- Shared invariant state
- Stable abstraction
- No combinatorial feature growth

Example:

```
Shape
 ├── Circle
 └── Rectangle
```

Clear conceptual hierarchy.

---

# 1️⃣4️⃣ Decision Heuristic

Ask:

Is this relationship classification-based
or capability-based?

If capabilities vary independently → use composition.
If identity is hierarchical and stable → inheritance may be valid.

---

# 1️⃣5️⃣ Architectural Lesson

Inheritance couples variation dimensions.

Composition isolates variation dimensions.

Enterprise systems almost always evolve along multiple independent axes.

Rigid hierarchies collapse under change.

---

# 🚀 Industry-Level Understanding Means

You:

- Recognize subclass explosion early
- Refactor toward strategy-based design
- Avoid false taxonomies
- Design for independent variability
- Preserve substitutability

Composition is not a slogan.

It is a structural safeguard against combinatorial architecture failure.

