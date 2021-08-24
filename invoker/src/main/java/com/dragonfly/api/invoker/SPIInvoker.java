package com.dragonfly.api.invoker;

import com.dragonfly.api.spi.SPIService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: donganguo
 * @date: 2021/8/9 2:06 下午
 * @Description:
 */
public class SPIInvoker {
    public static void main(String[] args) {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
        for (SPIService ser : load) {
            ser.execute();
        }
        System.out.println("----------------");
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        while (providers.hasNext()){
            SPIService ser = providers.next();
            ser.execute();
        }
    }
}
