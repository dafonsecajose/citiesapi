package com.github.josedafonsecajr.citiesapi.swagger;

import com.github.josedafonsecajr.citiesapi.contries.entities.Country;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Api(value = "/countries", tags = {"Countries"})
public interface ICountryResource {

    @ApiOperation(value = "Consulta de paises cadastrados", nickname = "countries", notes = "",
            tags = {"Countries"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "Lista de paises consultados com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisção estão inconsistentes"),
            @ApiResponse(code = 404, message = "Lista de paises não encontrados")
    })
    @GetMapping
    public Page<Country> countries(Pageable page);

    @ApiOperation(value = "Consulta de pais por ID", nickname = "getOne", notes = "",
            tags = {"Countries"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "País consultado com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisção estão inconsistentes"),
            @ApiResponse(code = 404, message = "País não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id);
}
