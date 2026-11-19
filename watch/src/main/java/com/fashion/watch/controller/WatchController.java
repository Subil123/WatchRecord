package com.fashion.watch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.watch.entity.Watch;
import com.fashion.watch.service.WatchService;

@RestController
@RequestMapping("/watch")
public class WatchController {
	
	WatchService watchservice;

	public WatchController(WatchService watchservice) {
		this.watchservice = watchservice;
	}
	
	@GetMapping
	public List<Watch> getWatchList() {
		return watchservice.getWatchList();
	}
	
	@GetMapping("{id}")
	public Optional<Watch> getWatchListById(@PathVariable int id) {
		return watchservice.getWatchListById(id);
	}
	
	@PostMapping
	public ResponseEntity<Watch> createWatchRecords(@RequestBody Watch watch) {
		Watch createWatchRecord =  watchservice.createWatchRecord(watch);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createWatchRecord);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Watch> updateWatchRecord(@PathVariable int id, @RequestBody Watch watch) {
		Watch UpdatedWatchRecord =    watchservice.updateWatchRecord(id, watch);
		return ResponseEntity.ok(UpdatedWatchRecord);
		  
	}
	
	@DeleteMapping("{id}")
	public void deleteWatchRecordByID(@PathVariable int id) {
		watchservice.deleteWatchRecordByID(id);
	}

}
