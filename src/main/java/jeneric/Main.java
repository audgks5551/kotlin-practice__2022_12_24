package jeneric;

import java.util.Objects;

class Box<T> {
    public T content;

    public boolean compare(Box<T> other) {
        Class<?> aClass = other.content.getClass();
        Class<?> aClass1 = this.content.getClass();
        System.out.println(aClass);
        System.out.println(aClass1);
        boolean result = content.equals(other.content);
        return result;
    }
}

class Pencil {
    private String name;

    public String getName() {
        return name;
    }

    public Pencil(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pencil pencil = (Pencil) o;
        return name.equals(pencil.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.content = "100";

        Box box2 = new Box();
        box2.content = "100";

        Box box3 = new Box();
        box3.content = 100;

        Box box4 = new Box();
        box4.content = 100;

        Box box5 = new Box();
        box5.content = new Pencil("슈퍼");

        Box box6 = new Box();
        box6.content = new Pencil("슈퍼");

        boolean compare = box1.compare(box2);
        System.out.println(compare);

        boolean compare1 = box1.compare(box3);
        System.out.println(compare1);

        boolean compare2 = box3.compare(box4);
        System.out.println(compare2);

        boolean compare3 = box5.compare(box6);
        System.out.println(compare3);
    }
}
