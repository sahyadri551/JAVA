import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class J001Start {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        IO.println("Hello World using IO!");

        // The "Optimized" Way (For Speed/Competitive Programming)
        PrintWriter out = new PrintWriter(System.out);
        out.println("Hello World using PrintWriter!");
        out.flush(); // Ensure the output is printed immediately
        out.close();

        //The "Professional" Way (Real World Applications)
        Logger logger = LoggerFactory.getLogger(J001Start.class);
        logger.info("Hello World using Logger!");
        logger.debug("Hello World using Logger!");
    }
}