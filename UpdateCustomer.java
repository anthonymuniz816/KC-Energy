import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCustomer {
    public static void main(String[] args) {
        Update obj = new Update();
    }
}

class Update extends JFrame{

    JTextField txtfCustomer, txtfPhoneNumber, txtfAddress, txtfEnergy;
    JButton btnReturn, btnUpdate, btnNew, btnDelete;
    JLabel l1,lblTitle, lblCustomers, lblPhoneNumber, lblAddress, lblSpacer, lblEnergy;

    final double tariff = 0.12;
    String payment = "unpaid";


    public Update (){

        lblSpacer = new JLabel("");
        lblSpacer.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblSpacer.setPreferredSize(new Dimension(350, 20));

        lblTitle = new JLabel("KCMO ENERGY");
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblTitle.setPreferredSize(new Dimension(350, 100));

        lblCustomers = new JLabel("Customer:");
        lblCustomers.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblCustomers.setPreferredSize(new Dimension(150, 20));

        lblPhoneNumber = new JLabel("Phone Number:");
        lblPhoneNumber.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblPhoneNumber.setPreferredSize(new Dimension(150, 20));

        lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblAddress.setPreferredSize(new Dimension(150, 20));

        lblEnergy = new JLabel("Avg Energy Usage:");
        lblEnergy.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblEnergy.setPreferredSize(new Dimension(150, 20));

         txtfCustomer = new JTextField(20);
         txtfPhoneNumber = new JTextField(20);
         txtfAddress = new JTextField(20);
         txtfEnergy = new JTextField(20);

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

         btnUpdate = new JButton("Update");
         btnUpdate.setPreferredSize((new Dimension(490, 20)));
         btnUpdate.setHorizontalAlignment(SwingConstants.CENTER);
         btnUpdate.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {

                 if(txtfCustomer.getText().isEmpty() || txtfPhoneNumber.getText().isEmpty() || txtfAddress.getText().isEmpty() || txtfEnergy.getText().isEmpty()){
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
                     //statement.executeUpdate("DELETE FROM Customers WHERE name=" + txtfCustomer.getText()+"");
                     final String UPDATE_Customer = "UPDATE Customers set name = ?, phone = ?, address = ? , tariff = ?, energyUsage = ?, payment = ?";
                     PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Customer);
                     preparedStatement.setString(1,txtfCustomer.getText());
                     preparedStatement.setString(2,txtfPhoneNumber.getText());
                     preparedStatement.setString(3,txtfAddress.getText());
                     preparedStatement.setDouble(4, tariff);
                     preparedStatement.setDouble(5, Double.parseDouble(txtfEnergy.getText()));
                     preparedStatement.setString(6, payment);

                     System.out.println(preparedStatement);

                     // Step 3: Execute the query or update query
                     int results = preparedStatement.executeUpdate();
                     System.out.println(results);
                     if (results == 1) {
                         JOptionPane.showMessageDialog(null, "Customer was Updated!", "OK", JOptionPane.INFORMATION_MESSAGE);
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

        btnNew = new JButton("New");
        btnNew.setPreferredSize((new Dimension(490, 20)));
        btnNew.setHorizontalAlignment(SwingConstants.CENTER);
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if(txtfCustomer.getText().isEmpty() || txtfPhoneNumber.getText().isEmpty() || txtfAddress.getText().isEmpty() || txtfEnergy.getText().isEmpty()){
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
                    //statement.executeUpdate("DELETE FROM Customers WHERE name=" + txtfCustomer.getText()+"");
                    final String Insert_Customer = "INSERT INTO Customers (name, phone, address, tariff, energyUsage, payment)"+"VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(Insert_Customer);
                    preparedStatement.setString(1,txtfCustomer.getText());
                    preparedStatement.setString(2,txtfPhoneNumber.getText());
                    preparedStatement.setString(3,txtfAddress.getText());
                    preparedStatement.setDouble(4, tariff);
                    preparedStatement.setDouble(5, Double.parseDouble(txtfEnergy.getText()));
                    preparedStatement.setString(6, payment);

                    System.out.println(preparedStatement);

                    // Step 3: Execute the query or update query
                    int results = preparedStatement.executeUpdate();
                    System.out.println(results);
                    if (results == 1) {
                        JOptionPane.showMessageDialog(null, "New Customer was registered!", "OK", JOptionPane.INFORMATION_MESSAGE);
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
btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize((new Dimension(490, 20)));
        btnDelete.setHorizontalAlignment(SwingConstants.CENTER);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if(txtfCustomer.getText().isEmpty() || txtfPhoneNumber.getText().isEmpty() || txtfAddress.getText().isEmpty()){
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
                    //statement.executeUpdate("DELETE FROM Customers WHERE name=" + txtfCustomer.getText()+"");
                    final String DELETE_Customer = "DELETE FROM Customers where name = ?;";
                    String name = txtfCustomer.getText();

                    int results = CommonStatements.Delete(connection,DELETE_Customer, name);
                    System.out.println(results);
                    if (results == 1) {
                        JOptionPane.showMessageDialog(null, "Customer was Deleted.", "OK", JOptionPane.INFORMATION_MESSAGE);
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

        l1 = new JLabel("");

        add(btnReturn);
        add(lblSpacer);
        add(lblTitle);
        add(lblCustomers);
        add(txtfCustomer);
        add(lblPhoneNumber);
        add(txtfPhoneNumber);
        add(lblAddress);
        add(txtfAddress);
        add(lblEnergy);
        add(txtfEnergy);
        add(btnUpdate);
        add(btnNew);
        add(btnDelete);
        add(l1);


        setLayout(new FlowLayout(FlowLayout.CENTER)); //FlowLayout GridLayout Null
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}