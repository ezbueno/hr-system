package com.buenoezandro.payrollapi.services;

import com.buenoezandro.payrollapi.domain.Payroll;
import com.buenoezandro.payrollapi.feignClients.UserFeign;
import com.buenoezandro.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {
    private final Environment environment;
    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll) {
        log.info("PAYROLL SERVICE ::: Get request on " + this.environment.getProperty("local.server.port") + " port");
        try {
            var user = this.userFeign.findById(workerId).getBody();
            if (nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
