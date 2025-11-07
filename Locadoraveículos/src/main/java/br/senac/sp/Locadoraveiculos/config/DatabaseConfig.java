package br.senac.sp.Locadoraveiculos.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DatabaseProperties.class)

public class DatabaseConfig {

    private final DatabaseProperties PROPS;

    public DatabaseConfig(DatabaseProperties props){
        this.PROPS = props;
    }
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(PROPS.getUrl());
        builder.username(PROPS.getUsername());
        builder.password(PROPS.getPassword());
        builder.driverClassName(PROPS.getDriverClassName());
        return builder.build();
    }
}
