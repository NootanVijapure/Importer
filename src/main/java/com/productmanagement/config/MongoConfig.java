package com.productmanagement.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConfig /*extends AbstractMongoConfiguration*/ {

  /*  @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient("mongo",27017);
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.productmanagement.model";
    }
*/
}
