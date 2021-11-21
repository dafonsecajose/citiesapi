package com.github.josedafonsecajr.citiesapi.swagger;

import com.github.josedafonsecajr.citiesapi.states.entities.State;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Api(value = "/states", tags = {"States"})
public interface IStateResource {

    @ApiOperation(value = "Consulta estados cadastrados", nickname = "states", notes = "",
            tags = {"States"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "Lista de estados consultados com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisção estão inconsistentes"),
            @ApiResponse(code = 404, message = "Lista de estados não encontrados")
    })
    @GetMapping
    public List<State> states();
}
