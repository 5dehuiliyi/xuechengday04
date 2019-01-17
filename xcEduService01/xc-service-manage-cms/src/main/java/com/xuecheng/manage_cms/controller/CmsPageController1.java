package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import com.xuecheng.manage_cms.service.PageService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 17:24
 **/
@RestController
@RequestMapping("/cms/page")
public class CmsPageController1 implements CmsPageControllerApi {

    @Autowired
    PageService1 pageService1;

    @Override
    @GetMapping("/list1/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, QueryPageRequest queryPageRequest) {

   /*     //暂时采用测试数据，测试接口是否可以正常运行
        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(2);
        //静态数据列表
        List list = new ArrayList();
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试页面");
        list.add(cmsPage);
        queryResult.setList(list);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);*/
        return pageService1.findList(page,size,queryPageRequest);
    }

    @Override
    public CmsPageResult add(CmsPage cmsPage) {
        return null;
    }

    @Override
    public CmsPage findById(String id) {
        return null;
    }

    @Override
    public CmsPageResult edit(String id, CmsPage cmsPage) {
        return null;
    }

    @Override
    public ResponseResult delete(String id) {
        return null;
    }
}
