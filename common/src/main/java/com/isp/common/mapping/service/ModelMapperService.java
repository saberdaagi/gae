package com.isp.common.mapping.service;

import org.modelmapper.TypeToken;

import java.util.Collection;

/**
 * Model Mapper Service.
 */
public interface ModelMapperService {

    /**
     * Maps a source object to destination class.
     *
     * @param source           Source object.
     * @param destinationClazz Destination class.
     * @param <T>              Source type.
     * @param <U>              Target type.
     * @return New object of type destination class.
     */
    <T, U> U map(T source, Class<U> destinationClazz);

    /**
     * Maps a source object to destination object.
     *
     * @param source      Source object.
     * @param destination Destination object.
     * @param <T>         Source type.
     * @param <U>         Target type.
     */
    <T, U> void map(T source, U destination);

    /**
     * Maps a source of collection to collection destination.
     *
     * @param sources              Collection source.
     * @param destinationTypeToken Destination type token.
     * @param <T>                  Source type.
     * @param <U>                  Target type.
     * @return New mapped collection.
     */
    <T, U> Collection<U> map(Collection<T> sources, TypeToken<Collection<U>> destinationTypeToken);

}
