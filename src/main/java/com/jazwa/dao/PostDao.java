package com.jazwa.dao;

import com.jazwa.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    List<Post> findAll();

    boolean create(Post post);

    boolean delete(long id);

    boolean update(Post post);

    Optional<Post> get(long id);
}
