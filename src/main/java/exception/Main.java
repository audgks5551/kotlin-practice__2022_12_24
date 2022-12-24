package exception;

public class Main {
    public static void main(String[] args) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // 예외처리
        }
    }
}
