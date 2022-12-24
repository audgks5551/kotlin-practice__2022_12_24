package function;

class Message {

    public void greeting(String message) {
        // message 값이 null 이거나 message 길이가 0일 때
        // 코틀린에서는 message == null 일 경우에만 체크 (null 체킹만 함)
        if (message == null || message.length() == 0) {
            System.out.println("안녕하세요");
            return;
        }

        System.out.println(message);
    }

    public static void main(String[] args) {
        new Message().greeting(null);

        new Message().greeting("");

        new Message().greeting("Hello, World");
    }
}
