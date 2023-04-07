package com.buenoezandro.payrollapi.resources;

import com.buenoezandro.payrollapi.domain.Payroll;
import com.buenoezandro.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RequestMapping(value = "/api/payments")
@RestController
public class PayrollResource {
    private final PayrollService payrollService;

    @GetMapping(value = "/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {
        return ok().body(this.payrollService.getPayment(workerId, payment));
    }
}