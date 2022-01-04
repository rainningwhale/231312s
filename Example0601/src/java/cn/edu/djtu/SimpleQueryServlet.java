/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.djtu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "SimpleQueryServlet", urlPatterns = {"/SimpleQueryServlet"})
public class SimpleQueryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "daaiALICE123";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            request.setCharacterEncoding("UTF-8");
            String scity=request.getParameter("city").toString().trim();
            String sql = "select * from news";
            //String sql = "select count(*) as num from customer";
            //if(scity!="")
            scity=scity.replace("'", "''");
                sql +=" where title like '%"+scity+"%'";
                   
            rs = st.executeQuery(sql);
            //rs.next();
            //out.print(rs.getString("num"));
            ///*
            out.print("<table border=1>");
            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>" + rs.getInt("ID") + "</td>");
                out.print("<td>" + rs.getString("title") + "</td>");
                out.print("<td>" + rs.getString("user") + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");
            //*/
            
        } catch (SQLException ex) {
            Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SimpleQueryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            out.close();
        } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
