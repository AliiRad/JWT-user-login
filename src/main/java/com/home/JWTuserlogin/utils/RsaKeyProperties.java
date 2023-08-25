package com.home.JWTuserlogin.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Data

@Component
public class RsaKeyProperties {

    private RSAPublicKey rsaPublicKey; // Validate Digital Signature
    private RSAPrivateKey rsaPrivateKey; // generate Digital Signature

    public RsaKeyProperties(){
        KeyPair keyPair = KeyGeneratorUtility.generateRsaKey();
        this.rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        this.rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
    }
}
