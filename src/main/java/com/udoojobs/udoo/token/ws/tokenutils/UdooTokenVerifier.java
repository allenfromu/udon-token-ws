/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.tokenutils;

import com.udoojobs.udoo.token.ws.tokenutils.UdooTokenConfig;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import java.util.Map;


/**
 *
 * @author zepengzhao
 */
public class UdooTokenVerifier {
    //private final Base64 decoder;
    private final UdooTokenConfig config;
    //private final byte[] secrect;
    private final JWTVerifier verifier;
    
    public UdooTokenVerifier(){
        //this.decoder = new Base64(true);
        this.config = new UdooTokenConfig();
        //this.secrect = decoder.decodeBase64(config.getSecrect());
        this.verifier = new JWTVerifier(config.getSecrect(), null, config.getIssuer());
    }
    
    public int verifyToken(String token){
        try{
            Map<String, Object> payload = this.verifier.verify(token);
            return (Integer)payload.get("userId");
        }catch(Exception e){
            System.out.println(e);
            return -1;
        }       
    }
    
    
    
}
