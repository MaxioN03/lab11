package com.bsuir;

import com.bsuir.resourceFactory.Resource;
import com.bsuir.resourceFactory.ResourceFactory;

/**
 * Created by Егор on 10.04.17.
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("XML");
        System.out.println(resource.getResource("TRAIN"));
    }

}

