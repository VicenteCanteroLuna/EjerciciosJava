package com.bosonit.BP1.Asignaturas.application;

import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasInputDto;
import com.bosonit.BP1.Asignaturas.infrastructure.controller.dto.AsignaturasOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoFull;
import com.bosonit.BP1.Estudiante.infrastructure.controller.dto.StudentOutputDtoSimple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AsignaturasService {

    AsignaturasOutputDtoFull crearAsignatura(AsignaturasInputDto asignaturasInputDto) throws Exception;

    AsignaturaOutputDto dameAsignaturaID(int id, String ouputType) throws Exception;

    List<AsignaturasOutputDtoFull> dameAsignaturas();

    AsignaturasOutputDtoFull actualizaAsignatura(int id, AsignaturasInputDto asignaturasInputDto);
}
