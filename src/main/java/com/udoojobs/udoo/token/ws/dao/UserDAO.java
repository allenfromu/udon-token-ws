/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.dao;

import com.udoojobs.udoo.token.ws.ds.DataSources;
import com.udoojobs.udoo.token.ws.models.User;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author zepengzhao
 */
public class UserDAO {
    private final DataSource dbs;
    private JdbcTemplate db;
    
    public UserDAO(){
        this.dbs = DataSources.fetch("db1");
        this.db = new JdbcTemplate(this.dbs);
    }
    
    public User getUserInfoByEmail(final String email){

        String sql = "select * from user where user.email_addr = ?";
        User user = new User();
        Connection conn =null;
        PreparedStatement prepStmt=null;
        try{
            conn = dbs.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1,email);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                  user.setID((BigInteger)rs.getObject("id"));
                  user.setFirstName(rs.getString("first_name"));
                  user.setLastName(rs.getString("last_name"));
                  System.out.println(user.getID());
            }
//        use =  this.db.queryForObject(sql, new Object[]{email},
//             new RowMapper<User>(){
//                @Override
//                public User mapRow(ResultSet rs, int i) throws SQLException {
//                    User user = new User();
//                    System.out.println(email);
//                    if(rs.next()){
//                        user.setID((BigInteger)rs.getObject("id"));
//                        user.setFirstName(rs.getString("first_name"));
//                        user.setLastName(rs.getString("last_name"));
//                    }
//                    return user;
//                }                 
//            }   
//        );
        }catch(Exception e){
            System.out.println(e);
        }finally{
            DAOUtil.close(conn, prepStmt);
        }
        
        return user;
    }
    
    public boolean verifyUserPassword(BigInteger id, String password){
        String sql = "select * from user where id=? and password=?";
        
        Connection conn =null;
        PreparedStatement prepStmt=null;
        try{
            conn = dbs.getConnection();
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setLong(1, id.longValue());
            prepStmt.setString(2, password);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                return true;
            }

        }catch(Exception e){
            System.out.println(e);
        }finally{
            DAOUtil.close(conn, prepStmt);
        }
        return false;
//        return this.db.queryForObject(sql, 
//        new Object[]{id, password},
//
//        new RowMapper<Boolean>(){
//            @Override
//            public Boolean mapRow(ResultSet rs, int i) throws SQLException {
//                if(rs.next()){
//                    return true;
//                }
//                return false;
//            }       
//        }
//        );
    }
    
}
