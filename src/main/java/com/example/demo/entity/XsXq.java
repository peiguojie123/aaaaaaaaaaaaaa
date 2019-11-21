package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 小说详情实体类
 */
@Getter
@Setter
public class XsXq {
    private Integer id;//主键
    private String xslx;//小说类型
    private String xsdz;//小说地址
    private String author;//作者
    private String xsmc;//小说名称
    private String zhgx;//最后更新
    private String xsjj;//小说简介
    private String wjfm;//文件封面
    private String path;//路径
    private String size;//大小

}
