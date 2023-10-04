package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Student;
import model.User;

public class UserDao {
    private static final String LOGIN = "select [UserName] from [user] where [UserName]=? and [Password]=?";
    private static final String GETDATA = "select [UserId], [UserName],[Role] from [user] where [UserName]=? and [Password]=?";
    private static final String SEARCH = "select [UserId], [UserName],[Role] from [user] where [UserName] LIKE ? ";
    private static final String ROLE =  "select [Role] from [user] where [UserName]=? and [Password]=?";
    private static final String SQLG = "SELECT * FROM [Student]";
    private static final String SQL = "SELECT * FROM [Student] WHERE [Id]=?";
    private static final String SQLUPDATE = "UPDATE [Student] SET [Name]=?,[Gender]=?,[DOB]=? WHERE [Id]=?";
    private static final String SQLDELETE = "DELETE FROM [Student] WHERE [Id]=?";
    private static final String SQLCREATE = "INSERT INTO [Student]([Name],[Gender],[DOB]) VALUES (?,?,?)";
    public static ArrayList<Student> getSList(){
        ArrayList<Student> list = new ArrayList<>();
        PreparedStatement  ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection1()) {
            if (con != null) {
                ptm = con.prepareStatement(SQLG);
                rs = ptm.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("Id");
                    String name = rs.getString("Name");
                    boolean gender = rs.getBoolean("Gender");
                    Date DOB = rs.getDate("DOB");
                    Student s = new Student(id, name, gender, DOB);
                    list.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Student getStudent(int id){
        Student s = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection1()){
            ptm = con.prepareStatement(SQL);
            ptm.setInt(1, id);
            rs = ptm.executeQuery();
            if(rs.next()){
                int Id = rs.getInt("Id");
                String name = rs.getString("Name");
                Byte gender = rs.getByte("Gender");
                boolean gen = true;
                if(gender.equals((byte)0)) gen = false;
                Date date = rs.getDate("DOB");
                s = new Student(Id, name, gen, date);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
    public static void deleteStudent(int id){
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection1()){
            ptm = con.prepareStatement(SQLDELETE);
            ptm.setInt(1, id);
            ptm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void updateStudent(int id, String name,String gender, String dob){
        PreparedStatement ptm = null;
        byte gen = 1;
        if(gender.equals("F")) gen = 0;
        // create a DateTimeFormatter object with the pattern "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // parse the date string using the formatter object
        LocalDate date = LocalDate.parse(dob, formatter);
        // convert the LocalDate object to a java.sql.Date object
        Date sqlDate = Date.valueOf(date);
        try (Connection con = SQLConnection.getConnection1()){
            ptm = con.prepareStatement(SQLUPDATE);
            ptm.setString(1, name);
            ptm.setByte(2, gen);
            ptm.setDate(3, sqlDate);
            ptm.setInt(4, id);
            ptm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createStudent(String name,String gender, String dob){
        PreparedStatement ptm = null;
        byte gen = 1;
        if(gender.equals("F")) gen = 0;
        // create a DateTimeFormatter object with the pattern "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // parse the date string using the formatter object
        LocalDate date = LocalDate.parse(dob, formatter);
        // convert the LocalDate object to a java.sql.Date object
        Date sqlDate = Date.valueOf(date);
        try (Connection con = SQLConnection.getConnection1()){
            ptm = con.prepareStatement(SQLCREATE);
            ptm.setString(1, name);
            ptm.setByte(2, gen);
            ptm.setDate(3, sqlDate);
            ptm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public boolean checkLogin(String username, String password){
        boolean check = false;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection()) {
            if (con != null) {
                ptm = con.prepareStatement(LOGIN);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean checkRole(String username, String password)
    {
        boolean check = false;
        PreparedStatement  ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection()) {
            if (con != null) {
                ptm = con.prepareStatement(ROLE);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()){
                    String role = rs.getString("Role");
                    System.out.println(role);
                    if(role.equals("ad")) check = true ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public static User getUser(String username, String password){
        User user = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection()){
            if(con!=null){
                ptm = con.prepareStatement(GETDATA);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()){
                    int id = rs.getInt("UserId");
                    String name = rs.getString("UserName");
                    String role = rs.getString("Role");
                    user = new User(id,name,"*****",role);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public static ArrayList<User> searchUser(String username){
        User user = null;
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try (Connection con = SQLConnection.getConnection()){
            if(con!=null){
                ptm = con.prepareStatement(SEARCH);
                ptm.setString(1, '%'+username+'%');
                rs = ptm.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("UserId");
                    String name = rs.getString("UserName");
                    String role = rs.getString("Role");
                    user = new User(id,name,"*****",role);
                    //System.out.println(user);
                    users.add(user);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }
    
    public static void main(String[] args) {
        System.out.println(getSList());   
    }
}
