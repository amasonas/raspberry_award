package com.teste.raspberyaward.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Component
public class ExcelReader {

    @Autowired
    ResourceLoader resourceLoader;

    public List<String> getMovieListFromResources() {
        Logger logger = LoggerFactory.getLogger(ExcelReader.class);

        try {
            Resource resource = resourceLoader.getResource("classpath:movielist.csv");
            InputStream inputStream = resource.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);
            String lineDelimiter = data.indexOf("\r\n") > -1 ? "\r\n" : "\n";

            return Arrays.asList(data.split(lineDelimiter));
        } catch (FileNotFoundException exception) {
            logger.error("The movielist.csv file was not found in the resources folder");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
