package com.demo.controller;

import com.demo.pojo.ImagesPath;
import com.demo.pojo.Product;
import com.demo.pojo.ProductInfo;
import com.demo.service.ImagesPathService;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ImagesPathService imagesPathService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(){
        Map<String,Object> productInfo=new HashMap<>();
        List<ProductInfo> productInfoList=new ArrayList<>();
        List<Product> products=productService.selectAll();
        for (int i=0;i<products.size();i++){
            ProductInfo productInfo1=new ProductInfo();
            productInfo1.setProduct(products.get(i));
            List<ImagesPath> imagesPaths=imagesPathService.selectByPid(productInfo1.getProduct().getPid());
            productInfo1.setImagesPath(imagesPaths);
            productInfoList.add(productInfo1);
        }
        productInfo.put("code",200);
        productInfo.put("productInfoList",productInfoList);
        productInfo.put("msg","查询成功");

        return productInfo;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Map<String,Object> findByPid(int pid){
        Map<String,Object> productMap=new HashMap<>();
        Product product = productService.selectById(pid);
        List<ImagesPath> imagesPaths = imagesPathService.selectByPid(pid);
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProduct(product);
        productInfo.setImagesPath(imagesPaths);
        productMap.put("code",200);
        productMap.put("msg","查询成功");
        productMap.put("productInfo",productInfo);
        return productMap;
    }


    @RequestMapping("/findByDescription")
    @ResponseBody
    public Map<String,Object> findByDescription(String description){
        Map<String,Object> productsMap=new HashMap<>();
        List<ProductInfo> productInfoList=new ArrayList<>();
        List<Product> products = productService.selectByDescription(description);
        for (int i=0;i<products.size();i++){
            ProductInfo productInfo=new ProductInfo();
            productInfo.setProduct(products.get(i));
            List<ImagesPath> imagesPaths = imagesPathService.selectByPid(productInfo.getProduct().getPid());
            productInfo.setImagesPath(imagesPaths);
            productInfoList.add(productInfo);
        }
        productsMap.put("code",200);
        productsMap.put("msg","查询成功");
        productsMap.put("productInfoList",productInfoList);
        return productsMap;
    }

    @RequestMapping("/findOrderBySold")
    @ResponseBody
    public Map<String,Object> findOrderBySold(){
        Map<String,Object> productInfo=new HashMap<>();
        List<ProductInfo> list=new ArrayList<>();
        List<Product> products = productService.selectOrderBySold();
        for (int i=0;i<products.size();i++){
            ProductInfo productInfo1=new ProductInfo();
            productInfo1.setProduct(products.get(i));
            List<ImagesPath> imagesPaths = imagesPathService.selectByPid(productInfo1.getProduct().getPid());
            productInfo1.setImagesPath(imagesPaths);
            list.add(productInfo1);
        }
        productInfo.put("code",200);
        productInfo.put("productInfoList",list);
        productInfo.put("msg","查询成功");
        return productInfo;
    }
}
