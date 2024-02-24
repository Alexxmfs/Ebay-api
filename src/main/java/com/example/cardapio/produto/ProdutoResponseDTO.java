package com.example.cardapio.produto;

public record ProdutoResponseDTO(Long id, String categoria, String subcategoria, String titulo, String preco, String disponivel, String vendido, String vendedor, String detalhes) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(), produto.getCategoria(), produto.getSubcategoria(), produto.getTitulo(),  produto.getPreco(), produto.getDisponivel(), produto.getVendido(), produto.getVendedor(), produto.getDetalhes());
    }
}
