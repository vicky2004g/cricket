/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpm.dbapp;
import java.sql.*;

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver");
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket",
                        "root", "");
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int matchno,String teamA,String teamB,int score,int overno,String overby,int wickets,int runs,int noballs,int extras)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `sboard`  VALUES ('"+matchno + "', '" + teamA + "', '" +teamB + "', '" +score+ "', '" +overno+ "', '" +overby+ "', '" +wickets+ "', '" +runs+ "', '" +noballs+ "', '" +extras+ "')");
            System.out.println(st.execute());
            /*if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }*/
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert(12,"India","Pakistan",125,15,"Virat",2,10,1,2);
    }
    
}
