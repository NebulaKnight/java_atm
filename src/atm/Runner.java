package atm;

/**
 *
 * @author jorge
 */
public class Runner {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Atm atm = new Atm();
        Client client = new Client("Jorge Mauricio Ruiz Flores", "1235", new Double(1000));
        Integer attempts = 0;
        do{
            if(atm.login(client)){
                atm.run(client);
                break;
            }
            else{
                System.out.println("ERROR: PIN incorrecto");
                attempts++;
            }
        }while(attempts < 3);
    }
}
