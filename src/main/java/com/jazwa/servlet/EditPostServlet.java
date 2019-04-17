package com.jazwa.servlet;

import com.jazwa.dao.PostDao;
import com.jazwa.dao.PostDaoImpl;
import com.jazwa.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditPostServlet extends HttpServlet {
    private final PostDao postDao = new PostDaoImpl();
    private Post post;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        long id = Integer.parseInt(idString);

        post = postDao.get(id).orElse(new Post());

        req.setAttribute("post",post);
        req.getRequestDispatcher("/editPost.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        post.setContent(req.getParameter("content"));
        postDao.update(post);
        resp.sendRedirect("/dashboard");
    }
}
