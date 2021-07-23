package Dao;

import Bean.Danhsach;
import DB.DBconnection;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploadfileExcel {

    // ham upload file excel
    public static void Loadfilexls(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = DBconnection.CreateConnection();
        InputStream inp;
        try {
            inp = new FileInputStream("D://testnienluan.xls");
            HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
            Sheet sheet = wb.getSheetAt(0);
            //row = hang; cell = cot
            for (int i = 1;i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                int monanid = (int) row.getCell(0).getNumericCellValue(); //lay tung cot
                String danhmuctu = row.getCell(1).getStringCellValue();
                String gioithieu = row.getCell(2).getStringCellValue();
                String nguyenlieu = row.getCell(3).getStringCellValue();
                String cachlam = row.getCell(4).getStringCellValue();
                String chuy = row.getCell(5).getStringCellValue();

                Danhsach danhsach = new Danhsach();
                danhsach.setMonanid(monanid);
                danhsach.setDanhmuctu(danhmuctu);
                danhsach.setGioithieu(gioithieu);
                danhsach.setNguyenlieu(nguyenlieu);
                danhsach.setCachlam(cachlam);
                danhsach.setChuy(chuy);

                UploadfileExcel.InsertData(request,danhsach);
            }
            wb.close();
        } catch (FileNotFoundException e) {
            request.setAttribute("mess",e.getMessage());
        } catch (IOException e) {
            request.setAttribute("mess",e.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("Views/Home.jsp");
        rd.forward(request,response);
    }
    public static void InsertData(HttpServletRequest request,Danhsach danhsach){
        Connection conn = DBconnection.CreateConnection();
        String sql = "INSERT INTO dbo.Danhsach( monanid ,danhmuctu ,gioithieu ,nguyenlieu ,cachlam ,chuy)VALUES  ( ? , ? , ? ,?, ? , ? )";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1,danhsach.getMonanid());
            ptmt.setString(2,danhsach.getDanhmuctu());
            ptmt.setString(3,danhsach.getGioithieu());
            ptmt.setString(4,danhsach.getNguyenlieu());
            ptmt.setString(5,danhsach.getCachlam());
            ptmt.setString(6,danhsach.getChuy());
            int kt = ptmt.executeUpdate();
            if(kt!=0){
                request.setAttribute("mess","them thanh cong");
            }
            else{
                request.setAttribute("mess","them that bai");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
