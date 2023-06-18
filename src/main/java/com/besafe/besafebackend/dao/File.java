package com.besafe.besafebackend.dao;

import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class File {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createFileTable(){
        try{
            String query = "CREATE TABLE  IF NOT EXISTS  Files ( FILEID VARCHAR(255)  PRIMARY KEY,  USERID VARCHAR(255) NOT NULL,  FILEBYTES LONGBLOB , FILENAME VARCHAR(255) NOT NULL,  MIMETYPE VARCHAR(255) NOT NULL,DELETED TINYINT(1) NOT NULL DEFAULT 0,STARRED TINYINT(1) NOT NULL DEFAULT 0,ULTRASECURE TINYINT(1) NOT NULL DEFAULT 0,FOREIGN KEY (USERID) REFERENCES USER(USERID));";
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
                String query = "INSERT INTO Files(USERID, FILEID, FILENAME, MIMETYPE, DELETED, STARRED, ULTRASECURE) VALUES (?, ?, ?, ?, ?, ?, ?);";
                jdbcTemplate.update(query, userFile.getUserId(), userFile.getFileId(), userFile.getFileName(),
                        userFile.getMimeType(), userFile.isDeleted() ? 1 : 0, userFile.isStarred() ? 1 : 0, userFile.isUltraSafe() ? 1 : 0);
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

    public List<UserFile> getFilesByUserId(String userId) {
        try {
            String query = "SELECT * FROM Files WHERE USERID = ? AND DELETED = 0;";

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);

            List<UserFile> files = new ArrayList<UserFile>();

            for (Map<String, Object> row : rows) {
                UserFile file = new UserFile();
                file.setFileId(String.valueOf(row.get("FILEID")));
                file.setUserId(String.valueOf(row.get("USERID")));
                file.setFileName(String.valueOf(row.get("FILENAME"))); 
                file.setMimeType(String.valueOf(row.get("MIMETYPE")));
                file.setDeleted(String.valueOf(row.get("DELETED")).equals("1"));
                file.setStarred(String.valueOf(row.get("STARRED")).equals("1"));
                file.setUltraSafe(String.valueOf(row.get("ULTRASECURE")).equals("1"));
                files.add(file);
            }
            return files;
        } catch (Exception e) {
            return null;
        }
    }

    public List<UserFile> getUltraSafeFilesByUserId(String userId) {
        try {
            String query = "SELECT * FROM Files WHERE ULTRASECURE = 1 AND USERID = ? ";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);

            List<UserFile> files = new ArrayList<UserFile>();

            for (Map<String, Object> row : rows) {
                UserFile file = new UserFile();
                file.setFileId(String.valueOf(row.get("FILEID")));
                file.setUserId(String.valueOf(row.get("USERID")));
                file.setFileName(String.valueOf(row.get("FILENAME")));
                file.setMimeType(String.valueOf(row.get("MIMETYPE")));
                file.setDeleted(String.valueOf(row.get("DELETED")).equals("1"));
                file.setStarred(String.valueOf(row.get("STARRED")).equals("1"));
                file.setUltraSafe(String.valueOf(row.get("ULTRASECURE")).equals("1"));
                files.add(file);
            }
            return files;
        } catch (Exception e) {
            return null;
        }
    }

    public List<UserFile> getStarredFilesByUserId(String userId) {
        try {
            String query = "SELECT * FROM Files WHERE USERID = ? AND STARRED = 1";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);

            List<UserFile> files = new ArrayList<UserFile>();

            for (Map<String, Object> row : rows) {
                UserFile file = new UserFile();
                file.setFileId(String.valueOf(row.get("FILEID")));
                file.setUserId(String.valueOf(row.get("USERID")));
                file.setFileName(String.valueOf(row.get("FILENAME")));
                file.setMimeType(String.valueOf(row.get("MIMETYPE")));
                System.out.println(String.valueOf(row.get("DELETED")));
                System.out.println(String.valueOf(row.get("DELETED")).equals("1"));
                file.setDeleted(String.valueOf(row.get("DELETED")).equals("1"));
                file.setStarred(String.valueOf(row.get("STARRED")).equals("1"));
                file.setUltraSafe(String.valueOf(row.get("ULTRASECURE")).equals("1"));
                files.add(file);
            }
            return files;
        } catch (Exception e) {
            return null;
        }
    }

    public List<UserFile> getDeletedFilesByUserId(String userId) {
        try {
            String query = "SELECT * FROM Files WHERE USERID = ? AND DELETED = 1";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);

            List<UserFile> files = new ArrayList<UserFile>();

            for (Map<String, Object> row : rows) {
                UserFile file = new UserFile();
                file.setFileId(String.valueOf(row.get("FILEID")));
                file.setUserId(String.valueOf(row.get("USERID")));
                file.setFileName(String.valueOf(row.get("FILENAME")));
                file.setMimeType(String.valueOf(row.get("MIMETYPE")));
                file.setDeleted(String.valueOf(row.get("DELETED")).equals("1"));
                file.setStarred(String.valueOf(row.get("STARRED")).equals("1"));
                file.setUltraSafe(String.valueOf(row.get("ULTRASECURE")).equals("1"));

                files.add(file);
            }
            return files;
        } catch (Exception e) {
            return null;
        }
    }
}
