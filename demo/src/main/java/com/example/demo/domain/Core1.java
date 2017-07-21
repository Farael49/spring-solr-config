package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by chris on 21/07/2017.
 */
@SolrDocument(solrCoreName = "core1")
public class Core1 {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
