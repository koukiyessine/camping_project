package com.example.camping.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
/* import org.springframework.web.bind.annotation.CrossOrigin;
 */import org.springframework.web.bind.annotation.GetMapping;
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
/*
 * @RestController
 * public class FilesStorageController {
 * 
 * }
 */
@RequestMapping("/api/storage")
/*
 * @CrossOrigin("http://localhost:3305")
 */
public class FilesStorageController {

    @Autowired
    FilesStorageService filestorageService;

    @Autowired
    Activiteservice activiteservice;

    @PatchMapping("/upload/{id}")
    public ResponseEntity<ResponseMessage> uploadFile(@PathVariable int id,
            @RequestParam(name ="file" ,required=true) MultipartFile file) {
        String message = "";
        try {
            String filename = filestorageService.save(file);
            // update contact
            activiteservice.updateActiviteImage(id, filename);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + " .Егror: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{filename:.+}")
    // The ".+" pattern in @PathVariable captures the full filename, including
    // extensions.
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        String message = "";
        try {
            Resource file = filestorageService.load(filename);
            return ResponseEntity.ok().body(file);
        } catch (Exception e) {
            message = "Could not get the file: " + filename;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
        }
    }
}
