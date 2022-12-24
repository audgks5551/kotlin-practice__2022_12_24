package collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // hashCode 가 같고 equals 가 true이면
        // HashSet 은 새로운 객체가 저장이 되지 않는다.
        // 그러나 HashMap 은 기존의 객체가 새로운 객체로 대치된다.
        Set<Member> members = new HashSet<>();
        Map<Integer, Member> members2 = new HashMap<>();

        members.add(new Member(1L, "이름1", 27));

        members.forEach(System.out::println);

        System.out.println("=============================");

        members.add(new Member(1L, "이름1", 28));

        members.forEach(System.out::println);

        System.out.println("=============================");
        System.out.println("----");
        System.out.println("HashMap");
        System.out.println("----");

        members2.put(1, new Member(1L, "이름1", 27));
        members2.put(1, new Member(1L, "이름2", 28));

        Collection<Member> values = members2.values();

        values.forEach(System.out::println);
    }
}
