package com.tokenmagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "REST_ENDPOINTS")
public class RestEndpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "URL",nullable = false,unique = true)
    private String url;
    @Column(name = "RESPONSE_BODY")
    private String responseBody;

    public RestEndpoint(String url, String responseBody) {
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

    @Override
    public String toString() {
        return "RestEndpoint{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
