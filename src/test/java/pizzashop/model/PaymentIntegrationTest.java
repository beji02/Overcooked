package pizzashop.model;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertTrue(service.getPayments().size() >= 0);
  }

  @Test
  void getTotalAmountTest(){
    assertTrue(service.getTotalAmount(PaymentType.CASH) >= 0);
  }
}
