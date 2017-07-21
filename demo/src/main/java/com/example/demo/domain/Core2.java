package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by chris on 21/07/2017.
 */
@SolrDocument(solrCoreName = "core2")
public class Core2 {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
