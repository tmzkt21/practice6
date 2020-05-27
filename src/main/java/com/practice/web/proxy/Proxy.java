package com.practice.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.*;

import static org.jboss.logging.NDC.get;
import static sun.misc.PostVMInitHook.run;

// a = pxy.syting() () 안에 값을담으면 스트링화 된다
@Component("pxy") @Lazy // @Component("pxy") = 타입정의 @Lazy = 지연된로딩
public class Proxy {
    public String string(Object param){
        Function<Object,String> f = String :: valueOf;

        return f.apply(param);
    }

public int integer(String s){
  Function<String, Integer> f = Integer::parseInt;
      return f.apply(s);
    }



    public Boolean equals(String t, String u){
        BiPredicate<String,String> f = String::equals;
        return f.test(t,u);
    }


  public void print(String t){
   Consumer<String> c = System.out::print;
   c.accept(t);
  }


}
