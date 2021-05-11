package com.example.sharding.customize.encrypt;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.encrypt.strategy.spi.Encryptor;

import java.util.Properties;

@NoArgsConstructor
@Data
@Slf4j
public final class Sha256Encryptor implements Encryptor {

    private Properties properties = new Properties();

    @Override
    public void init() {

    }

    @Override
    public String encrypt(final Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        log.info("Sha256Encryptor encrypt，value:{}", plaintext);

        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }

    @Override
    public Object decrypt(final String ciphertext) {
        log.info("Sha256Encryptor decrypt，value:{}", ciphertext);
        return ciphertext;
    }

    @Override
    public String getType() {
        return "sha256";
    }

    @Override
    public void setProperties(Properties properties) {
        if (properties == null) {
            return;
        }
        this.properties = properties;
    }

}
