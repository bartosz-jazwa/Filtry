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
import java.time.LocalDateTime;

@WebServlet("/addpost")
public class AddPostServlet extends HttpServlet {
    private final PostDao postDao = new PostDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Post post = new Post();
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));
        post.setCreatedAt(LocalDateTime.now());
        postDao.create(post);

        resp.sendRedirect("/dashboard");
    }
}
