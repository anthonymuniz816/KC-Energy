import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class EnergyUsage {
    public static void main(String[] args) {
        EUsage obj  = new EUsage();
    }
}

class EUsage extends JFrame{

    JLabel lblTitle, lblCustomers, lblSpacer;
    JTextField txtfCustomerName;
    JButton btnReturn, btnInfo;

    public EUsage(){

        lblSpacer = new JLabel("");
        lblSpacer.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblSpacer.setPreferredSize(new Dimension(350, 20));

        lblTitle = new JLabel("KCMO ENERGY");
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblTitle.setPreferredSize(new Dimension(350, 100));

        lblCustomers = new JLabel("Customer's Name:");
        lblCustomers.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblCustomers.setPreferredSize(new Dimension(150, 20));

        txtfCustomerName = new JTextField(20);

        btnReturn = new JButton("return");
        btnReturn.setPreferredSize((new Dimension(100, 20)));
        btnReturn.setHorizontalAlignment(SwingConstants.CENTER);
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new First();
                dispose();
            }
        });
        btnInfo= new JButton("Display Info");
        btnInfo.setPreferredSize((new Dimension(490, 20)));
        btnInfo.setHorizontalAlignment(SwingConstants.CENTER);
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(txtfCustomerName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                final String DB_URL = "jdbc:mysql://localhost:3306/jbdc";
                final String USERNAME = "root";
                final String PASSWORD = "Realmadrid13";
                try{
                    Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    //Connected to database successfully

                    Statement statement = connection.createStatement();

                    ResultSet resultSet = statement.executeQuery("select * from Customers");


                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String phone = resultSet.getString("phone");
                        String address = resultSet.getString("address");
                        double energyUsage = resultSet.getDouble("energyUsage");

                        if(Objects.equals(name.toUpperCase(), txtfCustomerName.getText().toUpperCase())) {
                            JOptionPane.showMessageDialog(null, "Name: " + name + "\n" + "Phone Number: " + phone + "\n" + "Address: " + address + "\n\nCustomer's Monthly Avg Usage: " + energyUsage+ "kWh", "Customer Energy Usage", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            System.out.println("skipped"+name);
                            continue;
                        }
                    }

                    statement.close();
                    connection.close();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        add(btnReturn);
        add(lblSpacer);
        add(lblTitle);
        add(lblCustomers);
        add(txtfCustomerName);
        add(btnInfo);

        setLayout(new FlowLayout(FlowLayout.CENTER)); //FlowLayout GridLayout Null
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}