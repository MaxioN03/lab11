package com.bsuir;

import com.bsuir.entity.Vehicle;
import com.bsuir.resourceFactory.Resource;
import com.bsuir.resourceFactory.ResourceFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public class Main {
    public static void main(String[] args) {
        List<? super Vehicle> markedList = new LinkedList<>();

        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("CSV");
        List<? extends Vehicle> list = resource.getResource("TRAIN");
        list = resource.getResource("BUS");

        System.out.println(markedList);
    }


}

