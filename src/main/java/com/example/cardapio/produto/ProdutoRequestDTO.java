package com.example.cardapio.produto;

public record ProdutoRequestDTO(Long id, String categoria, String subcategoria, String titulo, String preco, String disponivel, String vendido, String vendedor, String detalhes) {
}


