package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

/**
 * Created by xuw-e on 2018/5/22.
 */
public class JwtDemo {

    public static void main(String[] args) {

        Key key = MacProvider.generateKey();

        String compactJws = Jwts.builder()
                .setSubject("xuwei")
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        System.out.println(compactJws);

        String jws = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJ3ZWIiLCJzdWIiOiI2Mzg5MDExMjQ5ODgwNTY4MzQ0IiwiaXNzIjoiZ3NzLmdsb2Rvbi5jb20iLCJleHAiOjE1Mjg3ODY0Nzl9.uyVTllvrwD7_QaKDI6z4lg6nyDipxBlFgG93v6anax4";


        Jws<Claims> claims = Jwts
                .parser()
                .setSigningKey("werxfsfssecfer234234")
                .parseClaimsJws(jws);

        System.out.println(claims);

    }
}
