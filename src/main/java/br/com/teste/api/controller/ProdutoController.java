package br.com.teste.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.teste.api.entity.Produto;
import br.com.teste.api.repository.ProdutoRepository;

@RestController
@RequestMapping({"/produto"})
public class ProdutoController {

   private ProdutoRepository repository;

   ProdutoController(ProdutoRepository produtoRepository) {
       this.repository = produtoRepository;
   }
   
   @GetMapping
   public List findAll(){
      return repository.findAll();
   }
   
   @GetMapping(path = {"/{id}"})
   public ResponseEntity findById(@PathVariable long id){
      return repository.findById(id)
              .map(record -> ResponseEntity.ok().body(record))
              .orElse(ResponseEntity.notFound().build());
   }
   
   @PostMapping
   public Produto create(@RequestBody Produto produto){
      return repository.save(produto);
   }
   
   @PutMapping(value="/{id}")
   public ResponseEntity update(@PathVariable("id") long id,
                                         @RequestBody Produto produto) {
      return repository.findById(id)
              .map(record -> {
                  Produto updated = repository.save(record);
                  return ResponseEntity.ok().body(updated);
              }).orElse(ResponseEntity.notFound().build());
   }
   
   @DeleteMapping(path ={"/{id}"})
   public ResponseEntity<?> delete(@PathVariable long id) {
      return repository.findById(id)
              .map(record -> {
                  repository.deleteById(id);
                  return ResponseEntity.ok().build();
              }).orElse(ResponseEntity.notFound().build());
   }
} 
