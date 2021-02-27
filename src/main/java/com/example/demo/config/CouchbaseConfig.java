package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.connection}")
    private String connectionString;

    @Value("${couchbase.cluster.userName}")
    private String username;

    @Value("${couchbase.cluster.password}")
    private String password;

    @Value("${couchbase.bucket.bucketName}")
    private String bucketName;

    /*
    @PostConstruct
    public void init(){
        Cluster cluster = CouchbaseCluster.create(connectionString);
        ClusterManager clusterManager = cluster.clusterManager(username, password);
        String bucketFlag = String.valueOf(clusterManager.getBucket(bucketName) != null);
        if (bucketFlag.equals("true")) {
            System.out.println("=========Bucket has already========");
        } else {
            BucketSettings bucketSettings = new DefaultBucketSettings.Builder()
                    .type(BucketType.COUCHBASE)
                    .name(bucketName)
                    .quota(100) // megabytes
                    .build();
            clusterManager.insertBucket(bucketSettings);
            cluster.authenticate(username, password);
            Bucket bucket = cluster.openBucket(bucketName);
            bucket.bucketManager().createN1qlPrimaryIndex(true, false);
            System.out.println("===========Bucket create===========");
    }*/

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
            return bucketName;
        }

}

