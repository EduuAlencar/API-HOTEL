package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.HoteisDAO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoteisDTO {

    private Long id;

    private String nome;
    private String localizacao;
    private Integer quatidadeQuarto;
    private Double pagamento;
    private String infoPagamento;
    private String infoOperacinal;

    public HoteisDAO toDAO() {
        return HoteisDAO
                .builder()
                .id(id)
                .nome(nome)
                .localizacao(localizacao)
                .quantidadeQuarto(quatidadeQuarto)
                .pagamento(pagamento)
                .infoPagamento(infoPagamento)
                .infoOperacinal(infoOperacinal)
                .build();
    }
}