package com.besafe.besafebackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int createOtpTable(){
        try {
            String query = "CREATE TABLE IF NOT EXISTS OTP (" +
                    "  OTPID INT PRIMARY KEY AUTO_INCREMENT," +
                    "  OTPHASH VARCHAR(255) NOT NULL," +
                    "  CREATEDAT TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                    "  USERID VARCHAR(255)"+
                    ");";
            int result =  jdbcTemplate.update(query);

            return result;

        }
        catch(Exception e){
            return -1;
        }
    }

    public boolean storeOtpHash(String userId, String otpHash){
        try{
            this.createOtpTable();
            String query = "INSERT INTO OTP(OTPHASH, USERID) VALUES(?,?);";
            int dbResult = jdbcTemplate.update(query, otpHash, userId);

            if(dbResult==0){
                return false;
            }
            else {
                return true;
            }
        }
        catch(Exception e){
            return false;
        }
    }
}
