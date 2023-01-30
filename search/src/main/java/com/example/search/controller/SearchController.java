package com.example.search.controller;

import com.example.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search/{role}/{id}")
    public ResponseEntity<?> getDetails(@PathVariable("role") String role,
                                        @PathVariable("id") Long id) throws ExecutionException, InterruptedException {
        Object body = new Object();
        if(role.equals("student")){
            body = searchService.findStd(id).get();
        }else if(role.equals("employee")){
            body = searchService.findEmp(id).get();
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
