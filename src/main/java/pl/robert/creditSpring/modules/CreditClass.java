package pl.robert.creditSpring.modules;

import lombok.Data;

@Data
public class CreditClass {
    private int income;
    private int expenses;
    private int loanAmount;
    private int howLong;
}
