package com.pixel.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pixel.model.Photo;
import com.pixel.model.User;



@Repository
public interface PhotoDao extends CrudRepository <Photo, Long> {

	Photo save(Photo user);
	
	List<Photo> findByUser(User user);

	List<Photo> findAll();

	Photo findByPhotoId(Long photoId);


}
