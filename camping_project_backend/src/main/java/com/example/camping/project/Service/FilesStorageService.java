package com.example.camping.project.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.camping.project.interfaceservice.IFileStorageService;

@Service
public class FilesStorageService implements IFileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(FilesStorageService.class);

    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
            logger.info("Initialized folder for upload at {}", root.toAbsolutePath());
        } catch (IOException e) {
            logger.error("Could not initialize folder for upload!", e);
            throw new RuntimeException("Could not initialize folder for upload!", e);
        }
    }

    @Override
    public String save(MultipartFile file) {
        String uniqueFilename = "";
        try {
            uniqueFilename = generateUniqueFilename(file);
            Files.copy(file.getInputStream(), this.root.resolve(uniqueFilename));
            // Simulates a 2-second delay before completing tasks or responses.
            Thread.sleep(2000);
            logger.info("Saved file {} as {}", file.getOriginalFilename(), uniqueFilename);
            return uniqueFilename;
        } catch (FileAlreadyExistsException e) {
            logger.error("A file with the same name already exists: {}", uniqueFilename, e);
            throw new RuntimeException("A file with the same name already exists.", e);
        } catch (IOException e) {
            logger.error("Failed to save the file: {}", uniqueFilename, e);
            throw new RuntimeException("Failed to save the file: " + e.getMessage(), e);
        } catch (InterruptedException e) {
            logger.error("Thread was interrupted while saving the file: {}", uniqueFilename, e);
            throw new RuntimeException("Failed to save the file: " + e.getMessage(), e);
        }
    }

    private String generateUniqueFilename(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        }
        return UUID.randomUUID().toString() + extension;
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            URI uri = file.toUri();
            if (uri != null) {
                Resource resource = new UrlResource(uri);
                if (resource.exists() || resource.isReadable()) {
                    logger.info("Loaded file {}", filename);
                    return resource;
                } else {
                    logger.error("Could not read the file: {}", filename);
                    throw new IOException("Could not read the file!");
                }
            } else {
                logger.error("URI for the file is null: {}", filename);
                throw new RuntimeException("URI for the file is null!");
            }
        } catch (IOException e) {
            logger.error("Error reading the file: {}", filename, e);
            throw new RuntimeException("Error reading the file: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(String filename) {
        try {
            Path file = root.resolve(filename);
            Files.delete(file);
            logger.info("Deleted file {}", filename);
        } catch (IOException e) {
            logger.error("Could not delete the file: {}", filename, e);
            throw new RuntimeException("Could not delete the file: " + e.getMessage(), e);
        }
    }
}
