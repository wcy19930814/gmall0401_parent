package com.atguigu.gmall0401.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall0401.entity.*;
import com.atguigu.gmall0401.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManageController {

    @Reference
    private ManageService manageService;

    /**
     * 获取一级分类
     * @return
     */
    @PostMapping("getCatalog1")
    public List<BaseCatalog1> getBaseCatalog1List(){
        List<BaseCatalog1> catalog1 = manageService.getCatalog1();
        System.out.println("一级分类: " + catalog1);
        return catalog1;
    }

    /**
     * 根据一级分类catalog1Id获取二级分类
     * @param catalog1Id
     * @return
     */
    @PostMapping("getCatalog2")
    public List<BaseCatalog2> getBaseCatalog2List(String catalog1Id){
        List<BaseCatalog2> catalog2 = manageService.getCatalog2(catalog1Id);
        return catalog2;
    }

    /**
     * 根据二级分类catalog2Id获取三级分类
     * @param catalog2Id
     * @return
     */
    @PostMapping("getCatalog3")
    public List<BaseCatalog3> getBaseCatalog3List(String catalog2Id){
        List<BaseCatalog3> catalog3 = manageService.getCatalog3(catalog2Id);
        return catalog3;
    }

    /**
     * 根据三级分类catalog3Id获取平台属性信息
     * @param catalog3Id
     * @return
     */
    @GetMapping("attrInfoList")
    public List<BaseAttrInfo> getBaseAttrInfoList(String catalog3Id){
        List<BaseAttrInfo> baseAttrInfos = manageService.getAttrList(catalog3Id);
        return baseAttrInfos;
    }

    @PostMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveAttrInfo(baseAttrInfo);
        return "success";
    }

    @PostMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
        BaseAttrInfo baseAttrInfo = manageService.getBaseAttrInfo(attrId);
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        return attrValueList;
    }
}
