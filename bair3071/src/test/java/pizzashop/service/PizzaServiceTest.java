package pizzashop.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {
    private PizzaService pizzaService;
    private MenuRepository menuRepository = new MenuRepository();
    private PaymentRepository paymentRepository = new PaymentRepository();
    @BeforeEach
    void setUp() {
        pizzaService = new PizzaService(menuRepository, paymentRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @ValueSource(ints = {2})
    void addPayment_TC01_ECP(int candidate) {
        PaymentType type = PaymentType.CASH;
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();
        try {
            pizzaService.addPayment(candidate, type, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assert(paymentRepository.getAll().size() == totalPayments + 1);
        assertEquals(2 , paymentRepository.getAll().get(totalPayments).getTableNumber());
    }

    @RepeatedTest(10)
    void addPayment_TC03_ECP() {
        int table = 9;
        PaymentType type = PaymentType.valueOf("CARD");
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();

        Exception exception = assertThrows(Exception.class, () ->  pizzaService.addPayment(table, type, amount));
        assertEquals("Error - table number in invalid", exception.getMessage());
        assert(paymentRepository.getAll().size() == totalPayments);
    }

    @Test
    @Tag("bva")
    void addPayment_TC01_BVA() {
        int table = 0;
        PaymentType type = PaymentType.valueOf("CARD");
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();

        Exception exception = assertThrows(Exception.class, () -> pizzaService.addPayment(table, type, amount));
        assertEquals("Error - table number in invalid", exception.getMessage());
        assert(paymentRepository.getAll().size() == totalPayments);
    }

    @Test
    @Timeout(200000)
    void addPayment_TC04_BVA() {
        int table = 7;
        PaymentType type = PaymentType.valueOf("CARD");
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();

        try {
            pizzaService.addPayment(table, type, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assert(paymentRepository.getAll().size() == totalPayments + 1);
        assertEquals(7 , paymentRepository.getAll().get(totalPayments).getTableNumber());
    }

    @Test
    void addPayment_TC05_BVA() {
        int table = 8;
        PaymentType type = PaymentType.valueOf("CARD");
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();

        try {
            pizzaService.addPayment(table, type, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assert(paymentRepository.getAll().size() == totalPayments + 1);
        assertEquals(8, paymentRepository.getAll().get(totalPayments).getTableNumber());
    }

    @Test
    @Disabled
    void addPayment_disables() {
        int table = 8;
        PaymentType type = PaymentType.valueOf("CARD");
        double amount = 10;
        int totalPayments = paymentRepository.getAll().size();

        try {
            pizzaService.addPayment(table, type, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assert(paymentRepository.getAll().size() == totalPayments + 1);
        assertEquals(8, paymentRepository.getAll().get(totalPayments).getTableNumber());
    }
}