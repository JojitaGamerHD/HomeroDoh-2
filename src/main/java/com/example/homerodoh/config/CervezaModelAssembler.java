package com.example.homerodoh.config;

import com.example.homerodoh.controller.CervezaController;
import com.example.homerodoh.model.Cerveza;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CervezaModelAssembler
        implements RepresentationModelAssembler<Cerveza, EntityModel<Cerveza>> {

    @Override
    public EntityModel<Cerveza> toModel(Cerveza cerveza) {

        return EntityModel.of(
                cerveza,

                linkTo(methodOn(CervezaController.class)
                        .buscar(cerveza.getId()))
                        .withSelfRel(),

                linkTo(methodOn(CervezaController.class)
                        .listar())
                        .withRel("cervezas")
        );
    }
}