package busbooking;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EditBus extends javax.swing.JInternalFrame {
    int index;
    String busno;

    public EditBus() {
        initComponents();
        loadBusDetails();
    }

    private void loadBusDetails() {
        Connection con;
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            st = con.createStatement();
            String s = "SELECT * FROM bus_detail";
            rs = st.executeQuery(s);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cb2 = new javax.swing.JComboBox<>();
        cb1 = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(775, 400));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24));
        jLabel1.setText("All Bus Details");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24));
        jLabel2.setText("Edit Bus Detail");

        jTable1.setFont(new java.awt.Font("Verdana", 0, 14));
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Bus No.", "Source", "Destination", "Time", "Price", "Seats"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel3.setText("Bus No.");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel7.setText("Seats");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setText("Source");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel5.setText("Destination");

        jButton2.setFont(new java.awt.Font("Verdana", 0, 18));
        jButton2.setText("Reset");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel6.setText("Time");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel8.setText("Price");

        t2.setFont(new java.awt.Font("Verdana", 0, 18));
        t1.setFont(new java.awt.Font("Verdana", 0, 18));
        t5.setFont(new java.awt.Font("Verdana", 0, 18));
        t6.setFont(new java.awt.Font("Verdana", 0, 18));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 18));
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        cb2.setFont(new java.awt.Font("Verdana", 0, 18));
        cb2.setModel(new DefaultComboBoxModel<>(new String[] {
            " ", "Bahirdar", "AA", "Dessie", "Adama", "D/Tabor" }));

        cb1.setFont(new java.awt.Font("Verdana", 0, 18));
        cb1.setModel(new DefaultComboBoxModel<>(new String[] {
            " ", "AA", "Kombolcha", "Dessie", "Hawassa", "Adama", "Jimma"}));

        // Layout setup
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(t5, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(cb1, 0, 1, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addGap(21, 21, 21)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(jButton2)))
                                .addGap(95, 95, 95)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        busno = (String) model.getValueAt(index, 0);

        int result = JOptionPane.showConfirmDialog(null, "Want to Edit?", "Sure !!!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            loadBusData(busno);
        }
    }

    private void loadBusData(String busno) {
        Connection con;
        Statement st;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            st = con.createStatement();
            String s = "SELECT * FROM bus_detail WHERE Bus_No='" + busno + "'";
            rs = st.executeQuery(s);
            if (rs.next()) {
                t1.setText(rs.getString("Bus_No"));
                cb1.setSelectedItem(rs.getString("Source"));
                cb2.setSelectedItem(rs.getString("Destination"));
                t2.setText(rs.getString("Time"));
                t5.setText(rs.getString("Price"));
                t6.setText(rs.getString("Seats"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
        resetFields();
    }

    private void resetFields() {
        t1.setText("");
        t2.setText("");
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
        t5.setText("");
        t6.setText("");
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        Connection con;
        Statement st;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanage", "root", "");
            st = con.createStatement();
            String updateQuery = "UPDATE bus_detail SET Bus_No='" + t1.getText() + "', Source='" + cb1.getSelectedItem() + "', Destination='" + cb2.getSelectedItem() + "', Time='" + t2.getText() + "', Price=" + Integer.parseInt(t5.getText()) + ", Seats=" + Integer.parseInt(t6.getText()) + " WHERE Bus_No='" + busno + "'";
            st.executeUpdate(updateQuery);
            resetFields();
            JOptionPane.showMessageDialog(null, "Edited Successfully", "Done", JOptionPane.INFORMATION_MESSAGE);
            refreshBusDetails();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void refreshBusDetails() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows
        loadBusDetails(); // Reload bus details
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bus Booking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            EditBus editBusFrame = new EditBus();
            frame.getContentPane().add(editBusFrame);
            frame.setVisible(true);
            editBusFrame.setVisible(true);
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    // End of variables declaration
}