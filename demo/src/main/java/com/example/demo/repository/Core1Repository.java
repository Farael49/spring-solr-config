package com.example.demo.repository;

import com.example.demo.domain.Core1;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by chris on 21/07/2017.
 */
public interface Core1Repository extends SolrCrudRepository<Core1, String> {
}
