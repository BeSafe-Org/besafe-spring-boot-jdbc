package com.besafe.besafebackend.dao;

import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class File {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createFileTable(){
        try{
            String query = "CREATE TABLE  IF NOT EXISTS  Files ( FILEID VARCHAR(255)  PRIMARY KEY,  USERID VARCHAR(255) NOT NULL,  FILEBYTES LONGBLOB , FILENAME VARCHAR(255) NOT NULL,  MIMETYPE VARCHAR(255) NOT NULL,DELETED TINYINT(1) NOT NULL DEFAULT 0,STARRED TINYINT(1) NOT NULL DEFAULT 0,FOREIGN KEY (USERID) REFERENCES USER(USERID));";
            jdbcTemplate.update(query);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

        public boolean addFile(UserFile userFile) {
            try {
                this.createFileTable();
                String query = "INSERT INTO Files(USERID, FILEID, FILENAME, MIMETYPE, DELETED, STARRED) VALUES (?, ?, ?, ?, ?, ?);";
                jdbcTemplate.update(query, userFile.getUserId(), userFile.getFileId(), userFile.getFileName(),
                        userFile.getMimeType(), userFile.isDeleted() ? 1 : 0, userFile.isStarred() ? 1 : 0);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

    public boolean updateFile(UserFile userFile) {
        try {
            this.createFileTable();
            String query = "UPDATE Files SET  DELETED = ?, STARRED = ? WHERE FILEID = ?";
            jdbcTemplate.update(query, userFile.isDeleted() ? 1 : 0, userFile.isStarred() ? 1 : 0, userFile.getFileId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean deleteFile(String fileId){
        try{
            this.createFileTable();
            String query = "DELETE FROM Files WHERE FILEID = ?;";
            jdbcTemplate.update(query, fileId);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
