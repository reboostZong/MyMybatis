package com.zcf.dao;

import com.zcf.pojo.Blog;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class BlogTest {

    @Test
    public void testGetBlogById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blogById = mapper.getBlogById(3);
        System.out.println(blogById);

        Blog blog = new Blog();
        blog.setId("3");
        blog.setViews(666);
        mapper.updateBlog(blog);


        Blog blogById2 = mapper.getBlogById(3);
        System.out.println(blogById2);


        sqlSession.close();

    }

    @Test
    public void testCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blogById = mapper.getBlogById(3);
        System.out.println(blogById);

        sqlSession.close();

        System.out.println("==============================");
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        BlogMapper mapper1 = sqlSession1.getMapper(BlogMapper.class);
        Blog blogById1 = mapper1.getBlogById(3);
        System.out.println(blogById1);

        System.out.println(blogById == blogById1);

        sqlSession1.close();
    }
}
