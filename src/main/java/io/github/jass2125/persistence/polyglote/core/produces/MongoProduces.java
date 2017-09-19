/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.persistence.polyglote.core.produces;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.enterprise.inject.Produces;
import org.bson.Document;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 18/09/2017 22:38:07
 */
public class MongoProduces {

    @Produces
    private MongoClient client = new MongoClient("localhost", 27017);
    @Produces
    private MongoDatabase database = client.getDatabase("test");
    @Produces
    private MongoCollection<Document> collection = database.getCollection("persistence");

}
