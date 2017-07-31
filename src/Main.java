/**
 * Created by Игорь on 18.07.2017.
 */
import fileIO.FileRW;

import java.sql.*;


public class Main {

        public static void main(String[] args) throws SQLException {
           Connection con = null;
           Statement st = null;
           ResultSet rs = null;
           FileRW fileRW = new FileRW();

           fileRW.queryList();
           fileRW.fileW();

           try {
               /*Driver d = (Driver)*/ Class.forName("org.sqlite.JDBC").newInstance();

               String url = fileRW.getList().get(0);   //"jdbc:sqlite:C:\\Users\\Игорь\\Google Диск\\Java\\JDBC\\carShop.db";

               con = DriverManager.getConnection(url);

               String sql = "select * from spr_Model";

               st = con.createStatement();
               rs = st.executeQuery(sql);


               while (rs.next()){
                   System.out.println(rs.getString("name_ru") + " - " + rs.getString("name_en"));
               }

           } catch (Exception e){

           } finally {
               if (!(rs == null)) rs.close();
               if (!(st == null)) st.close();
               if (!(con ==null)) con.close();
           }
        }


}
