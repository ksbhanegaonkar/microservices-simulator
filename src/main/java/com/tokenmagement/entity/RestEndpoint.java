package com.tokenmagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "REST_ENDPOINTS")
public class RestEndpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "URL",nullable = false,unique = true)
    private String url;
    @Column(name = "RESPONSE_BODY")
    private String responseBody;



    public RestEndpoint(String url, String responseBody) {
        this.url = url;
        this.responseBody = responseBody;
    }


    public RestEndpoint(String name, String description, String url, String responseBody) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.responseBody = responseBody;
    }

    public RestEndpoint() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RestEndpoint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
