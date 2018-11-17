package Welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SearcheNurse extends JFrame implements ActionListener{
    JLabel JL_id;
    JTextField JT_id;
    JButton btn_search;

      public SearcheNurse(){
          super("Search");
          JL_id = new JLabel("Enter ID:");
          JL_id.setBounds(40, 40, 200, 40);
          JT_id = new JTextField(20);
          JT_id.setBounds(130, 40, 150, 40);
          btn_search = new JButton("Search");
          btn_search.setBounds(300, 40, 80, 40);
          btn_search.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,200);
          setLayout(null);
          add(btn_search);
          add(JL_id);
          add(JT_id);
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
    Function f = new Function();
    ResultSet rs = null;
   // String fn = "fname";

    
    rs = f.find(JT_id.getText());
    try{
      if(rs.next()){
         // qui tu  va afficher
      }  else{
          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
      }
    }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
   public class Function{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
           con = DriverManager.getConnection("jdbc:mysql://localhost/test_db","root","");
           ps = con.prepareStatement("select * from users where id = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   }
}

