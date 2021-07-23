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
import java.util.List;

@WebServlet("/homeforward")
public class HomeForward extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageidtr = request.getParameter("pageid");
        int pageid = Integer.parseInt(pageidtr);
        int pagesize = 9;
        List<Danhsach> list =nienluanDao.Paginaton(pageid,pagesize);
        int count = nienluanDao.GetCount();
        int total = count/pagesize;
        if(count % pagesize > 0){
            total = total +1;
        }
        request.setAttribute("pageid",pageid);
        request.setAttribute("list",list);
        request.setAttribute("total",total);
        RequestDispatcher rd = request.getRequestDispatcher("Views/listmenu.jsp");
        rd.forward(request,response);
    }
}
