package com.github.josedafonsecajr.citiesapi.swagger;

import com.github.josedafonsecajr.citiesapi.cities.entities.City;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Api(value = "/cities", tags = {"Cities"})
public interface ICityResource {

    @ApiOperation(value = "Consulta cidades cadastradas", nickname = "cities", notes = "",
            tags = {"Cities"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "Lista de cidades consultadas com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisção estão inconsistentes"),
            @ApiResponse(code = 404, message = "Lista de cidades não encontradas")
    })
    @GetMapping
    public Page<City> cities(final Pageable page);

    @ApiOperation(value = "Consulta de cidade pelo nome", nickname = "cityByName", notes = "",
            tags = {"Cities"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cidade encontrada com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisção estão inconsistentes"),
            @ApiResponse(code = 404, message = "Cidade não encontrada")
    })
    @PostMapping(value = "/find")
    public ResponseEntity<City> cityByName(@RequestBody Map<String, String> name);

}
