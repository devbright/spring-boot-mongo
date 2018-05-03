package com.fst.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@ConfigurationProperties(prefix="spring.data.mongodb")
@EnableConfigurationProperties
@EnableMongoRepositories(basePackages = { "com.fst.repository" })
public class MongoConfiguration extends AbstractMongoConfiguration {

	private String host;
	private int port;
	private String authenicationDatabase;
	private String database;
	private String userName;
	private char[] password;
	
	@Override
	@Bean
	public MongoClient mongoClient() {
		MongoCredential credentialList = MongoCredential.createScramSha1Credential(userName, authenicationDatabase, password);
		ServerAddress seeds = new ServerAddress(host, port);
		Builder mongoClientOptionBuilder = MongoClientOptions.builder();
		mongoClientOptionBuilder.connectTimeout(1000);
		MongoClientOptions clientOptions = mongoClientOptionBuilder.build();
		MongoClient mongoClient = new MongoClient(seeds,credentialList, clientOptions);
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		return database;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAuthenicationDatabase() {
		return authenicationDatabase;
	}

	public void setAuthenicationDatabase(String authenicationDatabase) {
		this.authenicationDatabase = authenicationDatabase;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	

	
	
	

}
