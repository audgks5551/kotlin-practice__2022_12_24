package function;

public class Logger {

    public void log(String level, String message) {
        // 코틀린에서는 level == null 일 경우에만 적용
        if (level == null || level.length() == 0) {
            level = "INFO";
        }

        System.out.printf("[%s]%s\n", level, message);
    }


    public static void main(String[] args) {
        // 코틀린에서는 named argument 를 제공하여 조금 더 가독성이 향상된다.
        Logger logger = new Logger();

        logger.log("INFO", "인포 로그");

        logger.log(/* level = */"DEBUG", "디버그 로그");

        logger.log("WARN", "워닝 로그");

        String level = "ERROR"; // 설명 변수
        logger.log(level, "에러 로그");
    }
}
