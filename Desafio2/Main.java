package Desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Venda> vendas = new ArrayList<>();

        vendas.add(new Venda(1L, "Teclado", 2, 150.00, LocalDate.of(2026, 1, 15), "Periféricos"));
        vendas.add(new Venda(2L, "Monitor 24'", 1, 900.00, LocalDate.of(2025, 12, 20), "Monitores"));
        vendas.add(new Venda(3L, "Mouse Gamer", 5, 80.00, LocalDate.of(2026, 2, 2), "Periféricos"));
        vendas.add(new Venda(4L, "Teclado", 3, 150.00, LocalDate.of(2026, 2, 10), "Periféricos"));
        vendas.add(new Venda(5L, "Monitor 24'", 2, 900.00, LocalDate.of(2026, 1, 20), "Monitores"));
        
        //cálculo do total do faturamento com Stream API java 8
        double totalFaturamento = vendas.stream()
                .filter(venda -> venda.getDataVenda().getYear() == 2026)
                .reduce(0.0, (total, venda) -> total + (venda.getQuantidade() * venda.getValorUnitario()), Double::sum);
        //cálculo do produto mais vendido com Stream API java 8
        Map<String, Integer> quantidadePorProduto = vendas.stream()
        .filter(venda -> venda.getDataVenda().getYear() == 2026)
        .collect(Collectors.groupingBy(
                Venda::getProduto,
                Collectors.summingInt(Venda::getQuantidade)
        ));

        String produtoMaisVendido = quantidadePorProduto.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum produto vendido");
        //lista de IDs das vendas com quantidade maior ou igual a 3 com Stream API java 8
        List<Long> idvendasLote = vendas.stream()
               .filter(venda -> venda.getDataVenda().getYear() == 2026)
               .filter(venda -> venda.getQuantidade() >= 3)
               .map(Venda::getId)
               .toList();
            

        System.out.println("Total de vendas: " + totalFaturamento);
        System.out.println("Produto mais vendido: " + produtoMaisVendido);
        System.out.println("IDs das vendas com quantidade maior ou igual a 3: " + idvendasLote);

    }
}
