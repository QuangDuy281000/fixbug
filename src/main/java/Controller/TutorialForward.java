package Controller;

import Bean.Danhsach;
import Dao.nienluanDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tutorialforward")
public class TutorialForward extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String monanidstr = request.getParameter("monanid");
        int monanid = Integer.parseInt(monanidstr);

        Danhsach danhsach = nienluanDao.displaymenu(monanid);

        request.setAttribute("danhsach",danhsach);

        RequestDispatcher rd = request.getRequestDispatcher("Views/Result.jsp");
        rd.forward(request,response);

    }
}
