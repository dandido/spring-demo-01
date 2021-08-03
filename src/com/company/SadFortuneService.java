package com.company;
/**
 * test out DI step 1 create a class + interface
 */
public class SadFortuneService implements IFortuneService {

    @Override
    public String getFort() {
        return "This is a response";
    }
}
