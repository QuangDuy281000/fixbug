package Controller;

import Bean.Danhsach;
//import Dao.UploadfileExcel;
import Dao.nienluanDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/homecontroller")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if(request.getCharacterEncoding()!=null){
//            request.setCharacterEncoding("UTF-8");
//        }
//        UploadfileExcel.Loadfilexls(request,response);
//        RequestDispatcher rd = request.getRequestDispatcher("Views/Result.jsp");
//        rd.forward(request,response);

//        if (request.getCharacterEncoding() == null) {
//            request.setCharacterEncoding("UTF-8");
//        }
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("namefood");

        List<Danhsach> list = nienluanDao.SelectlistmenuSearch(name,request);

        request.setAttribute("list",list);

        request.setAttribute("name",name);
        RequestDispatcher rd = request.getRequestDispatcher("Views/Ring.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
