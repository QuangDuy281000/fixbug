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

public class searchAjaxDao {
    public static List<Danhsach> SearchAjax(String name, HttpServletRequest request) {
        Connection conn = DBconnection.CreateConnection();
        List<Danhsach> list = new ArrayList<Danhsach>();
        String sql = "SELECT * FROM dbo.Danhsach WHERE danhmuctu LIKE '%"+name+"%'";

        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            if(!rs.isBeforeFirst()){
                request.setAttribute("messfind","khong co ket qua");
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
            throwables.getMessage();
        }
        return list;
    }
}
