/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.ds;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zepengzhao
 */
public class DataSources {
    public final static HashMap<String, DataSource> CACHE=new HashMap<String,DataSource>();
    
    private static final Logger LOGGER = Logger.getLogger(DataSources.class.getName());

    
    public static DataSource fetch(String dataSourceID){
        if(CACHE.containsKey(dataSourceID)){
            return CACHE.get(dataSourceID);
        }
        DataSource temp = createBasicDataSource(dataSourceID);
        if(temp != null)
            CACHE.put(dataSourceID, temp);
        return temp;
    }
    
    public static DataSource createBasicDataSource(String dataSourceID){
        try{
            ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext("/dataSourceConfig.xml");
            BasicDataSource bds = (BasicDataSource)cc.getBean(dataSourceID);      
           
            return bds;
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }
    
}

