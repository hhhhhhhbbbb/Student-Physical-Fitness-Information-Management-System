package Controller_Servlet;

import java.io.IOException;

import com.dao.StudentDAO;
import com.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/delete")
public class Delete_date extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        Student a = new Student();
        a.setName(name);
        StudentDAO studentDao = new StudentDAO();
        try {
            studentDao.remove(a);
            request.getRequestDispatcher("/succeed.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

