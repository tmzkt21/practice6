package com.practice.web.proxy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@FunctionalInterface
public interface IConsumer<T> {

    public void accept(T t);


}

