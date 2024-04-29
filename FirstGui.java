import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstGui {
    public static void main(String[] args) {
        First obj = new First();
    }
}

class First extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton btnUpdateCustomer, btnDisplayEnergy, btnInvoice,btnPayment;
    JLabel l1,lblTitle, lblCustomers, lblPhoneNumber, lblAddress;

    public First (){

        lblTitle = new JLabel("KCMO ENERGY");
        lblTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblTitle.setPreferredSize(new Dimension(350, 100));

        btnUpdateCustomer = new JButton("Record/Update/ Delete Customer");
        btnUpdateCustomer.setPreferredSize((new Dimension(490, 20)));
        btnUpdateCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        btnUpdateCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update();
                dispose();
            }
        });

        btnDisplayEnergy = new JButton("Display Energy Usage");
        btnDisplayEnergy.setPreferredSize((new Dimension(490, 20)));
        btnDisplayEnergy.setHorizontalAlignment(SwingConstants.CENTER);
        btnDisplayEnergy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EUsage();
                dispose();
            }
        });

        btnInvoice = new JButton("Invoice");
        btnInvoice.setPreferredSize((new Dimension(490, 20)));
        btnInvoice.setHorizontalAlignment(SwingConstants.CENTER);
        btnInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new displayInvoice();
                dispose();
            }
        });

        btnPayment = new JButton("Record Payment");
        btnPayment.setPreferredSize((new Dimension(490, 20)));
        btnPayment.setHorizontalAlignment(SwingConstants.CENTER);
        btnPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new displayPayment();
                dispose();
            }
        });

        l1 = new JLabel("");

        add(lblTitle);
        add(btnUpdateCustomer);
        add(btnDisplayEnergy);
        add(btnInvoice);
        add(btnPayment);
        add(l1);

        btnUpdateCustomer.addActionListener(this); //ActionListener is an interface

        setLayout(new FlowLayout(FlowLayout.CENTER)); //FlowLayout GridLayout Null
        setVisible(true);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        System.out.println("It Works!");
    }
}