package com.productmanagement.CSVConvertor;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.productmanagement.model.Product;
import com.productmanagement.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileReader;
import java.util.List;


public class csvToJson {

    @Autowired
    Producer producer;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public  List<Product> main() throws Exception
    {
        CsvToBean csv = new CsvToBean();

        String csvFilename = "c:\\files\\dataExample.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

        //Set column mapping strategy
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
