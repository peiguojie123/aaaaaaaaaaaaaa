package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.XsXq;

public interface XsXqService {

    /**
     * 获取小说详情列表
     *
     * @return
     */
    List<XsXq> getXsXqList();

    /**
     * 通过小说详情Id获取小说详情信息
     *
     * @param xsXqId
     * @return
     */
    XsXq getXsXqById(int xsXqId);

    /**
     * 增加小说详情信息
     *
     * @param xsXq
     * @return
     */
    boolean addXsXq(XsXq xsXq);

    /**
     * 修改小说详情信息
     *
     * @param xsXq
     * @return
     */
    boolean modifyXsXq(XsXq xsXq);

    /**
     * 删除小说详情信息
     *
     * @param xsXqId
     * @return
     */
    boolean deleteXsXq(int xsXqId);

}
