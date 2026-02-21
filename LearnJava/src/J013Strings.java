void main(String[] args){
    String a = "  Hello World!   ";
    IO.println(a);
    IO.print(a.charAt(0));
    IO.println(a.length());
    IO.println(a.substring(6));
    IO.println(a.replace('o', 'a'));// return new string
    IO.println(a.toUpperCase());
    IO.println(a.toLowerCase());
    IO.println(a.trim());
    IO.println(a.startsWith("Hello"));
    IO.println(a.endsWith("World!"));
    IO.println(a.indexOf('l'));
    IO.println(a.indexOf('z'));
    IO.println(a.contains("o"));
    IO.println(a.equals("Hello World!")); // it checks the content of the string
    IO.println(a.compareTo("Hello World!"));// it checks lexicographically
    IO.println(a.compareToIgnoreCase("hello world!"));
    IO.println(a.concat("!!!")); // it returns new string
    IO.println(a.replace("World!", "Java"));
    IO.println(a.split(" "));
    IO.println(a.replace(" ", "-"));

    // string buffer
    StringBuffer sb = new StringBuffer(a);
    sb.append("!!!");
    sb.setCharAt(0, 'J');
    sb.insert(6, "Hello ");
    sb.reverse();
    sb.delete(0, 6);
    sb.deleteCharAt(10);
    sb.replace(0, 5, "Goodbye");
    sb.trimToSize();
    IO.println(sb);
    IO.println(sb.capacity());
    IO.println(sb.toString());
    IO.println(sb.subSequence(0, 5));
    IO.println(sb.charAt(0));
    sb.setLength(0);// it clears the string
    IO.println(sb);

    // string builder
    StringBuilder sb2 = new StringBuilder(a);
    sb2.append("!!!");
    sb2.setCharAt(0, 'J');
    sb2.insert(6, "Hello ");
    sb2.reverse();
    sb2.delete(0, 6);
    sb2.deleteCharAt(10);
    sb2.replace(0, 5, "Goodbye");
    sb2.trimToSize();
    IO.println(sb2);
    IO.println(sb2.capacity());
    IO.println(sb2.toString());
    IO.println(sb2.subSequence(0, 5));
    IO.println(sb2.charAt(0));

    // printf with format specifier and flags
    System.out.printf("%-10s %-10s %-10s %-10s \n", "Name", "Age", "Gender", "City");
    int age = 20;
    System.out.printf("%n%-10s %-10d %-10s %-10s\n", "John", age, "Male", "New York");

    // format specifier
    System.out.printf("%d %f %b %c\n", 10, 10.5, true, 'a');
    System.out.printf("%n%s\n", "Hello World!");
    System.out.printf("%n%s\n", "Hello World!".toUpperCase());

    // position specifier
    System.out.printf("%1$s %2$s %1$s\n", "Hello", "World!");
    System.out.printf("%n%1$s %2$s %3$s\n", "Hello", "World!", "!");

    // sign specifier
    System.out.printf("%+d %+d %+d\n", 10, -10, 10);

    // comma specifier
    System.out.printf("%,d\n", 1000000000);

    // 0 padding specifier
    System.out.printf("%010d\n", 10);

    //  minimum width specifier
    System.out.printf("%-10d\n", -10);

    // founding specifier
    System.out.printf("%.2f\n", 10.5678);

    // a listing specifier
    System.out.printf("%a\n", 10.5678);

    // center alignment specifier
    System.out.printf("%,10.2f\n", 10.5678);

    // percentage specifier
    System.out.printf("%.2f%%\n", 10.5678);

    // date and time specifier
    System.out.printf("%tF\n", new java.util.Date());
    System.out.printf("%tT\n", new java.util.Date());
    System.out.printf("%tc\n", new java.util.Date());
    System.out.printf("%tr\n", new java.util.Date());

    // string formatting
    String name = "John";
    int age2 = 20;
    String formattedString = String.format("My name is %s and I am %d years old.", name, age2);
    IO.println(formattedString);

    // string builder formatting
    StringBuilder sb3 = new StringBuilder();
    sb3.append("My name is ").append(name).append(" and I am ").append(age2).append(" years old.");
    IO.println(sb3);

}