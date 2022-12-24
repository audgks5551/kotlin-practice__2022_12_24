package nullpointexception;

import java.util.Optional;

public class Java_NullSafety {
    public static String getNullStr() {
        return null;
    }

    public static int getLengthIfNotNull(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        return str.length();
    }

    public static void main(String[] args) {
        String nullableStr = getNullStr();

        // optional 사용
        nullableStr = Optional.ofNullable(nullableStr)
                .orElse("null 경우 반환");
        int nullableStrLength = nullableStr.length();
        System.out.println(nullableStrLength);

        // null check or length check
        int length = getLengthIfNotNull(null);
        System.out.println(length);
    }
}
