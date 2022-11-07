import java.sql.*;
import java.util.Scanner;

public class Patients {
    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");

        }
        catch (Exception e) {
            System.out.println(e);
        }
        int choice;
        String name,address,symptoms,doctorname,phoneno;
        int patientid,pincode;
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("1.select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("insertdata");
                    System.out.println("enter patient id");
                    patientid=s.nextInt();
                    System.out.println("enter patient name");
                    name=s.next();
                    System.out.println("enter patient address");
                    address=s.next();
                    System.out.println("enter pincode");
                    pincode=s.nextInt();
                    System.out.println("enter phone number");
                    phoneno=s.next();
                    System.out.println("enter symptoms");
                    symptoms=s.next();
                    System.out.println("enter doctor name");
                    doctorname=s.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");

                        String sql="INSERT INTO `patients`( `patientid`, `name`, `address`, `pincode`, `phoneno`, `symptoms`, `doctorname`) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,patientid);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,pincode);
                        stmt.setString(5,phoneno);
                        stmt.setString(6,symptoms);
                        stmt.setString(7,doctorname);

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 2:
                    System.out.println("select data");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="SELECT `id`, `patientid`, `name`, `address`, `pincode`, `phoneno`, `symptoms`, `doctorname` FROM `patients`";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getpatientid=rs.getString("patientid");
                            String getname=rs.getString("name");
                            String getaddress=rs.getString("address");
                            String getpincode=rs.getString("pincode");
                            String getphone=rs.getString("phoneno");
                            String getsymptoms=rs.getString("symptoms");
                            String getdoctorname=rs.getString("doctorname");
                            System.out.println("patientid="+getpatientid);
                            System.out.println("name="+getname);
                            System.out.println("address="+getaddress);
                            System.out.println("pincode="+getpincode);
                            System.out.println("phoneno="+getphone);
                            System.out.println("symptoms="+getsymptoms);
                            System.out.println("doctorname="+getdoctorname);


                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 3:
                    System.out.println("search data");
                    System.out.println("enter patientid:");
                    patientid=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="SELECT `id`, `patientid`, `name`, `address`, `pincode`, `phoneno`, `symptoms`, `doctorname` FROM `patients` WHERE `patientid`="+String.valueOf(patientid);
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while(rs.next()){
                            String getpatientid=rs.getString("patientid");
                            String getname=rs.getString("name");
                            String getaddress=rs.getString("address");
                            String getpincode=rs.getString("pincode");
                            String getphone=rs.getString("phoneno");
                            String getsymptoms=rs.getString("symptoms");
                            String getdoctorname=rs.getString("doctorname");
                            System.out.println("patientid="+getpatientid);
                            System.out.println("name="+getname);
                            System.out.println("address="+getaddress);
                            System.out.println("pincode="+getpincode);
                            System.out.println("phoneno="+getphone);
                            System.out.println("symptoms="+getsymptoms);
                            System.out.println("doctorname="+getdoctorname);



                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 4:
                    System.out.println("update data");
                    System.out.println("enter patient id");
                    patientid=s.nextInt();
                    System.out.println("enter patient id");
                   String patient=s.next();
                    System.out.println("enter patient name to be updated");
                    name=s.next();
                    System.out.println("enter patient address to be updated");
                    address=s.next();
                    System.out.println("enter pincode to be updated");
                    pincode=s.nextInt();
                    System.out.println("enter phone number to be updated");
                    phoneno=s.next();
                    System.out.println("enter symptom to be updated");
                    symptoms=s.next();
                    System.out.println("enter doctor name to be updated");
                    doctorname=s.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="UPDATE `patients` SET `patientid`='"+String.valueOf(patient)+"' ,`name`='"+name+"',`address`='"+address+"',`pincode`='"+String.valueOf(pincode)+"',`phoneno`='"+phoneno+"',`symptoms`='"+symptoms+"',`doctorname`='"+doctorname+"' WHERE `patientid`="+String.valueOf(patientid);
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("inserted successfully");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }




                case 5:
                    System.out.println("delete data");
                    System.out.println("enter patient id:");
                    String code=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="DELETE FROM `patients` WHERE `patientid`="+code;
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                case 6:
                    System.out.println("exit");
                    System.exit(0);
                    break;
            }
        }
    }
}



