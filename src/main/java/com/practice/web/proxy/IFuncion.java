package com.practice.web.proxy;

@FunctionalInterface
public interface IFuncion<T,R> {
    public R apply(T t);
}
