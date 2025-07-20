import java.util.Arrays;

public class J009String {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("======String Methods======");
        System.out.println();
        String s=" Hello ";
        System.out.println("s.length():"+s.length());
        System.out.println("s.isEmpty():"+s.isEmpty());
        System.out.println("s.contains():"+s.contains("He"));
        System.out.println("s.lengthtoUpperCase():"+s.toUpperCase());
        System.out.println("s.startsWith():"+s.startsWith("h"));
        System.out.println("s.endsWith():"+s.endsWith(" "));
        System.out.println("s.replace():"+s.replace("ll","LL"));
        System.out.println("s.trim():"+s.trim());
        System.out.println("s.strip():"+s.strip());
        System.out.println("s.substring():"+s.substring(0,3));
        System.out.println("Arrays.toString(s.getBytes()) : "
                            +Arrays.toString(s.getBytes()));
        System.out.println("Arrays.toString(s.toCharArray()) : "
                            +Arrays.toString(s.toCharArray()));
        System.out.println("s.charAt(5): "+s.charAt(5));
        System.out.println("Arrays.toString(s.split(\"e\")) : "
                            +Arrays.toString(s.split("e")));
        System.out.println("s.split(\"e\") : "+s.split("e"));

        System.out.println();
        System.out.println("======String Comparision======");
        System.out.println();
        String s2=" Hello ";
        System.out.println("s == s2 : " + (s==s2));
        System.out.println("s == s2 : " + (s.equals(s2)));

        
    }  
}
