package flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.function.Consumer;

class OneShotPublisher implements Flow.Publisher<Boolean> {
    private final ExecutorService executorService = ForkJoinPool.commonPool();
    private boolean subscribed;

    @Override
    public synchronized void subscribe(Flow.Subscriber<? super Boolean> subscriber) {
        if (subscribed) {
            subscriber.onError(new IllegalStateException());
        } else {
            subscribed = true;
            subscriber.onSubscribe(new OneShotSubscription(subscriber, executorService));
        }
    }

    static class OneShotSubscription implements Flow.Subscription {
        private final Flow.Subscriber<? super Boolean> subscriber;
        private final ExecutorService executorService;
        private Future<?> future;
        private boolean completed;

        public OneShotSubscription(Flow.Subscriber<? super Boolean> subscriber, ExecutorService executorService) {
            this.subscriber = subscriber;
            this.executorService = executorService;
        }

        @Override
        public synchronized void request(long n) {
            if (!completed) {
                completed = true;

                if (n <= 0) {
                    IllegalArgumentException ex = new IllegalArgumentException();
                    executorService.execute(() -> subscriber.onError(ex));
                } else {
                    future = executorService.submit(() -> {
                        subscriber.onNext(Boolean.TRUE);
                        subscriber.onComplete();
                    });
                }
            }
        }

        @Override
        public synchronized void cancel() {
            completed = true;
            if (future != null) future.cancel(false);
        }
    }
}

class SampleSubscriber<T> implements Flow.Subscriber<T> {
    final Consumer<? super T> consumer;
    Flow.Subscription subscription;
    final long bufferSize;
    long count;

    public SampleSubscriber(Consumer<? super T> consumer, long bufferSize) {
        this.consumer = consumer;
        this.bufferSize = bufferSize;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2;

        (this.subscription = subscription).request(initialRequestSize);
    }

    @Override
    public void onNext(T item) {
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        consumer.accept(item);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}

public class FlowExample {
    public static void main(String[] args) {
        OneShotPublisher publisher = new OneShotPublisher();
        Consumer<Boolean> consumer = System.out::println;
        SampleSubscriber<Boolean> subscriber = new SampleSubscriber<>(consumer, 10);

        // publisher.subscribe(subscriber) -> subscriber.onSubscribe(subscription) ->
        // subscription.request(n) -> subscriber.onNext(value) -> onNext() ... -> onComplete/onCancel
        publisher.subscribe(subscriber);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
