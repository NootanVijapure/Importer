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


    @PostMapping("/upload")
    public ResponseEntity<String> uploadData() throws Exception {

        csvToJson cvsToJsonObj= new csvToJson();

        producer.produceProduct(cvsToJsonObj.main());
        // Do processing with uploaded file data in Service layer

        return new ResponseEntity<String>("File uploaded", HttpStatus.OK);
    }

    @RequestMapping( "/item" )
    public String getStockItem() {
        return "It's working...!";
    }




}
