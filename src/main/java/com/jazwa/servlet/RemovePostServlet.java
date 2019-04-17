package com.jazwa.servlet;

import com.jazwa.dao.PostDao;
import com.jazwa.dao.PostDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class RemovePostServlet extends HttpServlet {
    private final PostDao postDao = new PostDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        long id = Integer.parseInt(idString);
        postDao.delete(id);

        resp.sendRedirect("/dashboard");
    }
}
