package com.tokenmagement.repository;

import com.tokenmagement.entity.RestEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RestEndpointRepository extends JpaRepository<RestEndpoint,Integer> {
    RestEndpoint getByUrl(String url);
}
