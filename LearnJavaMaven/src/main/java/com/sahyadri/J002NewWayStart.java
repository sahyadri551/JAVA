import org.slf4j.LoggerFactory;

void main() {
    IO.println("Hello from Java 25!");
    var logger = LoggerFactory.getLogger("MyApp");
    logger.info("This is a structured log message.");
}