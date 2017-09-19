/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.dao.impl;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.jass2125.persistence.polyglote.core.dao.client.DocumentDao;
import io.github.jass2125.persistence.polyglote.core.entity.Document;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 18/09/2017 21:51:36
 */
public class DocumentDaoImp implements DocumentDao {

    @Inject
    private MongoCollection<org.bson.Document> colletion;

    @Override
    public void save(Document document) {
        Gson gson = new Gson();
        String json = gson.toJson(document);
        org.bson.Document doc = new org.bson.Document();
        doc.append("document", json);
        colletion.insertOne(doc);
        System.out.println(document);
    }

    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase database = client.getDatabase("test");
        System.out.println(database);
        MongoCollection<org.bson.Document> collection = database.getCollection("teste");
        System.out.println(collection.count());
    }
}
