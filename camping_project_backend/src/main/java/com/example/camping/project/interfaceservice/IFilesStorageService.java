package com.example.camping.project.interfaceservice;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
public interface IFilesStorageService {
// Initialize the file storage directory 
public void init();
// Save a file to the storage directory
public String save (MultipartFile file);
// Load a file resource from the storage directory.
public Resource load(String filename);
// Delete a file from the storage directory
public void delete(String filename);

}