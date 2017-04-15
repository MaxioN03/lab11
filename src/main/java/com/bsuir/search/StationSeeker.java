package com.bsuir.search;

import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 15.04.17.
 */
public class StationSeeker {
    public static List<Bus> searchBusByDepStation(List<Bus> list, String query){
        List<Bus> result = new LinkedList<>();

        for(Bus bus: list){
            if(bus.getDepStation().contains(query)){
                result.add(bus);
            }
        }

        return result;
    }

    public static List<Bus> searchBusByArrStation(List<Bus> list, String query){
        List<Bus> result = new LinkedList<>();

        for(Bus bus: list){
            if(bus.getArrStation().contains(query)){
                result.add(bus);
            }
        }

        return result;
    }

    public static List<Train> searchTrainByDepStation(List<Train> list, String query){
        List<Train> result = new LinkedList<>();

        for(Train train: list){
            if(train.getDepStation().contains(query)){
                result.add(train);
            }
        }

        return result;
    }

    public static List<Train> searchTrainByArrStation(List<Train> list, String query){
        List<Train> result = new LinkedList<>();

        for(Train train: list){
            if(train.getArrStation().contains(query)){
                result.add(train);
            }
        }

        return result;
    }
}
