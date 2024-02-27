package com.example.cardapio.controller;

import com.example.cardapio.produto.Produto;
import com.example.cardapio.produto.ProdutoRepository;
import com.example.cardapio.produto.ProdutoRequestDTO;
import com.example.cardapio.produto.ProdutoResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveProduto(@RequestBody ProdutoRequestDTO data){
        Produto produtoData = new Produto(data);
        repository.save(produtoData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(optionalProduto.get());
            return ResponseEntity.ok(produtoResponseDTO);
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoResponseDTO> getAll(){

        List<ProdutoResponseDTO> produtoList = repository.findAll().stream().map(ProdutoResponseDTO::new).toList();
        return produtoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestDTO data) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setCategoria(data.categoria());
            produto.setSubcategoria(data.subcategoria());
            produto.setTitulo(data.titulo());
            produto.setPreco((data.preco()));
            produto.setDisponivel(data.disponivel());
            produto.setVendido(data.vendido());
            produto.setVendedor(data.vendedor());
            produto.setDetalhes(data.detalhes());
            repository.save(produto);
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable Long id){
        Optional<Produto> optionalProduto = repository.findById(id);
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            repository.delete(produto);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
    }

}
