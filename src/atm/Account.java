package atm;

import java.util.List;
import java.util.ArrayList;

/**
 * Account class
 * @author jorge
 */
public class Account {
    private Double balance;
    private List<AccountMovement> movements;

    public Account(){}
    
    public Account(Double balance){
        this.balance = balance;
        this.movements = new ArrayList<>();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<AccountMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<AccountMovement> movements) {
        this.movements = movements;
    }
    
    public Boolean withdraw(Double amount){
        Boolean operation = false;
        if(amount > 0){
            if(this.balance >= amount){
                AccountMovement movement = new AccountMovement(this.balance, amount);
                movements.add(movement);
                this.balance -= amount;
                operation = true;
                System.out.println("Se ha retirado el monto de: " + amount + "\n");
            }
            else{
                System.out.println("ERROR: Saldo insuficiente");
            }
        }
        else{
            System.out.println("El monto proporcionado no es valido");
        }
        return operation;
    }

    public void showMovements(){
        if(!movements.isEmpty()){
            System.out.println("============Movimientos===========\n");
            for(AccountMovement movement : movements){
                movement.printWithdraw();
            }
        }
        else{
            System.out.println("No se encontraron movimientos");
        }
    }
    
    @Override
    public String toString() {
        return "Account{" + "balance=" + balance + ", movements=" + movements + '}';
    }
}
