package com.dao;
import java.sql.*;

import com.db.DBConnect;
import com.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    protected static final String  FIELDS_INSERT ="id,name,sex,age,weight,height";
    //protected static final String  FIELDS_RETURN ="id, " + FIELDS_INSERT;
    protected static String INSERT_SQL="insert into stu_info ("+FIELDS_INSERT+")"+"values (?,?,?,?,?,?)";
    protected static String SELECT_SQL="select "+FIELDS_INSERT+" from stu_info where id=?";
    protected static String UPDATE_SQL="update stu_info set id=?,name=?,sex=?,age=?,weight=?,height=? where id=?";
    protected static String DELETE_SQL ="delete from stu_info where name=?";


    @Override
    public Student create(Student stu) throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        try{
            con = DBConnect.getDBconnection();
            prepStmt =con.prepareStatement(INSERT_SQL);
            prepStmt.setInt(1,stu.getId());
            prepStmt.setString(2,stu.getName());
            prepStmt.setString(3,stu.getSex());
            prepStmt.setInt(4,stu.getAge());
            prepStmt.setFloat(5,stu.getWeight());
            prepStmt.setFloat(6,stu.getHeight());
            prepStmt.executeUpdate();
        } catch(Exception e){
            //
        } finally{
            DBConnect.closeDB(con, prepStmt, rs);
        }
        return stu;
    }

    @Override
    public int remove(Student stu) throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        int n=0;
        try {
            con=DBConnect.getDBconnection();
            prepStmt = con.prepareStatement(DELETE_SQL);
            prepStmt.setString(1,stu.getName());
            n=prepStmt.executeUpdate();
        }catch(Exception e) {
            //
        } finally{
            DBConnect.closeDB(con, prepStmt, rs);
        }
        return n;

    }

    @Override
    public Student find(Student stu) throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        Student stu2 = null;
        try {
            con=DBConnect.getDBconnection();
            prepStmt = con.prepareStatement(SELECT_SQL);
            prepStmt.setInt(1,stu.getId());
            rs = prepStmt.executeQuery();
            if (rs.next()){
                stu2 = new Student();
                stu2.setId(rs.getInt(1));
                stu2.setName(rs.getString(2));
                stu.setSex(rs.getString(3));
                stu2.setAge(rs.getInt(4));
                stu2.setWeight(rs.getFloat(5));
                stu2.setHeight(rs.getFloat(6));
            }
        } catch (Exception e) {
            // handle exception
        } finally {
            DBConnect.closeDB(con, prepStmt, rs);
        }
        return stu2;
    }

    @Override
    public List<Student> findAll() throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        List<Student> student = new ArrayList<Student>();
        con=DBConnect.getDBconnection();
        prepStmt = con.prepareStatement("select * from stu_info");
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            Student stu2 = new Student();
            stu2.setId(rs.getInt(1));
            stu2.setName(rs.getString(2));
            stu2.setSex(rs.getString(3));
            stu2.setAge(rs.getInt(4));
            stu2.setWeight(rs.getFloat(5));
            stu2.setHeight(rs.getFloat(6));
            student.add(stu2);
        }
        DBConnect.closeDB(con, prepStmt, rs);
        return student;
    }

    @Override
    public void update(Student stu) throws Exception {
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        try {
            con=DBConnect.getDBconnection();
            prepStmt = con.prepareStatement(UPDATE_SQL);
            prepStmt.setInt(1,stu.getId());
            prepStmt.setString(2,stu.getName());
            prepStmt.setString(3,stu.getSex());
            prepStmt.setInt(4,stu.getAge());
            prepStmt.setFloat(5,stu.getWeight());
            prepStmt.setFloat(6,stu.getHeight());
            prepStmt.setInt(7,stu.getId());
            int rowCount=prepStmt.executeUpdate();
            if(rowCount==0) {
                throw new Exception("Update Error:Student Id:"+stu.getId());
            }
        }
        catch(Exception e) {
        }
        finally {
            DBConnect.closeDB(con, prepStmt, rs);
        }
    }
}

