package com.bsuir.resourceFactory;

import com.bsuir.AbstractFactory;

/**
 * Created by Егор on 10.04.17.
 */
public class ResourceFactory extends AbstractFactory {

    public Resource getResource(String resource) {
        if(resource.equals("XML")){
            return new XMLResource();
        }
        else if(resource.equals("CSV")){
            return new CSVResource();
        }

        return null;
    }

}
