package lt.vu.interceptors;

import lt.vu.entities.CreditCard;
import lt.vu.entities.Game;
import lt.vu.usecases.Store;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.time.LocalDate;

@Interceptor
@ValidateCreditCard
public class CreditCardValidator implements Serializable{
    @AroundInvoke
    public Object validateCreditCard(InvocationContext context) throws Exception {
        Store store = (Store) context.getTarget();
        LocalDate today = LocalDate.now();
        int monthToday = today.getMonthValue();
        int yearToday = today.getYear();
        if((2000+store.getCreditCard().getExpiryYear()) > yearToday ||
            (2000+store.getCreditCard().getExpiryYear()) == yearToday &&
            store.getCreditCard().getExpiryMonth() >= monthToday)
        {
            return context.proceed();
        }
        else
        {
            return "addFunds?faces-redirect=true&userId=" + store.getLoggedUser().getId() + "&error=credit-card-expired";
        }
    }
}
