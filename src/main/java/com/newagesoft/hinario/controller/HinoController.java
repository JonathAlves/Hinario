package com.newagesoft.hinario.controller;

import com.newagesoft.hinario.dto.HinoDTO;
import com.newagesoft.hinario.exception.NotFoundException;
import com.newagesoft.hinario.service.HinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/hino")
public class HinoController {

    @Autowired
    private HinoService hinoService;

    @GetMapping
    public ResponseEntity<Page<HinoDTO>> findAllHinos(@PageableDefault(size = 10) Pageable pageable){
        try {
            return ResponseEntity.ok(hinoService.findAllDto(pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HinoDTO> findHinoById(@PathVariable long id){
        try {
            return ResponseEntity.ok(hinoService.find(id));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<HinoDTO> createHino(@RequestBody @Valid HinoDTO hinoDTO){
        try {
            return ResponseEntity.created(URI.create("/hino")).body(hinoService.save(hinoDTO));
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<HinoDTO> updateHino(@RequestBody HinoDTO hinoDTO){
        try {
            return ResponseEntity.ok(hinoService.update(hinoDTO));
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHino(@PathVariable long id){
        try {
            hinoService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
