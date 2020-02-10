package com.isp.common.mapping;

import org.modelmapper.ModelMapper;

public interface TypeMapping {

    /**
     * Add new type mapping to the single instance of model mapper.
     *
     * @param modelMapper Model mapper instance.
     */
    void addMapping(ModelMapper modelMapper);

}
