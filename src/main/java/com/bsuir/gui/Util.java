package com.bsuir.gui;

import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * Created by Егор on 15.04.17.
 */
public class Util {
    public static void setBusListAtTable(DefaultTableModel model, List<Bus> listBus){
        Vector<String> vector = new Vector<String>();

        for (Bus bus : listBus) {
            vector = new Vector<String>();
            vector.add(String.valueOf(bus.getNumber()));
            vector.add(bus.getDepDate());
            vector.add(bus.getDepTime());
            vector.add(bus.getDepStation());
            vector.add(String.valueOf(bus.getDepPlatform()));
            vector.add(bus.getArrStation());
            vector.add(String.valueOf(bus.getCost()));
            vector.add(bus.getMark());
            vector.add(bus.getTime());
            model.addRow(vector);
        }
    }

    public static void setTrainListAtTable(DefaultTableModel model, List<Train> listTrain){
        Vector<String> vector = new Vector<String>();

        for (Train train : listTrain) {
            vector = new Vector<String>();
            vector.add(String.valueOf(train.getNumber()));
            vector.add(train.getDepDate());
            vector.add(train.getDepTime());
            vector.add(train.getDepStation());
            vector.add(String.valueOf(train.getDepPlatform()));
            vector.add(train.getArrStation());
            vector.add(train.getArrDate());
            vector.add(train.getArrTime());
            vector.add(String.valueOf(train.getCost()));
            vector.add(train.getTypeTicket());
            model.addRow(vector);
        }
    }

    public static void clearTable(DefaultTableModel model){
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
