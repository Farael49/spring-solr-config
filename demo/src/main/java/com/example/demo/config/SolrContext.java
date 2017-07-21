package com.example.demo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages={"com.example.demo.repository"})
public class SolrContext {

	static final String SOLR_HOST = "solr.host";

	@Autowired
	private Environment environment;

	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient.Builder(environment.getProperty(SOLR_HOST)).build();
	}

	@Bean
	public SolrTemplate solrTemplate() {
		return new SolrTemplate(solrClient());
	}

	@Bean
	public SolrTemplate core1Template() {
		return new SolrTemplate(new HttpSolrClient.Builder(environment.getProperty(SOLR_HOST)+"/core1").build());
	}

	@Bean
	public SolrTemplate core2Template() {
		return new SolrTemplate(new HttpSolrClient.Builder(environment.getProperty(SOLR_HOST)+"/core2").build());
	}
}
