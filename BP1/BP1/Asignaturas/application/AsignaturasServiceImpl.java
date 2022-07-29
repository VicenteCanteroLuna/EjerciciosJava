package com.bosonit.BP1.Asignaturas.application;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasOutputDtoFull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AsignaturasServiceImpl implements AsignaturasService {
    @Override
    public AsignaturasOutputDtoFull crearAsignatura(AsignaturasInputDto asignaturasInputDto) throws Exception {
        return null;
    }

    @Override
    public AsignaturaOutputDto dameAsignaturaID(int id, String ouputType) throws Exception {
        return null;
    }

    @Override
    public List<AsignaturasOutputDtoFull> dameAsignaturas() {
        return null;
    }

    @Override
    public AsignaturasOutputDtoFull actualizaAsignatura(int id, AsignaturasInputDto asignaturasInputDto) {
        return null;
    }
}
