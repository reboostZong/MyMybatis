package com.zcf.dao;

import com.zcf.pojo.Blog;
import com.zcf.util.IdUtils;
import com.zcf.util.MybatisUtils;
import org.apache.ibatis.cache.Cache;
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


    @Test
    public void testGetBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "harry porter7");
//        map.put("author", "merry king3");
        map.put("views", 0);


        List<Blog> blogChoose = mapper.getBlogChoose(map);
        System.out.println(blogChoose);

        sqlSession.close();
    }

    @Test
    public void testUpdateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId("2c81ed89314d4655a336717b64269c4c");
        blog.setViews(50);

        mapper.updateBlog(blog);

        sqlSession.close();
    }

    @Test
    public void testGetBlogForeach() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(5);
        ids.add(6);
        map.put("ids", ids);

        List<Blog> blogForeach = mapper.getBlogForeach(map);
        System.out.println(blogForeach);

        sqlSession.close();

    }
}
