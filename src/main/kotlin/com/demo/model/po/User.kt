package com.demo.model.po

import io.quarkus.mongodb.panache.common.MongoEntity
import org.bson.types.ObjectId

@MongoEntity
class User {

    var id: ObjectId? = null;

    var account: String = "";

    var password: String = "";

    var name: String = "";

}