package study.rxjava;


import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuwei on 2017/7/7.
 */

/**
 * rxjava1.x
 */
public class Demo1 {
    public static void main(String[] args) {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("thread:" + Thread.currentThread().getName() + " " + s);
            }

            @Override
            public void onCompleted() {
                System.out.println("thread:" + Thread.currentThread().getName() + " on completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("thread:" + Thread.currentThread().getName() + " on error");
            }
        };
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("hello1");
                subscriber.onNext("sdfa");

            }
        });
        Observable<String> observable1 = Observable.just("hello", "dd", "daf");

        observable.subscribe(subscriber);
        observable1.subscribe(subscriber);
        query("")
                .subscribe(urls -> Observable.from(urls)
                        .subscribe(System.out::print));

    }
    public static Observable<List<String>> query(String text){
        return Observable.fromCallable((Func0<List<String>>) () -> new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc")));
    }
}
