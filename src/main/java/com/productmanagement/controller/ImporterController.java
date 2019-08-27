package com.productmanagement.controller;

import com.productmanagement.CSVConvertor.csvToJson;
import com.productmanagement.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
public class ImporterController {
	
	@Autowired
    Producer producer;

	
/*	@RequestMapping("/send")
	public String sendMsg(@RequestParam("msg")String msg){
		producer.produceMsg(msg);
		return "Done";
	}*/

	/*@RequestMapping("/importCsv")
	public String importCsv(@RequestParam("msg")String msg){

		producer.produceMsg(msg);
		return "imported";
	}*/
    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {

        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }

        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();

        csvToJson cj= new csvToJson();


        producer.produceProduct(cj.main());
        // Do processing with uploaded file data in Service layer

        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }

    @RequestMapping( "/item" )
    public String getStockItem() {
        return "It's working...!";
    }




}
