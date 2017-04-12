package com.bsuir;

import com.bsuir.resourceFactory.Resource;

/**
 * Created by Егор on 10.04.17.
 */
public abstract class AbstractFactory {
    public abstract Resource getResource(String resource);

}
