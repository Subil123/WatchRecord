package com.fashion.watch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.watch.entity.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer>{

}
