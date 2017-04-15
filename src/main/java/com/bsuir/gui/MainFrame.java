package com.bsuir.gui;

import com.bsuir.AbstractFactory;
import com.bsuir.entity.Bus;
import com.bsuir.entity.Train;
import com.bsuir.entity.Vehicle;
import com.bsuir.resourceFactory.Resource;
import com.bsuir.resourceFactory.ResourceFactory;
import com.bsuir.search.StationSeeker;

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
    private JRadioButton XMLRadioButton;
    private JRadioButton CSVRadioButton;
    private JRadioButton BusRadioButton;
    private JRadioButton TrainRadioButton;
    private JTextArea ShowArea;
    private JButton ShowButton;
    private JTable table1;
    private JTable table2;
    private JTabbedPane tabbedPane1;
    private JRadioButton ArrRadioButton;
    private JRadioButton DepRadioButton;
    private JTextField SearchField1;
    private JButton SearchButton;
    private JTable MarkedBusTable;
    private JTable MarkedTrainTable;
    private JButton AddToMarkedButton;
    private JButton удалитьИзОтмеченныхButton;
    private JButton удалитьАвтобусButton;
    DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
    DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
    DefaultTableModel MarkedBusModel = (DefaultTableModel) MarkedBusTable.getModel();
    DefaultTableModel MarkedTrainModel = (DefaultTableModel) MarkedTrainTable.getModel();

    private final String[] columnsBus = {"Номер", "Дата отпр.", "Время отпр.", "Станиця отпр.", "Платформа", "Станция пр.", "Цена",
            "Марка", "Время в пути"};
    private final String[] columnsTrain = {"Номер", "Дата отпр.", "Время отпр.", "Станиця отпр.", "Платформа", "Станция пр.",
            "Дата пр.", "Время пр.", "Цена", "Тип билета"};

    public MainFrame() {
        DepRadioButton.setSelected(true);
        resource = factory.getResource("XML");
        type = "BUS";

        for (String column : columnsBus) {
            model1.addColumn(column);
            MarkedBusModel.addColumn(column);
        }
        for (String column : columnsTrain) {
            model2.addColumn(column);
            MarkedTrainModel.addColumn(column);
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

                switch (type) {
                    case "BUS":
                        tabbedPane1.setSelectedIndex(0);

                        Util.clearTable(model1);

                        List<Bus> listBus = (List<Bus>) list;

                        Util.setBusListAtTable(model1, listBus);
                        break;
                    case "TRAIN":
                        tabbedPane1.setSelectedIndex(1);

                        Util.clearTable(model2);

                        List<Train> listTrain = (List<Train>) list;
                        Util.setTrainListAtTable(model2, listTrain);
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
        SearchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                list = resource.getResource(type);

                switch (type) {
                    case "BUS":
                        tabbedPane1.setSelectedIndex(0);
                        Util.clearTable(model1);
                        List<Bus> listBus = (List<Bus>) list;

                        if (DepRadioButton.isSelected()) {
                            Util.setBusListAtTable(model1, StationSeeker.searchBusByDepStation(listBus, SearchField1.getText()));
                        } else {
                            Util.setBusListAtTable(model1, StationSeeker.searchBusByArrStation(listBus, SearchField1.getText()));
                        }
                        break;
                    case "TRAIN":
                        tabbedPane1.setSelectedIndex(1);
                        Util.clearTable(model2);
                        List<Train> listTrain = (List<Train>) list;

                        if (DepRadioButton.isSelected()) {
                            Util.setTrainListAtTable(model2, StationSeeker.searchTrainByDepStation(listTrain, SearchField1.getText()));
                        } else {
                            Util.setTrainListAtTable(model2, StationSeeker.searchTrainByArrStation(listTrain, SearchField1.getText()));
                        }
                        break;
                }

            }
        });
        AddToMarkedButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Vector<String> vector = new Vector<String>();

                if (tabbedPane1.getSelectedIndex() == 0) {
                    int selected = table1.getSelectedRow();
                    int rowCount = model1.getColumnCount();

                    for (int i = 0; i <= rowCount - 1; i++) {
                        vector.add(String.valueOf(table1.getValueAt(selected, i)));
                    }
                    MarkedBusModel.addRow(vector);
                } else if (tabbedPane1.getSelectedIndex() == 1) {
                    int selected = table2.getSelectedRow();
                    int rowCount = model2.getColumnCount();

                    for (int i = 0; i <= rowCount - 1; i++) {
                        vector.add(String.valueOf(table2.getValueAt(selected, i)));
                    }
                    MarkedTrainModel.addRow(vector);
                }

            }
        });
        удалитьИзОтмеченныхButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected2 = MarkedTrainTable.getSelectedRow();
                MarkedTrainModel.removeRow(selected2);


            }
        });
        удалитьАвтобусButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selected1 = MarkedBusTable.getSelectedRow();
                MarkedBusModel.removeRow(selected1);
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
