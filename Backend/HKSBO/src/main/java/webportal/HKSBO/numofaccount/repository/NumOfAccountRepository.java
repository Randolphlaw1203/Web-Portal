package webportal.HKSBO.numofaccount.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webportal.HKSBO.entity.Sctradingacc;

@Repository
public interface NumOfAccountRepository extends JpaRepository<Sctradingacc, String> {
  @Query(value = "WITH ALL_MONTHS (MONTH_NUM, MONTH_NAME) AS (" +
      " VALUES " +
      " ('01', 'January')," +
      " ('02', 'February')," +
      " ('03', 'March')," +
      " ('04', 'April'), " +
      " ('05', 'May')," +
      " ('06', 'June')," +
      " ('07', 'July')," +
      " ('08', 'August')," +
      " ('09', 'September')," +
      " ('10', 'October')," +
      " ('11', 'November')," +
      " ('12', 'December')" +
      " )" +
      " SELECT AM.MONTH_NAME AS MONTH," +
      " COALESCE(COUNT(SA.ACOPENDATE), 0) AS NUMOFACCOUNTS" +
      " FROM ALL_MONTHS AM" +
      " LEFT JOIN SCTRADINGACC SA" +
      " ON AM.MONTH_NUM = TO_CHAR(SA.ACOPENDATE, 'MM')" +
      " AND TO_CHAR(SA.ACOPENDATE, 'YYYY-MM') >= '2024-01'" +
      " GROUP BY AM.MONTH_NUM, AM.MONTH_NAME" +
      " ORDER BY AM.MONTH_NUM", nativeQuery = true)
  List<Object[]> getNumOfAccount();
}