/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo;

import com.udoojobs.udoo.token.ws.dao.UserDAO;
import com.udoojobs.udoo.token.ws.models.User;
import org.junit.Test;

/**
 *
 * @author zepengzhao
 */
public class dattest {
    
    @Test
    public void test1(){
        UserDAO u = new UserDAO();
        User user = u.getUserInfoByEmail("allenzhaoatu@gmail.com");
        System.out.println(user.getID());
    }
    
}
