package atm;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Account movement class
 * @author jorge
 */
public class AccountMovement {
    public Double balance;
    public Double withdraw;
    public Date date;
    public SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public AccountMovement(){}
    
    public AccountMovement(Double balance, Double withdraw){
        this.balance = balance;
        this.withdraw = withdraw;
        this.date = new Date();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Double withdraw) {
        this.withdraw = withdraw;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void printWithdraw(){
        String dateFormated = formatter.format(this.date);
        String message = String.format(
            "Saldo: %f \t|\t Retiro: %f \t|\t Fecha: %s",
            this.balance,
            this.withdraw,
            dateFormated
        );
        System.out.println(message);
    }

    @Override
    public String toString() {
        return "AccountMovement{" + "balance=" + balance + ", withdraw=" + withdraw + ", date=" + date + '}';
    }
}
