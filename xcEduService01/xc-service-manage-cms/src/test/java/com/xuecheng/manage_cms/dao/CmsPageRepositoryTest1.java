package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:11
 **/
 @SpringBootTest
 @RunWith(SpringRunner.class)
public class CmsPageRepositoryTest1 {
     @Autowired
    CmsPageRepository cmsPageRepository;

     @Test
     public void testFindAll(){
         List<CmsPage> all = cmsPageRepository.findAll();
         System.out.println(all);
     }
     //分页查询
    @Test
    public void testFindPage(){
         int page = 0;//从0开始
        int size = 10;//每页及记录数
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }
    //添加
    @Test
    public void testInsert(){
//定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    //修改
    @Test
    public void testUpdate() {
         //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5c3729d8b81ff00468995270");

        if (optional.isPresent()){
            CmsPage cmsPage = optional.get();
            //设置要修改的值
            cmsPage.setPageName("还是测试页面");
            //修改
            cmsPageRepository.save(cmsPage);
        }

    }

    //根据页面名称查询
    @Test
    public void testfindByPageName(){

        CmsPage byPageName = cmsPageRepository.findByPageName("还是测试页面");
        System.out.println(byPageName);

    }

}
