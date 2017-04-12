package com.bsuir.resourceFactory;

import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public class CSVResource implements Resource {
    public List getResource(String scheduleType) {
        switch (scheduleType.toLowerCase()) {
            //todo
            case "bus":
                return getBusSchedule();
            case "train":
                return getTrainSchedule();
        }
        return null;
    }

    private List<Bus> getBusSchedule() {
        List<Bus> result = new LinkedList<Bus>();
        String csvFile = "E:\\Uchoba\\6\\Ситиод\\Lab 11\\src\\main\\resources\\bus.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"Cp1251"))) {

            while ((line = br.readLine()) != null) {
                // use ; as separator
                String[] arr = line.split(cvsSplitBy);
                result.add(new Bus(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        Integer.parseInt(arr[4]), arr[5],
                        Double.parseDouble(arr[6]), arr[7], arr[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Train> getTrainSchedule() {
        List<Train> result = new LinkedList<Train>();
        String csvFile = "E:\\Uchoba\\6\\Ситиод\\Lab 11\\src\\main\\resources\\train.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"Cp1251"))) {

            while ((line = br.readLine()) != null) {
                // use ; as separator
                String[] arr = line.split(cvsSplitBy);
                result.add(new Train(Integer.parseInt(arr[0]),arr[1],arr[2],arr[3],
                        Integer.parseInt(arr[4]),arr[5],arr[6],arr[7],
                        Double.parseDouble(arr[8]),arr[9]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
