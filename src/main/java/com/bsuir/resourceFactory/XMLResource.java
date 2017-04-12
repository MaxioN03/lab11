package com.bsuir.resourceFactory;

import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 10.04.17.
 */
public class XMLResource implements Resource {

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
        try {
            File inputFile = new File("E:\\Uchoba\\6\\Ситиод\\Lab 11\\src\\main\\resources\\schedule.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("bus");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    result.add(new Bus(Integer.parseInt(eElement.getElementsByTagName("number").item(0).getTextContent()),
                            eElement.getElementsByTagName("departure-date").item(0).getTextContent(),
                            eElement.getElementsByTagName("departure-time").item(0).getTextContent(),
                            eElement.getElementsByTagName("departure-station").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("departure-platform").item(0).getTextContent()),
                            eElement.getElementsByTagName("arrival-station").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("cost").item(0).getTextContent()),
                            eElement.getElementsByTagName("mark").item(0).getTextContent(),
                            eElement.getElementsByTagName("time").item(0).getTextContent()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //todo Расписание поездов
    private List<Train> getTrainSchedule() {
        List<Train> result = new LinkedList<Train>();
        try {
            File inputFile = new File("E:\\Uchoba\\6\\Ситиод\\Lab 11\\src\\main\\resources\\schedule.xml");
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("train");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    result.add(new Train(Integer.parseInt(eElement.getElementsByTagName("number").item(0).getTextContent()),
                            eElement.getElementsByTagName("departure-date").item(0).getTextContent(),
                            eElement.getElementsByTagName("departure-time").item(0).getTextContent(),
                            eElement.getElementsByTagName("departure-station").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("departure-platform").item(0).getTextContent()),
                            eElement.getElementsByTagName("arrival-station").item(0).getTextContent(),
                            eElement.getElementsByTagName("arrival-date").item(0).getTextContent(),
                            eElement.getElementsByTagName("arrival-time").item(0).getTextContent(),
                            Double.parseDouble(eElement.getElementsByTagName("cost").item(0).getTextContent()),
                            eElement.getElementsByTagName("ticket").item(0).getTextContent()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
