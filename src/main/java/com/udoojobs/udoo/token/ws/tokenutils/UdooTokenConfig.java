/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udoojobs.udoo.token.ws.tokenutils;

import com.auth0.jwt.Algorithm;

/**
 *
 * @author zepengzhao
 */
public class UdooTokenConfig {
    private final String secrect = "udoojobs.com-secrect";
    private final Algorithm alg = Algorithm.HS256;
    private final String issuer = "udoo-geeks";
    private final int secondsToExpired = 24*60*60;
    
    public String getSecrect(){
        return secrect;
    }
    
    public Algorithm getAlgorithm(){
        return this.alg;
    }
    
    public String getIssuer(){
        return this.issuer;
    }
    
    public int getSecondsToExpired(){
        return this.secondsToExpired;
    }
    
    
}
