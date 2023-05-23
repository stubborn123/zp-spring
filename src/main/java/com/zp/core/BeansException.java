package com.zp.core;

/**
 * @Author: zhangpeng
 * @Description:定义一个异常处理Exception
 *
 * 实际上继承RuntimeException更好一点，一方面我们大多数框架自定义的异常继承的都是RuntimeException
 * Spring（5.1版本）自己也继承的是RuntimeException
 *
 * RuntimeException时“非检查异常”，标识对应的异常需要程序员自己去处理，比如说空指针，溢出等情况
 * RuntimeException本身就被定义为非检查异常，继承他的异常也有同样的属性
 * todo 后面准备改成RuntimeException
 *
 *
 * @Date: 2023/5/18
 */
public class BeansException extends Exception {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException() {

    }
}
