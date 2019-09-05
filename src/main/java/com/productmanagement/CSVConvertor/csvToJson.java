package com.productmanagement.CSVConvertor;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.productmanagement.model.Product;
import com.productmanagement.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import sun.tools.jar.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;


public class csvToJson {

    @Autowired
    Producer producer;


    @Autowired
    ResourceLoader resourceLoader;


    @SuppressWarnings({"rawtypes", "unchecked"})
    public  List<Product> main() throws Exception
    {
        CsvToBean csv = new CsvToBean();

        ClassPathResource  res = new ClassPathResource(format(File.separator+"dataExample.csv",File.separator));
        InputStream inputStream1= res.getInputStream();

       CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream1));

        List list = csv.parse(setColumMapping(), csvReader);

        for (Object object : list) {
            Product product = (Product) object;
            product.setCreateDate();
            System.out.println(product);
        }

        return list;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public  ColumnPositionMappingStrategy setColumMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Product.class);
        String[] columns = new String[] {"uuid", "name", "descriptor", "provider","available","measurementUnits","createDate","lastModifiedDate"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
