package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreditCard {

    private String cardNumber;
    private String name;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;

}
