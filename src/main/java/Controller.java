import java.nio.charset.Charset;
import java.util.Scanner;

public class Controller {
    public static void launch() {
        String input;
        InputProcessor processor = new InputProcessor();
        while (true) {
            System.out.println("Print 4 digits (0-9, no spaces). Q to exit");
            input = new Scanner(System.in, Charset.defaultCharset()).nextLine();
            if ("q".equalsIgnoreCase(input)) {
                break;
            } else {
                System.out.println(processor.processInput(input));
                System.out.println("------------");
            }
        }
    }
}
