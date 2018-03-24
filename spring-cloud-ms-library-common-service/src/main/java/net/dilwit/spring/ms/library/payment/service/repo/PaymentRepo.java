package net.dilwit.spring.ms.library.payment.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.dilwit.spring.ms.library.payment.domain.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
