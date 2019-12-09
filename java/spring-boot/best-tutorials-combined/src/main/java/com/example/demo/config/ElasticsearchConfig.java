package com.example.demo.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
//public class ElasticsearchConfig {
public class ElasticsearchConfig extends AbstractFactoryBean<RestHighLevelClient> {
    private RestHighLevelClient restHighLevelClient;

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.username}")
    private String userName;

    @Value("${elasticsearch.password}")
    private String password;

    @Override
    protected RestHighLevelClient createInstance() throws Exception {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));

        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port)).setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
        restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

    @Override
    public Class getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    public void destroy() {
        try {
            restHighLevelClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
