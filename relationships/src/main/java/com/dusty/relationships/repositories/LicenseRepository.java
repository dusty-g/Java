package com.dusty.relationships.repositories;

import com.dusty.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dusty on 7/20/17.
 */
@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
}
