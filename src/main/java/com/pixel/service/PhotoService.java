package com.pixel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.pixel.model.Photo;
import com.pixel.model.User;


@Service
public interface PhotoService {

	Photo save (Photo photo);
	List<Photo> findAll();

	List<Photo> findByUser(User user);

	Photo findByPhotoId(Long photoId);


}
