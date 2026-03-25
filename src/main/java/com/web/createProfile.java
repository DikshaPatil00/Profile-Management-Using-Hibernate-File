package com.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.profile;
import com.utils.Hibernetutils;

public class createProfile {
	
	public static void main(String[] args) throws IOException {
		
		SessionFactory sessionFactory = Hibernetutils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//reading image path
		final String uploadDri = "upload/";
		String filename ="java.jpg";
		Path imgpath = Paths.get("C:\\Users\\Diksha\\Downloads/"+filename);
		
		//reading the img file bytes
		byte[] filedata =Files.readAllBytes(imgpath);
		
		//define filetype
		String filetype = "image/*";
		
		//we can validate img size (max length should be 5 MB)
		if (filedata.length > 5* 1024 * 1024) {
		   throw new RuntimeException("image size cannot be more than 5 MB");
		}
		
		//validate file type
		if (!filetype.startsWith("image/")) {
			throw new RuntimeException("image fileType invalid");	
		}
		
		//defining where we can upload actual image right now it wis in local cumputer in upload folder
		//this will replace with AWS-s3
		Path filePath= Paths.get(uploadDri+ filename);
		
		//if upload folder is not exist then create
		Files.createDirectories(filePath.getParent());
		
		//save/write actual image to upload folder
		Files.write(filePath, filedata);
		
		//store/save image meta data to the database using hibernate
		profile p = new profile();
		p.setUsername("jay");
		p.setTitle(filename);
		p.setBio("learning core java adv java and project");
		p.setUrl(filePath.toString());
		p.setType(filetype);
		
		session.save(p);
		
		transaction.commit();
		session.close();
		
		System.out.println("profile created!!!");
	}

}
