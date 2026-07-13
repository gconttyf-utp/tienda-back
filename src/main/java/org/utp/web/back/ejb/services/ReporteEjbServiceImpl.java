package org.utp.web.back.ejb.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.utp.web.back.apirest.models.dto.ReporteDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ReporteEjbServiceImpl implements ReporteEjbService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ReporteDTO> reporteDiario() {
        String sql = "SELECT DAY(p.fecha_pago) as periodo, SUM(p.total) as total " +
                     "FROM pedidos p " +
                     "WHERE YEAR(p.fecha_pago) = YEAR(CURRENT_DATE) AND MONTH(p.fecha_pago) = MONTH(CURRENT_DATE) " +
                     "GROUP BY DAY(p.fecha_pago) " +
                     "ORDER BY periodo";
        return executeReportQuery(sql);
    }

    @Override
    public List<ReporteDTO> reporteSemanal() {
        String sql = "SELECT WEEK(p.fecha_pago, 1) as periodo, SUM(p.total) as total " +
                     "FROM pedidos p " +
                     "WHERE YEAR(p.fecha_pago) = YEAR(CURRENT_DATE) AND MONTH(p.fecha_pago) = MONTH(CURRENT_DATE) " +
                     "GROUP BY WEEK(p.fecha_pago, 1) " +
                     "ORDER BY periodo";
        return executeReportQuery(sql);
    }

    @Override
    public List<ReporteDTO> reporteMensual() {
        String sql = "SELECT MONTHNAME(p.fecha_pago) as periodo, SUM(p.total) as total " +
                     "FROM pedidos p " +
                     "WHERE YEAR(p.fecha_pago) = YEAR(CURRENT_DATE) " +
                     "GROUP BY MONTHNAME(p.fecha_pago), MONTH(p.fecha_pago) " +
                     "ORDER BY MONTH(p.fecha_pago)";
        return executeReportQuery(sql);
    }

    private List<ReporteDTO> executeReportQuery(String sql) {
        Query query = em.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        return results.stream()
                .map(result -> new ReporteDTO(
                        String.valueOf(result[0]),
                        (BigDecimal) result[1]
                ))
                .collect(Collectors.toList());
    }
}
