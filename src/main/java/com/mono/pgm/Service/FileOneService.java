package com.mono.pgm.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mono.pgm.Model.FileOne;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileOneService
{
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public String addFileOne(String title, MultipartFile file) throws IOException
    {
        DBObject metaData = new BasicDBObject();
        metaData.put("type","file");
        metaData.put("title",title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getOriginalFilename(),file.getContentType(),metaData);
        return id.toString();
    }

    public FileOne getFileOne(String t) throws IOException
    {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(t)));
        FileOne fl = new FileOne();
        fl.setTitle(file.getMetadata().get("title").toString()); // keep an eye here
        fl.setStr(operations.getResource(file).getInputStream());
        return fl;
    }

}
