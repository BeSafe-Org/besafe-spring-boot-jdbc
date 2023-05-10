package com.besafe.besafebackend.dao;

import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BackupFileDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createBackupFileTable(){
        try{
            String query = "CREATE TABLE BACKUPFILES(" +
                    "  FILEID INT(255) NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "  FILEBYTES LONGBLOB NOT NULL);";
            jdbcTemplate.update(query);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean addBackupFile(UserFile userFile){
        try{
            this.createBackupFileTable();
            String query = "INSERT INTO BACKUPFILES(FILEBYTES) VALUES(?)";
            jdbcTemplate.update(query, userFile.getFileBytes());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public boolean deleteBackupFile(String fileId){
        try{
            this.createBackupFileTable();
            String query = "DELETE FROM BACKUPFILES WHERE FILEID = ?";
            jdbcTemplate.update(query, fileId);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
