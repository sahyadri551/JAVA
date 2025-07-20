import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String s3=new String(" Hello ");
        System.out.println("s == s3 : " + (s==s3));
        System.out.println("s == s3 : " + (s.equals(s3)));
        System.out.println("s == s3.intern() : " + (s==s3.intern()));

        String s4="Smt";
        String s5="smt";
        System.out.println("s4 == s5 : " + (s4.equals(s5)));
        System.out.println("s4 == s5.intern() : " + (s4.equalsIgnoreCase(s5))); 
        
        System.out.println();
        System.out.println("======Escape Sequences======");
        System.out.println();
        /*
         * \n - New line
         * \t - Tab
         * \b - Backspace (a step backward in the text or deletion of a character)
         * \f - Form feed
         * \r - Carriage return
         * \" - Double quote
         * \' - Single quote
         * \\ - Backslash
         * \u0000 - Null
         */
        String s6="Hello\nWorld";
        System.out.println(s6+"\n");
        String s7="Hello\tWorld";
        System.out.println(s7+"\n");
        String s8="Hello\bWorld";
        System.out.println(s8+"\n");
        String s9="Hello\fWorld";
        System.out.println(s9+"\n");
        String s10="Hello\rWorld";
        System.out.println(s10+"\n");
        String s11="Hello\"World";
        System.out.println(s11+"\n");
        String s12="Hello\'World";
        System.out.println(s12+"\n");
        String s13="Hello\\World";
        System.out.println(s13+"\n");
        String s14="Hello\u0020World";
        System.out.println(s14+"\n");

        System.out.println();
        System.out.println("======String Formatting======");
        System.out.println();

        String s15="Hello";
        String s16="World";
        System.out.println("s15 + s16 : "+s15+s16);
        System.out.println("String.format(\"%s %s\",s15,s16) : "+String.format("%s %s",s15,s16));
        System.out.printf("The no of lines till yet is %d",86);

        System.out.println();
        System.out.println("======Regular Expressions======");
        System.out.println();
        String emailPattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";
        Pattern pattern=Pattern.compile(emailPattern);
        String random_text=" It is a random text containing a random email address:Uc9Yy@example.com";
        Matcher matcher=pattern.matcher(random_text);
        matcher.find();
        System.out.println("matcher.group() : "+matcher.group());
    }  
}
