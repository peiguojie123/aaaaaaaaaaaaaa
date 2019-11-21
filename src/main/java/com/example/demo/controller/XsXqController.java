package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.example.demo.entity.XsXq;
import com.example.demo.service.XsXqService;

@RestController  //Controller 和 ResponseBody的组合  返回的不是页面 而是实际的body的值
@RequestMapping("/xsxq")  //指定根路由
public class XsXqController {
    @Autowired  //调service
    private XsXqService xsXqService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/listXsXq", method = RequestMethod.GET)
    private Map<String, Object> listXsXq() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<XsXq> list = new ArrayList<XsXq>();
        // 获取区域列表
        list = xsXqService.getXsXqList();
        modelMap.put("XsXqList", list);
        return modelMap;
    }

    /**
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getXsXqbyid", method = RequestMethod.GET)
    private Map<String, Object> getXsXqById(Integer XsXqId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        XsXq XsXq = xsXqService.getXsXqById(XsXqId);
        modelMap.put("XsXq", XsXq);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addXsXq", method = RequestMethod.POST)
    private Map<String, Object> addXsXq(@RequestBody XsXq XsXq)  //前端传入json对象
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", xsXqService.addXsXq(XsXq));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     *
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyXsXq", method = RequestMethod.POST)
    private Map<String, Object> modifyXsXq(@RequestBody XsXq XsXq)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", xsXqService.modifyXsXq(XsXq));
        return modelMap;
    }

    @RequestMapping(value = "/removeXsXq", method = RequestMethod.GET)
    private Map<String, Object> removeXsXq(Integer XsXqId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", xsXqService.deleteXsXq(XsXqId));
        return modelMap;
    }
}
