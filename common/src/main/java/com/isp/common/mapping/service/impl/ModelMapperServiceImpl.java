package com.isp.common.mapping.service.impl;

import com.isp.common.mapping.TypeMapping;
import com.isp.common.mapping.service.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ModelMapperServiceImpl implements ModelMapperService {

    final Collection<TypeMapping> typeMappings;

    ModelMapper mapper = new ModelMapper();

    @PostConstruct
    private void init() {
        typeMappings.forEach(typeMapping -> typeMapping.addMapping(mapper));
    }

    @Override
    public <T, U> U map(T source, Class<U> destinationClazz) {
        return mapper.map(source, destinationClazz);
    }

    @Override
    public <T, U> void map(T source, U destination) {
        mapper.map(source, destination);
    }

    @Override
    public <T, U> Collection<U> map(Collection<T> sources, TypeToken<Collection<U>> destinationTypeToken) {
        return mapper.map(sources, destinationTypeToken.getType());
    }

}
