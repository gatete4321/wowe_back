package com.mbste.controller;


import com.mbste.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@RestController
@RequestMapping("/public/pic")
public class PictureController {

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileupload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "invalid";
        }

        String fileName = file.getOriginalFilename();

        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        if (suffixName.contains("jpg") || suffixName.contains("JPG") || suffixName.contains("jpeg") || suffixName.contains("JPEG") || suffixName.contains("png") || suffixName.contains("PNG")) {
        } else {
            return "invalid data type";
        }

        File file1 = new File("D:\\project\\" + fileName);
        file1.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file1);
        outputStream.write(file.getBytes());
        outputStream.close();
        System.err.println(file.getContentType());

        return "" + file.getOriginalFilename();
    }


    @RequestMapping(value = "/download", produces = MediaType.IMAGE_JPEG_VALUE)
//produces = "application/json;charset=UTF-8")
    public ResponseEntity<byte[]> download(@RequestParam("filename") String filename) throws FileNotFoundException {
        String name = "D:\\project\\" + filename;
        File file = new File(name);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//        HttpHeaders headers=new HttpHeaders();
//        headers.add("Content-disposition",String.format("attachment; filename=\"%s\"",file.getName()));
//        headers.add("cash-control","no-cache,no store,must-revalidate");
//        headers.add("expires","0");
//        ResponseEntity<Object> entity=ResponseEntity.ok().headers(headers).contentLength(file.length())
//                .contentType(MediaType.parseMediaType("application/txt")).body(resource);

        byte[] datas = new byte[0];
        try {
            datas = StreamUtils.copyToByteArray(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(datas);

    }

    @RequestMapping(value = "/downloadId", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> downloadById(@RequestParam("id") Integer clientId) throws FileNotFoundException {

        String filename = clientDao.findImageById(clientId);
        String name = "D:\\project\\" + filename;
        File file = new File(name);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        byte[] datas = new byte[0];
        try {
            datas = StreamUtils.copyToByteArray(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(datas);

    }
}
