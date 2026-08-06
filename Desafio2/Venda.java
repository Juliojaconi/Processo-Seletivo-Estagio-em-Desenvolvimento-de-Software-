package Desafio2;

import java.time.LocalDate;
import java.util.Date;

public class Venda {
    private Long id;
    private String produto;
    private int quantidade;
    private double valorUnitario;
    private LocalDate dataVenda;
    private String categoria;



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Venda() {
    }

    public Venda(Long id, String produto, int quantidade,double valorUnitario, LocalDate dataVenda, String categoria) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.dataVenda = dataVenda;
        this.categoria = categoria;
    }
}


