package com.it4all.credit.admon.data.mapper;

public interface GenericMapper <dto, entity> {

	public entity dtoToEntity(dto dto);

	public dto entityToDTO(entity entity);
}
