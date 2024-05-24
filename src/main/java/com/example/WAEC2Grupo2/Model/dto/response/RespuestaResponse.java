package com.example.WAEC2Grupo2.Model.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaResponse {
    private String mensaje;
    private boolean resultado;
}
