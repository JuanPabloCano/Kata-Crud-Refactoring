package com.sofka.KataCrud.crud.Dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto implements Serializable {

    /* Creación de DTO (Data transfer Object), este sirve como puente para transferir datos
     entre procesos de la aplicación, como el front y el back. Es útil porque reduce la cantidad
     de datos que se necesitan enviar entre las conexiones de la aplicación
     */

    private Long id;
    private String name;
    private boolean completed;
}
