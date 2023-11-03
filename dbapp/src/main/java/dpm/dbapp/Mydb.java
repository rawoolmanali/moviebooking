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
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticketbooking", "root", "");
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int transactionID,String date,int screen,String showtime,int seatno,int totalamount)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `booking` VALUES ('"+ transactionID + "','" + date +"', '" + screen + "', '"+ showtime + "', '"+ seatno + "', '"+ totalamount +"')");
            String qs = "INSERT INTO `booking` VALUES ('"+ transactionID + "'" + date +"', '" + screen + "', '"+ showtime + "', '"+ seatno + "', '"+ totalamount +"')";
            System.out.println(qs);
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
        d.insert(12349, "12-Aug-2023",1 ,"12" , 230 , 250 );
    }
    
}
