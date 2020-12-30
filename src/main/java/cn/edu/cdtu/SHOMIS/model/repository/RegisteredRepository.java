package cn.edu.cdtu.SHOMIS.model.repository;

import cn.edu.cdtu.SHOMIS.model.entity.RegisteredDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author mars_sea
 */
public interface RegisteredRepository extends CrudRepository<RegisteredDO,Integer> {
//根据医生工号查询所有学生挂号信息并按照顺序升序排序
    @Query(value = "select * from registers where doctor_dno = :dno order by sequence asc", nativeQuery = true)
    List<RegisteredDO> findBystudents(@Param("dno")Integer dno);

    List<RegisteredDO> findAllByDoctor_DnoOrderBySequence(Integer dno);

    List<RegisteredDO> findAllByStudentSno(Integer sno);
}
