package com.besafe.besafebackend.dao;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.modals.Classes.User.CheckIfUserExistsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ResultImpl createUserTable(){
        ResultImpl result  = new ResultImpl(1,"Failure in creating user table");
        try{
            String query = "CREATE TABLE IF NOT EXISTS USER(USERID VARCHAR(255) PRIMARY KEY, USERNAME VARCHAR(255), USEREMAIL VARCHAR(255), DOB DATE, JOINEDON DATE, USERSALT VARCHAR(255), USERDIGEST VARCHAR(255));";
            jdbcTemplate.update(query);
        }
        catch(Exception e){
            return result;
        }
        result.setErrorCode(0);
        result.setErrorMessage("Success");
        return result;
    }

    public boolean checkIfUserExists( String userId){

        try{
            this.createUserTable();
            String query = "SELECT COUNT(*) FROM USER WHERE USERID = ?";
            int dbResult = jdbcTemplate.queryForObject(query,Integer.class,userId);

            if(dbResult==0){
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception e){
            return false;
        }
    }

    public int addUserInfo(String userId, String userSalt){

        try{
            String query = "INSERT INTO USER(USERID, USEREMAIL, USERSALT, JOINEDON) VALUES(?,?,?,?);";
            int dbResult = jdbcTemplate.update(query,userId,userId,userSalt ,LocalDateTime.now());
            return dbResult;
        }
        catch(Exception e){
            return 0;
        }
    }

    public int storeUserDigest(String userId, String userDigest){
        try{
            String query = "UPDATE USER SET USERDIGEST = ? WHERE USERID = ?";
            int dbResult = jdbcTemplate.update(query, userDigest, userId);
            return dbResult;
        }
        catch(Exception e){
            return 0;
        }
    }

    public String getUserSalt(String userId){
        try{
            String query = "SELECT USERSALT FROM USER WHERE USERID = ?";
            String dbResult = jdbcTemplate.queryForObject(query,String.class,userId);
            return dbResult;
        }
        catch(Exception e){
            return null;
        }
    }

    public String getUserDigest(String userId){
        try{
            String query = "SELECT USERDIGEST FROM USER WHERE USERID = ?";
            String dbResult = jdbcTemplate.queryForObject(query,String.class,userId);
            return dbResult;
        }
        catch(Exception e){
            return null;
        }
    }
}
