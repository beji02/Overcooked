package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pizzashop.model.PaymentType;
import pizzashop.repository.IPaymentRepository;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentIntegrationTest {

  IPaymentRepository repo;
  @Mock
  MenuRepository menuRepo;

  PizzaService service;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.initMocks(this);
    repo = new PaymentRepository();
    service = new PizzaService(menuRepo, repo);
  }

  @Test
  void getPaymentsTest() {
    assertEquals(service.getPayments().size(), 59);
  }

  @Test
  void getTotalAmountTest(){
    assertEquals(service.getTotalAmount(PaymentType.CASH), 430.87);
  }
}
