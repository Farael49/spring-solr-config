package com.example.demo.web;

import com.example.demo.domain.Core1;
import com.example.demo.domain.Core2;
import com.example.demo.repository.Core1Repository;
import com.example.demo.repository.Core2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by chris on 21/07/2017.
 */
@RestController
@RequestMapping("/app")
public class CoreController {

    @Resource
    private SolrTemplate solrTemplate;

    @Resource
    private SolrTemplate core1Template;

    @Resource
    private SolrTemplate core2Template;

    @Autowired
    private Core1Repository core1Repository;

    @Autowired
    private Core2Repository core2Repository;

    @RequestMapping(value = "/core1-add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Core1 core1Add() {
        return core1Repository.save(new Core1());
    }

    @RequestMapping(value = "/core1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Core1> core1() {
        return solrTemplate.queryForPage("core1",
                new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)), Core1.class)
                .getContent();
    }

    @RequestMapping(value = "/core1-implicit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Core1> core1g() {
        return core1Template.queryForPage(new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)), Core1.class)
                .getContent();
    }

    @RequestMapping(value = "/core2-add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Core2 core2Add() {
        return core2Repository.save(new Core2());
    }

    @RequestMapping(value = "/core2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Core2> core2() {
        return solrTemplate.queryForPage("core2",
                new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)), Core2.class)
                .getContent();
    }

    @RequestMapping(value = "/core2-implicit", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Core2> core2g() {
        return core2Template.queryForPage(new SimpleQuery(new Criteria(Criteria.WILDCARD).expression(Criteria.WILDCARD)), Core2.class)
                .getContent();
    }
}
