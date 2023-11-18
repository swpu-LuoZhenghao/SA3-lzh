package cesi.servlet;

import cesi.util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private DB db = new DB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取要删除的用户名称
        String userName = request.getParameter("userName");

        if (db.delete(userName)) {
            // 设置删除成功的消息，并转发到显示所有用户的页面
            //request.setAttribute("message", "删除成功");
            //request.getRequestDispatcher("/SearchServlet").forward(request, response);
            request.setAttribute("username", "删除"+userName);
            request.getRequestDispatcher("/SearchServlet.jsp").forward(request, response);
        } else {
            // 删除失败，重定向到首页
            response.sendRedirect("index.jsp");
        }
    }
}
