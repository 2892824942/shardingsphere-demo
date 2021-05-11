package com.example.sharding.customize.key;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

@Slf4j
public class MyKeyGenerator implements ShardingKeyGenerator {
    private Properties properties = new Properties();

    @Override
    public Comparable<?> generateKey() {
        long id = System.currentTimeMillis();
        log.info("get MyKeyGenerator id:{}", id);
        return id;
    }

    @Override
    public String getType() {
        return "timeId";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}