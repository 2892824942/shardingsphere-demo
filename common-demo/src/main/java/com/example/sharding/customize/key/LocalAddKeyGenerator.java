package com.example.sharding.customize.key;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

@Slf4j
public class LocalAddKeyGenerator implements ShardingKeyGenerator {
    private Properties properties = new Properties();
    private static  int START = 0;

    @Override
    public Comparable<?> generateKey() {
        START++;
        log.info("get MyKeyGenerator id:{}", START);
        return START;
    }

    @Override
    public String getType() {
        return "localAddKey";
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