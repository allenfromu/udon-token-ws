/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.services;

import com.udoojobs.udoo.token.ws.dao.UserDAO;
import com.udoojobs.udoo.token.ws.models.User;
import com.udoojobs.udoo.token.ws.tokenutils.UdooTokenProvider;
import java.util.Map;
import java.util.TreeMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author zepengzhao
 */
public class UserTokenService {
    private final UserDAO userDao;
    private final UdooTokenProvider tokenProvider;
    
    public UserTokenService(){
        this.userDao = new UserDAO();
        tokenProvider = new UdooTokenProvider();
    }
    
    public Response getTokenForUserByEmail(String email, String password){
        Map<String, Object> response = new TreeMap<String, Object>();
        User user = this.userDao.getUserInfoByEmail(email);
        if(user.getID() == null){
            response.put("message", "Email doesn't exist");
            return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
        }
        
        if(!userDao.verifyUserPassword(user.getID(), password)){
            response.put("message", "Wrong password!");
            return Response.status(Response.Status.UNAUTHORIZED).entity(response).build();
        }
        
        String token = tokenProvider.getTokenForUser(user.getID());
        response.put("token", token);
        response.put("userId",user.getID());
        response.put("email", email);        
        return Response.ok(response).build();
        
    }
    
}
