package com.zcf.dao;

import com.zcf.pojo.Blog;
import com.zcf.util.IdUtils;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class BlogTest {
    @Test
    public void testInsertBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        for (int i = 0; i < 10; i++) {
            Blog blog = new Blog();
            blog.setId(IdUtils.getId());
            blog.setTitle("harry porter"+(i+1));
            blog.setAuthor("merry king" + (i+1));
            blog.setCreateTime(new Date());
            blog.setViews(new Random().nextInt()*5678);
            mapper.insertBlog(blog);
        }


        sqlSession.close();

    }


    @Test
    public void testGetBlogByCondition() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "harry porter3");
        map.put("author", "merry king3");
        List<Blog> blogByCondition = mapper.getBlogByCondition(map);
        System.out.println(blogByCondition);


        sqlSession.close();
    }
}
