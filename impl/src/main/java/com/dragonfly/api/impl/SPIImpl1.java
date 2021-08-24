package com.dragonfly.api.impl;
import com.dragonfly.api.spi.SPIService;

/**
 * @author: donganguo
 * @date: 2021/8/9 1:05 下午
 * @Description:
 */
public class SPIImpl1 implements SPIService{
    public void execute() {
        System.out.println("SpiImpl1.execute()");
    }
}
