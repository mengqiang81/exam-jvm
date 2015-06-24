package com.mainsoft.util;

import java.util.List;
/**
 *xml生成接口
 * @author wgs
 *
 */
public interface XmlInterface {
    /** 
     * 创建xml文件
     * @param fileName 
     */
   public void createXml(String fileName,List<String[]> L); 
     /** 
     * 解析xml
     * @param fileName 当前路径下文件名字
     * @param  State 状态值
     */
     public List<String[]>  parserXml(String fileName,String State); 
}
