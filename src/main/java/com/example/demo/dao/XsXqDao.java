package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.XsXq;

public interface XsXqDao {
    /**
     * 列出区域列表
     */
    List<XsXq> queryXsXq();

    /**
     * 根据Id列出具体区域
     */
    XsXq queryXsXqById(int xsxqId);

    /**
     * 插入区域信息
     */
    int insertXsXq(XsXq xsXq);

    /**
     * 更新区域信息
     */
    int updateXsXq(XsXq xsXq);

    /**
     * 删除区域信息
     */
    int deleteXsXq(int xsxqId);
}