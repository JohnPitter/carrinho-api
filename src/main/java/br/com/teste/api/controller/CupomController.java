package br.com.teste.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.teste.api.entity.Cupom;
import br.com.teste.api.repository.CupomRepository;

@RestController
@RequestMapping({"/cupom"})
public class CupomController {

   private CupomRepository repository;

   CupomController(CupomRepository cupomRepository) {
       this.repository = cupomRepository;
   }
   
   @GetMapping
   public List findAll(){
      return repository.findAll();
   }
   
   @GetMapping(path = {"/{id}"})
   public ResponseEntity findById(@PathVariable int id){
      return repository.findById(id)
              .map(record -> ResponseEntity.ok().body(record))
              .orElse(ResponseEntity.notFound().build());
   }
   
   @PostMapping
   public Cupom create(@RequestBody Cupom cupom){
      return repository.save(cupom);
   }
   
   @PutMapping(value="/{id}")
   public ResponseEntity update(@PathVariable("id") int id,
                                         @RequestBody Cupom cupom) {
      return repository.findById(id)
              .map(record -> {
            	  record.setCode(cupom.getCode());
                  record.setDesc(cupom.getDesc());
                  record.setPercent(cupom.getPercent());
                  Cupom updated = repository.save(record);
                  return ResponseEntity.ok().body(updated);
              }).orElse(ResponseEntity.notFound().build());
   }
   
   @DeleteMapping(path ={"/{id}"})
   public ResponseEntity<?> delete(@PathVariable int id) {
      return repository.findById(id)
              .map(record -> {
                  repository.deleteById(id);
                  return ResponseEntity.ok().build();
              }).orElse(ResponseEntity.notFound().build());
   }
} 
