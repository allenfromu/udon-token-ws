/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.dao;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author zepengzhao
 */
public class DAOUtil {
    
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }catch(Exception e){
                
            }
        }
    }
    public static void closeStatement(Statement stat){
        if(stat != null){
            try{
                stat.close();
            
            }catch(Exception e){               
            }
        }
    }
    public static void close(Connection conn, Statement stat){
        closeStatement(stat);
        closeConnection(conn);
    }
}
