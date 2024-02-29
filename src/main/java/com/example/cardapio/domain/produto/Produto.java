package com.example.cardapio.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoria;
    private String subcategoria;
    private String titulo;
    private String preco;
    private String disponivel;
    private String vendido;
    private String vendedor;
    private String detalhes;


    public Produto(ProdutoRequestDTO data){
        this.categoria = data.categoria();
        this.subcategoria = data.subcategoria();
        this.titulo = data.titulo();
        this.preco = data.preco();
        this.disponivel = data.disponivel();
        this.vendido = data.vendido();
        this.vendedor = data.vendedor();
        this.detalhes = data.detalhes();
    }

    public void setCategoria(String categoria) {this.categoria = categoria;}

    public void setSubcategoria(String subcategoria) {this.subcategoria = subcategoria;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public void setPreco(String preco) {this.preco = preco;}

    public void setDisponivel(String disponivel) {this.disponivel = disponivel;}

    public void setVendido(String vendido) {this.vendido = vendido;}

    public void setVendedor(String vendedor) {this.vendedor = vendedor;}

    public void setDetalhes(String detalhes) {this.detalhes = detalhes;}

}
