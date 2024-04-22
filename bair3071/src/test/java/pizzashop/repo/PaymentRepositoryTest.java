package pizzashop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.PaymentRepository;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PaymentRepositoryTest {
  @Spy
  PaymentRepository repo;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getPaymentTest() {
    assertEquals(repo.getPayment("4,CASH,13.97").getAmount(), new Payment(4, PaymentType.CASH, 13.97).getAmount());
    assertEquals(repo.getPayment("4,CASH,13.97").getTableNumber(), new Payment(4, PaymentType.CASH, 13.97).getTableNumber());
    assertEquals(repo.getPayment("4,CASH,13.97").getType(), new Payment(4, PaymentType.CASH, 13.97).getType());
  }

  @Test
  void readPaymentsTest(){
    when(repo.getPayment(anyString())).thenReturn(new Payment(4, PaymentType.CASH, 13.97));
    repo.readPayments();
    verify(repo, times(56)).getPayment(anyString());
  }
}
