package org.pratice.banking.feature.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" ,uses = {AccountMapper.class})
public interface AccountMapper {
}
