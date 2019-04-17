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
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private final PostDao postDao = new PostDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> posts = postDao.findAll();
        /*if (posts.isEmpty()){
            Post post = new Post();
            post.setTitle("nic ciekawego");
            post.setContent(";klasdjf;lkjasdf;lkj;askldfj;laksjdf;lkajsd;lfkja;lsdjkf");
            post.setCreatedAt(LocalDateTime.now());
            postDao.create(post);
        }
        posts = postDao.findAll();*/
        req.setAttribute("posts",posts);
        req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);

    }
}
