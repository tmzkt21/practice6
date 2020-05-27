package com.practice.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

import static sun.misc.PostVMInitHook.run;

@Component @Lazy
public class Box<T> {
    private HashMap<String,T> box; // 인스턴스 만듬
    public Box(){box = new HashMap<>();}
    public void put(String s, T t){box.put(s,t);}
// put, get(k), get(map),clear

    public T get(String k){
        Function<String, T> s = box::get;

        return s.apply(k);
    }

    public  HashMap<String,T> get(){

        return box;
    }

    public int size(){
        Supplier<Integer> f = box::size;
        return f.get();
    }
    public void clear(){
        box.clear();
    }
    public void newBox(){box=new HashMap<String, T>();}
}
