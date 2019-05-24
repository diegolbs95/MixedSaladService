package com.nosbielc.mixed.salad.bancocentral.utils.auteticator;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testes {

    private static final Logger log = LoggerFactory.getLogger(testes.class);
    private static Boolean isHabilitarLoop = Boolean.TRUE;

    public static void main(String[] args) throws InterruptedException {
        //Gerando autenticação
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        final GoogleAuthenticatorKey key = gAuth.createCredentials();
        log.info("KeyVerification: " + key.getVerificationCode());
        log.info("Key: " + key.getKey());

        //Checando token
//        boolean isCodeValid = gAuth.authorize("NUWSNYXVSG67KUDI", 190631);
//        log.info("Valido ? " + isCodeValid);

        while (isHabilitarLoop) {
            int code = gAuth.getTotpPassword(key.getKey());
            boolean isCodeValidTest = gAuth.authorize(key.getKey(), code);
            log.info("Codigo Gerado pelo app ? " + code);
            log.info("Valido ? " + isCodeValidTest);
            Thread.sleep(90000);
        }

    }


}
