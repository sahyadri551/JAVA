void main(){
    // assignment operator
    int a = 10;
    a = a + 5;
    IO.println(a);
    int b = 10;
    b += 5;
    IO.println(b);
    int c = 10;
    c -= 5;
    IO.println(c);
    c *= 2;
    IO.println(c);
    c /= 2;
    IO.println(c);
    c %= 3;
    IO.println(c);

    // increment and decrement operators
    int d = 10;
    d++;
    IO.println(d);
    d--;
    IO.println(d);

    // preincrement and predecrement operators
    int e = 10;
    ++e;
    IO.println(e);
    --e;
    IO.println(e);

    // arithmetic operators
    int f = 10;
    int g = 6;
    IO.println(f + g);
    IO.println(f - g);
    IO.println(f * g);
    IO.println(f / g);
    IO.println(f % g);

    // relational operators
    int h = 10;
    int i = 6;
    IO.println(h == i);
    IO.println(h != i);
    IO.println(h > i);
    IO.println(h < i);
    IO.println(h >= i);
    IO.println(h <= i);

    // logical operators
    boolean j = true;
    boolean k = false;
    IO.println(j && k);
    IO.println(j || k);
    IO.println(!j);

    // bitwise operators
    int l = 60;
    int m = 13;
    IO.println(l & m);
    IO.println(l | m);
    IO.println(l ^ m);
    IO.println(~l);
    IO.println(l << 2);
    IO.println(l >> 2);

    // ternary operator
    int n = 10;
    IO.println(n > 5 ? "n is greater than 5" : "n is less than 5");

    // division problem
    int o = 10;
    int p = 3;
    IO.println(o / p);
    IO.println((double) o / p);

    // string comparison
    String q = "abc";
    String r = "abc";
    IO.println(q == r);
    String s = new String("abc");
    IO.println(q == s);
    IO.println(q.equals(s));
    IO.println(q.compareTo(s));
    IO.println(q.compareToIgnoreCase(s));

    // order of operations
    int t = 10;
    int u = 20;
    IO.println(t + u * 2 / 6.0 % 2);
}