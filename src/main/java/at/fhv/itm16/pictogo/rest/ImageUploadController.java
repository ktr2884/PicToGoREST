package at.fhv.itm16.pictogo.rest;

import at.fhv.itm16.pictogo.rest.storage.StorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Api(tags = "image upload", description = "image hosting, automatically resizing on upload")
public class ImageUploadController {

    private final StorageService storageService;

    @Autowired
    public ImageUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/image/{fileURI:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String fileURI) {
        Resource file = storageService.loadAsResource(fileURI);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/image")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        String filename = storageService.store(file);

        return new ResponseEntity<String>(filename, null, HttpStatus.OK);
    }

}
