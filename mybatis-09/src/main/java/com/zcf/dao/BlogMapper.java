package com.zcf.dao;

import com.zcf.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int insertBlog(Blog blog);

    List<Blog> getBlogByCondition(Map map);

    List<Blog> getBlogChoose(Map map);

    int updateBlog(Blog blog);

    List<Blog> getBlogForeach(Map map);

    Blog getBlogById(int id);


}
