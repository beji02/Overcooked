package pizzashop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.IPaymentRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PizzaServiceMockito {
  @Mock
  IPaymentRepository repo;

  @InjectMocks
  PizzaService service;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void addPaymentTest() throws Exception {
    ArgumentMatcher<Payment> paymentMatcher = p ->
            p.getTableNumber() == 4 && p.getType() == PaymentType.CASH && p.getAmount() == 13.97;

    doNothing().when(repo).add(argThat(paymentMatcher));

    service.addPayment(4, PaymentType.CASH, 13.97);
    verify(repo, times(1)).add(argThat(paymentMatcher));
  }

  @Test
  void getPaymentsTest() {
    Payment p = new Payment(4, PaymentType.CASH, 13.97);
    when(repo.getAll()).thenReturn(Arrays.asList(p));

    assertEquals(service.getPayments(), Arrays.asList(p));
  }
}
