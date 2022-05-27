package Controller_Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.domain.Student;

@WebServlet("/update")
public class findForUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置字符编码，避免出现乱码

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int age = Integer.parseInt(request.getParameter("age"));
        float weight = Float.parseFloat(request.getParameter("weight"));
        float height = Float.parseFloat(request.getParameter("height"));

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setSex(sex);
        student.setAge(age);
        student.setWeight(weight);
        student.setHeight(height);

        StudentDAO run=new StudentDAO();
        try {
            run.update(student);
            request.getRequestDispatcher("succeed.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
