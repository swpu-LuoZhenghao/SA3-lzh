package cesi.servlet;


import cesi.util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private DB db = new DB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户输入的更新信息
        String userName = request.getParameter("userName");
        String userAddress = request.getParameter("userAddress");
        String userPhone = request.getParameter("userPhone");

        if (db.update(userName, userAddress, userPhone)) {
            // 更新成功，设置成功消息，并转发到显示所有用户的页面
            request.setAttribute("username", "更新"+userName);
            request.getRequestDispatcher("/SearchServlet.jsp").forward(request, response);
        } else {
            // 更新失败，重定向到首页
            response.sendRedirect("index.jsp");
        }
    }
}
