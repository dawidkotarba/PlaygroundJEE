package com.dawidkotarba.playground.integration.assembler;

import com.dawidkotarba.playground.exceptions.InternalErrorException;
import com.dawidkotarba.playground.integration.dto.CapitalDto;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Capital;
import com.dawidkotarba.playground.model.entities.Country;
import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by Dawid Kotarba on 01.12.2015.
 */
public class CountryAssembler {

    private CountryAssembler() {
        // intentionally left blank
    }

    public static CountryDto convert(Country country) {
        try {

            CapitalDto capitalDto = new CapitalDto();
            BeanUtils.copyProperties(capitalDto, country.getCapital());

            CountryDto countryDto = new CountryDto();
            countryDto.setCapital(capitalDto);
            countryDto.setArea(country.getArea());
            countryDto.setCurrency(country.getCurrency());
            countryDto.setName(country.getName());
            countryDto.setPopulation(country.getPopulation());

            country.getNeighbours().forEach(neighbour -> countryDto.getNeighbourCountriesNames().add(neighbour.getName()));

            return countryDto;
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new InternalErrorException("Cannot convert country entity to dto", ex);
        }
    }

    public static Country convert(CountryDto countryDto) {
        try {
            Country country = new Country();
            Capital capital = new Capital();
            BeanUtils.copyProperties(capital, countryDto.getCapital());
            country.setCapital(capital);
            country.setArea(countryDto.getArea());
            country.setCurrency(countryDto.getCurrency());
            country.setName(countryDto.getName());
            country.setPopulation(countryDto.getPopulation());

            return country;
        } catch (IllegalAccessException | InvocationTargetException ex) {
            throw new InternalErrorException("Cannot convert country dto to enitity", ex);
        }
    }

    public static List<CountryDto> convertToDto(List<Country> countries) {
        List<CountryDto> result = new ArrayList<>();
        countries.forEach(country -> result.add(convert(country)));
        return result;
    }

    public static List<Country> convertToEntity(List<CountryDto> countries) {
        List<Country> result = new ArrayList<>();
        countries.forEach(country -> result.add(convert(country)));
        return result;
    }
}
