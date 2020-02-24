package br.com.teste.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.teste.api.entity.Carrinho;
import br.com.teste.api.repository.CarrinhoRepository;

@RestController
@RequestMapping({"/carrinho"})
public class CarrinhoController {

   private CarrinhoRepository repository;

   CarrinhoController(CarrinhoRepository carrinhoRepository) {
       this.repository = carrinhoRepository;
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
   public Carrinho create(@RequestBody Carrinho carrinho){
      return repository.save(carrinho);
   }
   
   @PutMapping(value="/{id}")
   public ResponseEntity update(@PathVariable("id") int id,
                                         @RequestBody Carrinho carrinho) {
      return repository.findById(id)
              .map(record -> {
                  Carrinho updated = repository.save(record);
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
