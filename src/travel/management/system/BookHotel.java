
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.ResultSet;




public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel, cac, cfood;
    JTextField tfdays, tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    
    BookHotel(String username){
        this.username = username;
        setBounds(350, 200, 1000, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("BOOK HOTEL");   
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma",Font.BOLD, 25));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 200, 20);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblpackage.setBounds(40, 110, 150, 20);
        add(lblpackage);
        
       chotel = new Choice();
       chotel.setBounds(250, 110, 200, 20);
       add(chotel);
       
       try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select *  from hotel");
         while(rs.next()){
             chotel.add(rs.getString("name"));
         }
       }catch(Exception e){
           e.printStackTrace();
       }
        
        JLabel lblpersons = new JLabel("Total Person");
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblpersons.setBounds(40, 150, 150, 25);
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No. of Days:");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/Non-AC:");
        lblac.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        add(lblac);
        
       cac = new Choice();
       cac.add("AC");
       cac.add("NON AC");
       cac.setBounds(250, 230, 200, 20);
       add(cac);
       
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);
        
       cfood = new Choice();
       cfood.add("YES");
       cfood.add("NO");
       cfood.setBounds(250, 270, 200, 20);
       add(cfood);




        
        
        
        JLabel lblid = new JLabel("ID");
        lblid.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add (labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 200, 25);
        add (labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 290, 200, 25);
        add (labelphone);
        
         JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 200, 25);
        add (labelprice);
        
        
         try{
            Conn conn = new Conn();
            String query ="select * from customer where username = '"+username+"'";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
               



           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        URL loc = ClassLoader.getSystemResource("icons/book.jpg");
        if (loc == null){
            System.err.println("Image not found");
            return;
        }
        ImageIcon imageIcon = new ImageIcon(loc);
        Image i4 = imageIcon.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel image = new JLabel(i5);
        image.setBounds(500, 50, 600, 400);
        add(image);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincuded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int person = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(person * days > 0){
                    int total = 0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("YES") ? food : 0;
                    total += cost;
                    total = total * person * days;
                    labelprice.setText("Rs "+total);
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter a vaid Number");
                }
            }
           
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == bookpackage){
            try{
              Conn c = new Conn();
              String query = "insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getSelectedText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')";
              c.s.executeUpdate(query);

              JOptionPane.showMessageDialog(null, "Hotel Bookes Successfully");
              setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args) {
        new BookHotel("");
    }
    
}
