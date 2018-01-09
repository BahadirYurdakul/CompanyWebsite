package models;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;

public class Token {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Token(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String createToken() {
        Algorithm algorithm = null;
        try {
            algorithm = Algorithm.HMAC256("kurumsal");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String token = JWT.create()
                .withIssuer("SadikBahadir")
                .withClaim("username", username)
                .sign(algorithm);
        return token;
    }

    public static String getUsernameFromToken(String token) {
        String username = null;
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            username = decodedJWT.getClaim("username").asString();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

}
