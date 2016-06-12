package com.udoojobs.udoo.token.ws;

import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.ResourceConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zepengzhao
 */
@Path("/")
public class ResfulApplication extends ResourceConfig{
    
    public ResfulApplication(){
        packages("com.udoojobs.udoo.token.ws.resources");
        register(JacksonJaxbJsonProvider .class);
        register(JacksonFeatures.class);
    }
    
}
