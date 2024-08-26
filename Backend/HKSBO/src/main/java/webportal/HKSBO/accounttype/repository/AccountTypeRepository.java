package webportal.HKSBO.accounttype.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Sctradingacc;

@Repository
public interface AccountTypeRepository extends JpaRepository<Sctradingacc, String> {
  @Query(value = "SELECT" +
      " SUM(CASE WHEN INVESTORTYPEID = 'M' THEN 1 ELSE 0 END) AS Margin, " +
      " SUM(CASE WHEN INVESTORTYPEID = 'X' THEN 1 ELSE 0 END) AS Cash ," +
      " SUM(CASE WHEN INVESTORTYPEID = 'C' THEN 1 ELSE 0 END) AS DVP " +
      " FROM SCTRADINGACC", nativeQuery = true)
  List<Object[]> getAccountType();
}