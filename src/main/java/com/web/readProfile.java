package com.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.profile;
import com.utils.Hibernetutils;

public class readProfile {
	
  public static void main(String[] args) throws IOException {
	
	  SessionFactory sessionFactory = Hibernetutils.getSessionFactory();
	  Session session = sessionFactory.openSession();
	  
	  profile profile = session.get(profile.class,3);
	  
	  System.out.println(profile.getId());
	  System.out.println(profile.getUsername());
	  System.out.println(profile.getBio());
	  System.out.println(profile.getUrl());
	  System.out.println(profile.getTitle());
	  System.out.println(profile.getType());
	  
	  //read the image file from the uploads folder
	  Path filePath=Paths.get("profile.getUrl()");
	  
	  if (Files.exists(filePath)) {
		byte[] allbyte = Files.readAllBytes(filePath);
		System.out.println("file reading done successfully : "+allbyte.length+ "bytes.");
	}else {
		System.out.println("image is not found in path:"+ filePath.toString());
	}
}
}
