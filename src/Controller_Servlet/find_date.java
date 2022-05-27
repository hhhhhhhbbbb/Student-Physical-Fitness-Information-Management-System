package Controller_Servlet;

import com.dao.StudentDAO;
import com.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find")
public class find_date extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("GB2312");
        Student stu=new Student();
        stu.setId(Integer.parseInt(request.getParameter("id")));
        StudentDAO stu2=new StudentDAO();
        try {
            stu=stu2.find(stu);
            request.setAttribute("stu", stu);
            request.getRequestDispatcher("find_show.jsp").forward(request, response);
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
