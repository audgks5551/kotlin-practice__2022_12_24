package exception;

import java.io.FileWriter;
import java.io.IOException;

public class TryCatch {
    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello Java");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
