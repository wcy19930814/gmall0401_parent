package com.atguigu.gmall0401.service;

import com.atguigu.gmall0401.entity.*;

import java.util.List;

public interface ManageService{

    //查询一级分类信息
    public List<BaseCatalog1> getCatalog1();

    //查询二级分类, 根据一级分类id
    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    //查询三级分类, 根据二级分类id
    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    //根据三级分类id查询平台属性
    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    //保存平台属性
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    //根据平台属性id查询到平台属性信息,并查询到对应的平台属性值
    BaseAttrInfo getBaseAttrInfo(String attrId);

    //获取基本销售属性
    List<BaseSaleAttr> getBaseSaleAttrList();

    //保存spu信息
    void saveSpuInfo(SpuInfo spuInfo);

    //查询所有spuInfo信息
    List<SpuInfo> getSpuList(String catalog3Id);

    //在sku上获取所有spu图片
    List<SpuImage> getSpuImageList(String spuId);

    //根据spuId查询销售属性
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    //保存skuInfo
    public void saveSkuInfo(SkuInfo skuInfo);
}
