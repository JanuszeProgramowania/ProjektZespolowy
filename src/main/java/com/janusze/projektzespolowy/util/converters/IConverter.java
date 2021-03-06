package com.janusze.projektzespolowy.util.converters;

/**
 * Created by Tomasz Jodko on 2016-04-06.
 */
public interface IConverter<OB, DTO> {
    OB mapDTOtoOB(DTO dto);

    DTO mapOBtoDTO(OB ob);
}
