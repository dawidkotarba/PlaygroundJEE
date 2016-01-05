package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.assembler.CountryAssembler;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.commons.lang3.StringUtils;
//import javax.persistence.Cacheable;

/**
 *
 * @author Dawid Kotarba
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CountryDao extends AbstractDao {
    
   public List<CountryDto> getAll() {
        List<Country> result = entityManager.createQuery("SELECT c FROM Country c").getResultList();
        return CountryAssembler.convertToDto(result);
    }

//    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        List<Country> result = entityManager.createQuery("SELECT c FROM Country c where c.name LIKE :name").setParameter("name","%" + name + "%").getResultList();
        return CountryAssembler.convertToDto(result);
    }

    public void add(CountryDto countryDto) {
        Preconditions.checkNotNull(countryDto, "countryDto cannot be null");
        entityManager.persist(CountryAssembler.convert(countryDto));
    }
}
