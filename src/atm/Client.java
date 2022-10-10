package atm;

/**
 * Client class to control user actions
 * @author jorge
 */
public class Client {
    private String name;
    private String pin;
    private Account account;

    public Client(String name, String pin){
        this.name = name;
        this.pin = pin;
        this.account = new Account(new Double(0));
    }
    
    public Client(String name, String pin, Double amount){
        this.name = name;
        this.pin = pin;
        this.account = new Account(amount);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", pin=" + pin + ", account=" + account + '}';
    }
}
