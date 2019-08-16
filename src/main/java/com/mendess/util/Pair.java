package com.mendess.util;

import java.util.function.Function;

public class Pair<A, B> {
    private final A a;
    private final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getFirst() {
        return this.a;
    }

    public B getSecond() {
        return this.b;
    }

    public <C> Pair<C, B> mapFirst(Function<A, C> f) {
        return new Pair<>(f.apply(this.a), this.b);
    }

    public <C> Pair<A, C> mapSecond(Function<B, C> f) {
        return new Pair<>(this.a, f.apply(this.b));
    }
}
