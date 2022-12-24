package flowcontrol;

public class Main {
    public static void main(String[] args) {
        int age = 18;

        // 코틀린에서는 if 문을 통해 값을 리턴받을 수 있다
        String str = "";
        if (age > 18) {
            str = "성인";
        } else {
            str = "아이";
        }

        System.out.println(str);

        int day = 2;
        String result = "";
        switch (day) {
            case 1:
                result = "월요일";
                break;
            case 2:
                result = "화요일";
                break;
        }

        System.out.println(result);
    }
}
