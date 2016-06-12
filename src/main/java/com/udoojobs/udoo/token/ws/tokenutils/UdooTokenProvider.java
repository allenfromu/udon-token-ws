/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.tokenutils;

import com.udoojobs.udoo.token.ws.tokenutils.UdooTokenConfig;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTSigner.Options;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author zepengzhao
 */
public class UdooTokenProvider {
    private final UdooTokenConfig config;
    private final JWTSigner signer;
    
    public UdooTokenProvider(){
        this.config = new UdooTokenConfig();
        this.signer = new JWTSigner(this.config.getSecrect());
    }
    
    public String getTokenForUser(BigInteger userId){
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("userId", userId);       
        return this.signer.sign(payload, this.getOptions());
    }
    
    public Options getOptions(){
        Options opts = new JWTSigner.Options();
        opts.setAlgorithm(config.getAlgorithm());
        opts.setExpirySeconds(config.getSecondsToExpired());
        opts.setIssuedAt(true);
        return opts;
    }
    
    
}
