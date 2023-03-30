package com.example.Hotel.ApiHotel.Models;

import com.example.Hotel.ApiHotel.DTO.ClientDTO;
import com.example.Hotel.ApiHotel.DTO.EnderecoDTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class ClientDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JoinColumn(name = "idCliente")
    private Long id;

    @Embedded
    private EnderecoDAO endereco;
    @NotEmpty
    private String senha;
    @NotBlank
    @Size(min = 3,max = 25, message = "Apelidos nao são validos")
    private String nome;
    private String sobrenome;
    private String telefone;
    @Email
    private String email;
    private String aniversario;

    public ClientDTO toDTO (){
        return ClientDTO.builder()
                .id(id)
                .senha(senha)
                .endereco(endereco.toDTO())
                .nome(nome)
                .sobrenome(sobrenome)
                .telefone(telefone)
                .email(email)
                .aniversario(aniversario)
                .build();
    }
}