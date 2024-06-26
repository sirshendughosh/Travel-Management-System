
package travel.management.system;
import javax.swing.*;


public class Paytm  extends JFrame{
    
    Paytm(){
        
        setBounds(500, 200, 800, 600);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
            
            pane.setPage("https://paytm.com/");
            
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could Not Load, Error 404</html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        setVisible(true);
        
    }
    
    
    
    
    public static void main(String[] args) {
        new Paytm();
    }
    
}
