package com.pixel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pixel.dao.PhotoDao;
import com.pixel.model.Photo;
import com.pixel.model.User;
import com.pixel.service.PhotoService;


@Service
public class PhotoServiceImpl implements PhotoService{


    @Autowired
    private PhotoDao photoDao;

    public Photo save(Photo photo) {
        return photoDao.save(photo);
    }

    public List<Photo> findAll() {
        return photoDao.findAll();
    }

    public List<Photo> findByUser(User user) {
        return photoDao.findByUser(user);
    }

    public Photo findByPhotoId(Long photoId) {
        return photoDao.findByPhotoId(photoId);
    }
    

}
