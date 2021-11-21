package com.github.josedafonsecajr.citiesapi.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "/distances", tags = {"Distances"})
public interface IDistanceResource {
    @ApiOperation(value = "Consulta distancia entre cidades por points", nickname = "byPoints", notes = "",
            tags = {"Distances"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "Calculo de distancia realizado com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisição estão inconsistentes"),
            @ApiResponse(code = 404, message = "O Calculo nao foi encontrado")
    })
    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cityFrom,
                                   @RequestParam(name = "to") final Long cityTo);
    @ApiOperation(value = "Consulta distancia entre cidades por cubes", nickname = "byCube", notes = "",
            tags = {"Distances"})
    @ApiResponses(value =  {
            @ApiResponse(code = 200, message = "Calculo de distancia realizado com sucesso", responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para requisição estão inconsistentes"),
            @ApiResponse(code = 404, message = "O Calculo nao foi encontrado")
    })
    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cityFrom,
                                 @RequestParam(name = "to") final Long cityTo);
}
