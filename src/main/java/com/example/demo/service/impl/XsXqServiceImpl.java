package com.example.demo.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.XsXqDao;
import com.example.demo.entity.XsXq;
import com.example.demo.service.XsXqService;
import org.springframework.util.StringUtils;

@Service
public class XsXqServiceImpl implements XsXqService {
    @Autowired
    private XsXqDao xsXqDao;

    @Override
    public List<XsXq> getXsXqList() {
        // 返回所有的小说详情信息
        return xsXqDao.queryXsXq();
    }

    @Override
    public XsXq getXsXqById(int xsXqId) {

        return xsXqDao.queryXsXqById(xsXqId);
    }

    @Transactional  //加上事务控制  当抛出RuntimeException异常  事务就会回滚
    @Override
    public boolean addXsXq(XsXq xsXq) {
        // 空值判断，主要是判断XsXqName不为空
        if (xsXq != null && !StringUtils.isEmpty(xsXq.getXsmc())) {
//            // 设置默认值
//            xsXq.setCreateTime(new Date());  //设置当前时间
//            xsXq.setLastEditTime(new Date());
            try {
                int effectedNum = xsXqDao.insertXsXq(xsXq);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加小说详情信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加小说详情信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("小说详情信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyXsXq(XsXq xsXq) {
        // 空值判断，主要是XsXqId不为空
        if (xsXq != null && xsXq.getId() != null && xsXq.getId() > 0) {
//            // 设置默认值
//            xsXq.set(new Date());
            try {
                // 更新小说详情信息
                int effectedNum = xsXqDao.updateXsXq(xsXq);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新小说详情信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新小说详情信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("小说详情信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteXsXq(int xsXqId) {
        if (xsXqId > 0) {
            try {
                // 删除小说详情信息
                int effectedNum = xsXqDao.deleteXsXq(xsXqId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除小说详情信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除小说详情信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("小说详情Id不能为空！");
        }
    }
}
