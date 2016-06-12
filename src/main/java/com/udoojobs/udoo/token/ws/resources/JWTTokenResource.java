/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.resources;

import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.udoojobs.udoo.token.ws.services.UserTokenService;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author zepengzhao
 */
@Path("auth/jwttoken")
public class JWTTokenResource {
    private final UserTokenService userTokenService;
    public JWTTokenResource(){
        this.userTokenService = new UserTokenService();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTokenForUserByEmail(String jsonString){
        ObjectMapper mapper = new ObjectMapper();
        try{
            Map<String,Object> map = mapper.readValue(jsonString, HashMap.class);
            //String email = (String)map.get("email");
            //String password = (String)map.get("password");
            if(!map.containsKey("email") || !map.containsKey("password"))
                return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity("{\"message\":\"Wrong data format\"}").build();           
            return this.userTokenService.getTokenForUserByEmail((String)map.get("email"), (String)map.get("password"));
        }catch(Exception e){
            System.out.println(e);
            return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity("{\"message\":\"Wrong data format\"}").build();
        }        
    }
}
