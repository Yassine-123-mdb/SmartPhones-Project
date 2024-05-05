package com.yassine.phones.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yassine.phones.entities.SmartPhone;
import com.yassine.phones.entities.Type;

@RepositoryRestResource(path = "rest")
public interface PhonesRepostory extends JpaRepository<SmartPhone, Long> {

    List<SmartPhone> findByMarque(String marque);
    List<SmartPhone> findByMarqueContains(String marque);

    @Query("select p from SmartPhone p where p.marque like %:marque and p.prix > :prix")
    List<SmartPhone> findByMarquePrix(@Param("marque") String marque, @Param("prix") Double prix);

    @Query("select p from SmartPhone p where p.type = :type")
    List<SmartPhone> findByType(@Param("type") Type type);

    // Modifiez le nom de la méthode et le paramètre pour faire référence à la propriété correcte de Type
    List<SmartPhone> findByType_IdType(Long id);

    List<SmartPhone> findByOrderByMarqueAsc();

    @Query("select p from SmartPhone p order by p.marque ASC, p.prix DESC")
    List<SmartPhone> trierPhonesNomsPrix();
}
