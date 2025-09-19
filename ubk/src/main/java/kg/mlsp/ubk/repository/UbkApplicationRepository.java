package kg.mlsp.ubk.repository;

import feign.Param;
import kg.mlsp.ubk.model.UbkApplication;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UbkApplicationRepository extends JpaRepository<UbkApplication, Integer>, JpaSpecificationExecutor<UbkApplication> {

    // Получить последнюю заявку по дате (если есть)
    // Проверка на дублирование по ПИН заявителя и ПИН членов семьи
    @Query("SELECT DISTINCT a FROM UbkApplication a " +
            "LEFT JOIN a.familyMembers fm " +
            "WHERE (a.applicantPin = :applicantPin OR fm.familyMemberPin = :applicantPin) " +
            "AND a.statusId IN :activeStatuses " +
            "AND a.id != :applicationId " +
            "ORDER BY a.registrationDate DESC")
    List<UbkApplication> findActiveDuplicates(
            @Param("applicantPin") String applicantPin,
            @Param("applicationId") Integer applicationId,
            @Param("activeStatuses") Iterable<Integer> activeStatuses,
            Pageable pageable
    );

}
