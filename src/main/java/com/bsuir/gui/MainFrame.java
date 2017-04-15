package com.bsuir.gui;

import com.bsuir.AbstractFactory;
import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;
import com.bsuir.entity.Vehicle;
import com.bsuir.resourceFactory.Resource;
import com.bsuir.resourceFactory.ResourceFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class MainFrame extends JDialog {
    AbstractFactory factory = new ResourceFactory();
    Resource resource;
    List<? extends Vehicle> list;
    String type;


    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton XMLRadioButton;
    private JRadioButton CSVRadioButton;
    private JRadioButton BusRadioButton;
    private JRadioButton TrainRadioButton;
    private JTextArea ShowArea;
    private JButton ShowButton;
    private JTable table1;
    private JTable table2;
    private JTabbedPane tabbedPane1;
    DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
    DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
    private final String[] columnsBus = {"Номер", "Дата отпр.", "Время отпр.", "Станиця отпр.", "Платформа", "Станция пр.", "Цена",
            "Марка", "Время в пути"};
    private final String[] columnsTrain = {"Номер", "Дата отпр.", "Время отпр.", "Станиця отпр.", "Платформа", "Станция пр.",
            "Дата пр.", "Время пр.", "Цена", "Тип билета"};

    public MainFrame() {
        resource = factory.getResource("XML");
        type = "BUS";

        for (String column : columnsBus) {
            model1.addColumn(column);
        }
        for (String column : columnsTrain) {
            model2.addColumn(column);
        }

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ShowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list = resource.getResource(type);

                Vector<String> vector = new Vector<String>();

                switch (type) {
                    case "BUS":
                        int rowCount = model1.getRowCount();
                        for (int i = rowCount - 1; i >= 0; i--) {
                            model1.removeRow(i);
                        }

                        List<Bus> listBus = (List<Bus>) list;

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
                            model1.addRow(vector);
                        }
                        break;
                    case "TRAIN":
                        rowCount = model2.getRowCount();
                        for (int i = rowCount - 1; i >= 0; i--) {
                            model2.removeRow(i);
                        }

                        List<Train> listTrain = (List<Train>) list;

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
                            model2.addRow(vector);
                        }
                        break;
                }
            }
        });

        XMLRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resource = factory.getResource("XML");
            }
        });
        CSVRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resource = factory.getResource("CSV");
            }
        });
        BusRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                type = "BUS";
            }
        });
        TrainRadioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                type = "TRAIN";
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {

        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
