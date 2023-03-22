package edu.hami.restfulservices.foodsystem.repository.payment;

import edu.hami.restfulservices.foodsystem.model.payment.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}
