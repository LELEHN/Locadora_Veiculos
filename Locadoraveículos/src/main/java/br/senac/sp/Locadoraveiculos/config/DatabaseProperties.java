package br.senac.sp.Locadoraveiculos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app.datasource")
public class DatabaseProperties {
    
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

