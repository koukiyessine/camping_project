package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.camping.project.Service.Activiteservice;
import com.example.camping.project.Service.FilesStorageService;
import com.example.camping.project.models.responses.ResponseMessage;

@Controller
@RequestMapping("/api/storage")
// @CrossOrigin("http://localhost:4200")
public class FilesStorageController {

  @Autowired
  private FilesStorageService storageService;

  @Autowired
  private Activiteservice actserv;

  @PatchMapping("/upload/{id}")
  public ResponseEntity<ResponseMessage> uploadFile(@PathVariable int id, @RequestParam("file") MultipartFile file) {
      String message = "";
      try {
          String filename = storageService.save(file);
          // Update contact
          actserv.updateActiviteImage(id, filename);
          message = "Uploaded the file successfully: " + file.getOriginalFilename();
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (RuntimeException e) {
          message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
      }
  }
  
  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<?> getFile(@PathVariable String filename) {
      try {
          Resource file = storageService.load(filename);
          return ResponseEntity.ok().body(file);
      } catch (RuntimeException e) {
          String message = "Could not get the file: " + filename + ". Error: " + e.getMessage();
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
      }
  }  
}
