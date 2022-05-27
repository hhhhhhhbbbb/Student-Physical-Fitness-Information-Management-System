package Controller_Servlet;

import com.dao.StudentDAO;
import com.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/insert")
public class Insert_date extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        Student stu=new Student();
        stu.setId(Integer.parseInt(request.getParameter("id")));
        stu.setName(request.getParameter("name"));
        stu.setSex(request.getParameter("sex"));
        stu.setAge(Integer.parseInt(request.getParameter("age")));
        stu.setWeight(Float.parseFloat(request.getParameter("weight")));
        stu.setHeight(Float.parseFloat(request.getParameter("height")));
        StudentDAO stu2=new StudentDAO();
        try {
            stu2.create(stu);
            request.getRequestDispatcher("succeed.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
