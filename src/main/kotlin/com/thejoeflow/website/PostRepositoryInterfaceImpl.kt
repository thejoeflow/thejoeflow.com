package com.thejoeflow.website

import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query

class PostRepositoryInterfaceImpl(private val mongoTemplate: MongoTemplate) : PostRepositoryInterfaceCustom {

    override fun findAllPostsSortedByPublishDateDesc(): List<BlogPost> {
        return mongoTemplate.find(Query().with(Sort(Sort.Direction.DESC, "published")), BlogPost::class.java)
    }
}