package pizzashop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RepoIntegrationTest {

  @Spy
  PaymentRepository repo;

  @Mock
  MenuRepository menuRepo;

  @Spy
  Payment mockPayment;

  PizzaService service;
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    mockPayment.setType(PaymentType.CASH);
    mockPayment.setAmount(1);
    mockPayment.setTableNumber(1);
    service = new PizzaService(menuRepo, repo);

  }

  @Test
  void getPaymentsTest(){
    when(repo.getAll()).thenReturn(Arrays.asList(mockPayment));

    assertFalse(service.getPayments().isEmpty());
  }

  @Test
  void getTotalAmount(){
    when(repo.getAll()).thenReturn(Arrays.asList(mockPayment));
    when(mockPayment.getType()).thenReturn(PaymentType.CASH);

    assertEquals(service.getTotalAmount(PaymentType.CASH), 1);
  }
}
