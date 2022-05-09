package com.example.demo.registration.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public void saveConfirmationToken(ConfirmationToken token){
        tokenRepository.save(token);
    }

    public String confirmed(String token) {
        return tokenRepository.findByToken(token).isPresent() ? "confirmed" : "invalid token";
    }
}
