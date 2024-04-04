package org.pratice.banking.feature.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserMapper {

}
