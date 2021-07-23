package Dao;

import Bean.Danhsach;
import DB.DBconnection;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class nienluanDao {

    //hàm lấy danh sách sản phẩm
//    public static List<Danhsach> Selectlistmenu() {
//        Connection conn = DBconnection.CreateConnection();
//        List<Danhsach> list = new ArrayList<Danhsach>();
//        String sql = "SELECT * FROM dbo.Danhsach";
//        try {
//            PreparedStatement ptmt = conn.prepareStatement(sql);
//            ResultSet rs = ptmt.executeQuery();
//            while (rs.next()) {
//                Danhsach danhsach = new Danhsach();
//                danhsach.setMonanid(rs.getInt("monanid"));
//                danhsach.setDanhmuctu(rs.getString("danhmuctu"));
//                danhsach.setGioithieu(rs.getString("gioithieu"));
//                danhsach.setNguyenlieu(rs.getString("nguyenlieu"));
//                danhsach.setCachlam(rs.getString("cachlam"));
//                danhsach.setChuy(rs.getString("chuy"));
//                list.add(danhsach);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return list;
//    }

    // hàm lấy món ăn theo id
    public static Danhsach displaymenu(int monanid) {
        Connection conn = DBconnection.CreateConnection();
        String sql = "SELECT * FROM dbo.Danhsach WHERE monanid=?";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, monanid);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Danhsach danhsach = new Danhsach();
                danhsach.setMonanid(rs.getInt("monanid"));
                danhsach.setDanhmuctu(rs.getString("danhmuctu"));
                danhsach.setGioithieu(rs.getString("gioithieu"));
                danhsach.setNguyenlieu(rs.getString("nguyenlieu"));
                danhsach.setCachlam(rs.getString("cachlam"));
                danhsach.setChuy(rs.getString("chuy"));
                return danhsach;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    // hàm lấy danh sách món ăn và phân trang
    public static List<Danhsach> Paginaton(int page, int pagesize) {
        Connection conn = DBconnection.CreateConnection();
        List<Danhsach> list = new ArrayList<Danhsach>();
        String sql = " SELECT * FROM dbo.Danhsach\n" +
                "    ORDER BY monanid\n" +
                "    OFFSET ? ROWS \n" +
                "    FETCH NEXT ?  ROWS ONLY;";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, ((page - 1) * pagesize));
            ptmt.setInt(2, pagesize);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Danhsach danhsach = new Danhsach();
                danhsach.setMonanid(rs.getInt("monanid"));
                danhsach.setDanhmuctu(rs.getString("danhmuctu"));
                danhsach.setGioithieu(rs.getString("gioithieu"));
                danhsach.setNguyenlieu(rs.getString("nguyenlieu"));
                danhsach.setCachlam(rs.getString("cachlam"));
                danhsach.setChuy(rs.getString("chuy"));
                list.add(danhsach);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    // hàm lấy số lượng hàng trong database
    public static int GetCount() {
        int count = 0;
        Connection conn = DBconnection.CreateConnection();
        String sql = "SELECT COUNT(*) FROM DanhSach";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            rs.next();
            count = rs.getInt(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    // hàm tìm kiếm theo tên
    public static List<Danhsach> SelectlistmenuSearch(String name, HttpServletRequest request) {
        Connection conn = DBconnection.CreateConnection();
        List<Danhsach> list = new ArrayList<Danhsach>();
        String sql = "SELECT * FROM dbo.Danhsach WHERE danhmuctu LIKE N'%"+name+"%'";

        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            if(!rs.isBeforeFirst()){
                request.setAttribute("messfind","Không tìm thấy kết quả");
            }
            else {
                while (rs.next()) {
                    Danhsach danhsach = new Danhsach();
                    danhsach.setMonanid(rs.getInt("monanid"));
                    danhsach.setDanhmuctu(rs.getString("danhmuctu"));
                    danhsach.setGioithieu(rs.getString("gioithieu"));
                    danhsach.setNguyenlieu(rs.getString("nguyenlieu"));
                    danhsach.setCachlam(rs.getString("cachlam"));
                    danhsach.setChuy(rs.getString("chuy"));
                    list.add(danhsach);
                }
            }
        } catch (SQLException throwables) {
            request.setAttribute("messfind",throwables.getMessage());
        }
        return list;
    }


//    public static int GetCountSearch(String name) {
//        int count = 0;
//        Connection conn = DBconnection.CreateConnection();
//        String sql = "SELECT COUNT(*) FROM dbo.Danhsach WHERE danhmuctu LIKE '%"+name+"%'";
//        try {
//            PreparedStatement ptmt = conn.prepareStatement(sql);
//            ResultSet rs = ptmt.executeQuery();
//            rs.next();
//            count = rs.getInt(1);
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        return count;
//    }
}
