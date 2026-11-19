package com.fashion.watch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fashion.watch.entity.Watch;
import com.fashion.watch.repository.WatchRepository;

@Service
public class WatchService {
	
	WatchRepository watchRepo;
	
	public WatchService(WatchRepository watchRepo) {
		this.watchRepo = watchRepo;
	}
	
	public Watch createWatchRecord(Watch watch) {
		
		return watchRepo.save(watch);
		
	}
	
	public List<Watch> getWatchList(){
		return watchRepo.findAll();
	}
	 
	public Optional<Watch> getWatchListById(int id ) {
		return watchRepo.findById(id);
	}
	
	public Watch updateWatchRecord(int id , Watch watch) {
		
		Watch editWatch =  watchRepo.findById(id).orElse(null);
		
		editWatch.setBrandName(watch.getBrandName());
		editWatch.setModelName(watch.getModelName());
		editWatch.setPrice(watch.getPrice());
		editWatch.setOriginCountry(watch.getOriginCountry());
		
		return watchRepo.save(editWatch);
		
	}
	
	public void deleteWatchRecordByID(int id) {
		
		watchRepo.deleteById(id);
		
	}

}
