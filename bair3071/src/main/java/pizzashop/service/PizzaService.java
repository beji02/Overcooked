package pizzashop.service;

import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.IPaymentRepository;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.List;

public class PizzaService {

    private MenuRepository menuRepo;
    private IPaymentRepository payRepo;

    public PizzaService(MenuRepository menuRepo, IPaymentRepository payRepo){
        this.menuRepo=menuRepo;
        this.payRepo=payRepo;
    }

    public List<MenuDataModel> getMenuData(){return menuRepo.getMenu();}

    public List<Payment> getPayments(){return payRepo.getAll(); }

    public void addPayment(int table, PaymentType type, double amount) throws Exception {
        Payment payment = new Payment(table, type, amount);
        if (0 >= table || table > 8)
        {
            throw new Exception("Error - table number in invalid");
        }
        payRepo.add(payment);
    }

    public double getTotalAmount(PaymentType type){
        double total=0.0f;
        List<Payment> paymentList=getPayments();
        if ((paymentList==null) ||(paymentList.size()==0)) return total;
        for (Payment p:paymentList){
            if (p.getType().equals(type))
                total+=p.getAmount();
        }
        return total;
    }

}