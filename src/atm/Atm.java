package atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Initial class to run atm example
 * @author Jorge Ruiz
 */
public class Atm {
    private Integer selectedOption;
    private final BufferedReader reader;
    
    public Atm(){
        this.selectedOption = 0;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public Boolean login(Client client){
        Boolean validation = false;
        try{
            System.out.println("Favor de ingresar su pin:");
            String pin = reader.readLine();
            if(client.getPin().equals(pin)){
                validation = true;
            }
        }
        catch(IOException ioe){
            System.out.println("ERROR: Ha sucedido un error, favor de repetir");
        }
        return validation;
    }
    
    private Integer showMainMenu(Client client){
        Integer option = 0;
        try{
            System.out.println(
            "==================================\n" +
            "Bienvenido: \n" + 
            client.getName() + "\n" +
            "===============Menú===============\n" +
            "1. Consultar saldo\n" +
            "2. Retirar efectivo\n" +
            "3. Historico de movimientos\n" +
            "4. Salir\n" +
            "==================================\n"
            );
            option = Integer.parseInt(reader.readLine());
        }
        catch(NumberFormatException nfe){
            System.out.println("ERROR: Favor de seleccionar una opción valida");
        }
        catch(IOException ioe){
            System.out.println("ERROR: Ha sucedido un error, favor de repetir");
        }
        return option;
    }
    
    private void balanceOption(Client client){
        try{
            do{
                System.out.println("Su saldo es: " + client.getAccount().getBalance());
                System.out.println("Desea regresar al menú principal? S/N(Otro)");
                String option = reader.readLine();
                if(option.equalsIgnoreCase("S")){
                    break;
                }
            }while(true);
        }
        catch(IOException ioe){
            System.out.println("ERROR: No se ha podido entender su selección, favor de repetir");
        }
    }
    
    private void withdrawOption(Client client){
        try{
            do{
                System.out.println("Su saldo actual es: " + client.getAccount().getBalance());
                System.out.println("Proporcionar el monto: ");
                Double amount = Double.parseDouble(reader.readLine());
                client.getAccount().withdraw(amount);
                System.out.println("Desea realizar otro retiro? S/N(Otro)");
                String option = reader.readLine();
                if(!option.equalsIgnoreCase("S")){
                    break;
                }
            }while(true);
        }
        catch(NumberFormatException nfe){
            System.out.println("ERROR: El monto proporcionado no es valido");
        }
        catch(IOException ioe){
            System.out.println("ERROR: No se ha podido entender su selección, favor de repetir");
        }
    }
    
    private void movementsOption(Client client){
        try{
            do{
                client.getAccount().showMovements();
                System.out.println("Desea regresar al menú principal? S/N(Otro)");
                String option = reader.readLine();
                if(option.equalsIgnoreCase("S")){
                    break;
                }
            }while(true);
        }
        catch(IOException ioe){
            System.out.println("ERROR: No se ha podido entender su selección, favor de repetir");
        }
    }
    
    public void run(Client client){
        do{
            selectedOption = showMainMenu(client);
            switch(selectedOption){
                case 1:
                    balanceOption(client);
                    break;
                case 2:
                    withdrawOption(client);
                    break;
                case 3:
                    movementsOption(client);
                    break;
                case 4:
                    System.out.println("Muchas gracias, vuelva pronto");
                    break;
                default:
                    System.out.println("ERROR: La opción elegida no existe");
            }
        }while(selectedOption != 4);
    }
}
