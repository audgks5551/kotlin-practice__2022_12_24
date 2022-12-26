package flow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;


// Cell 은 Publisher 이자 Subscriber 이다
class SimpleCell implements Flow.Publisher<Integer>, Flow.Subscriber<Integer> {
    private int value = 0;
    private String name;
    private List<Flow.Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name) {
        this.name = name;
    }

    // 구독하기
    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    // Subscriber 가 subscription 을 Publisher 에게 보내기
    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    // 자기 자신을 호출하고 모든 구독자에게 해당 내용을 전달한다
    @Override
    public void onNext(Integer newValue) {
        this.value = newValue;
        System.out.println(this.name + ":" + this.value);
        notifyAllSubscribers();
    }

    private void notifyAllSubscribers() {
        subscribers.forEach(subscriber -> subscriber.onNext(this.value));
    }

    // 에러시
    @Override
    public void onError(Throwable throwable) {}

    // 종료시
    @Override
    public void onComplete() {

    }
}
public class Main {
    public static void main(String[] args) {
        SimpleCell c3 = new SimpleCell("C3");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c1 = new SimpleCell("C1");

        c1.subscribe(c3);

        c1.onNext(10);
        c2.onNext(20);
    }
}
