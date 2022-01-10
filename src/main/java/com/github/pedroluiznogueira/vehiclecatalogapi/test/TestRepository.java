package com.github.pedroluiznogueira.vehiclecatalogapi.test;

import com.github.pedroluiznogueira.vehiclecatalogapi.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
