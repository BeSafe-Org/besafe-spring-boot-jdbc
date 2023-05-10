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
        try {
            this.createOtpTable();
            String query = "SELECT COUNT(*) FROM OTP WHERE USERID = ?";
            int existingUserId = jdbcTemplate.queryForObject(query, Integer.class, userId);
            if (existingUserId != 0) {
                // Update OTP hash for the existing user
                query = "UPDATE OTP SET OTPHASH = ? WHERE USERID = ?";
                int dbResult = jdbcTemplate.update(query, otpHash, userId);
                return dbResult > 0;
            } else {
                // Insert new OTP hash for a new user
                query = "INSERT INTO OTP(OTPHASH, USERID) VALUES(?,?)";
                int dbResult = jdbcTemplate.update(query, otpHash, userId);
                return dbResult > 0;
            }
        }
        catch(Exception e){
            return false;
        }
    }

    public String getUserOtpHash(String userId){
        try{
            String query = "SELECT OTPHASH FROM OTP WHERE USERID = ?";
            String dbResult = (String) jdbcTemplate.queryForObject(query, String.class, userId);
            return dbResult;
        }
        catch(Exception e){
            return null;
        }
    }
}
