package classandproperty;

public class Java_Coffee {
    private boolean isIced;

    public boolean isIced() {
        return isIced;
    }

    public void setIced(boolean iced) {
        isIced = iced;
    }
}

class Barista {

    public static void main(String[] args) {
        Java_Coffee coffee = new Java_Coffee();
        coffee.setIced(true);

        if (coffee.isIced()) {
            System.out.println("아이스 커피");
        }
    }
}
