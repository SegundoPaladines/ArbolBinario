import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Icon;

public class App {

    public static void Adivinar(Icon icono1){
        Random r = new Random();
        int numero = r.nextInt(100);
        int contador=1;
        System.out.println(numero);

        int adv=-1;

        while(adv!=numero){

            
            try {
                
                try {
                    String valor=JOptionPane.showInputDialog(null,"Ingresar El Numero", "Intento# "+contador, JOptionPane.PLAIN_MESSAGE,icono1,null, null).toString();
                    adv = Integer.parseInt(valor);
                    if(adv>numero){

                        JOptionPane.showMessageDialog(null, "El munero Ingresado Es Mayor","Pista",JOptionPane.DEFAULT_OPTION, icono1);

                    }else if(adv<numero){

                        JOptionPane.showMessageDialog(null, "El munero Ingresado Es Menor","Pista",JOptionPane.DEFAULT_OPTION, icono1);

                    }else{
                        JOptionPane.showMessageDialog(null, "Adivinaste Adivinador En "+contador+" Intentos");
                    }
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null,"Precionó Cancelar -> Salir", "Error",1);
                    break;
                }

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null,"Entrada No Valida \n La Entrada Debe Ser Un Numero", "Error",1);
            }

            contador++;

        }
    }

    public static void AdivinarPC(Icon icono1, Icon adivinado){

        String[] respuestas = {
				
            "Es Mayor",
            "Es Menor",
            "Es Mi Numero"
        };

        String respuesta="";
        int inicio = 1;
        int termina= 100;
        int rango = 0;
        if((inicio+termina)%2==0){
            rango = (inicio+termina)/2;
        }else{
            rango = ((inicio+termina)+1)/2;
        }
        int numero=termina/2;

        try {

            while(!respuesta.equalsIgnoreCase("Es Mi Numero")){

                respuesta= (String) JOptionPane.showInputDialog(null,numero + " Es Mayor, Menor O Igual Que Su Numero", "Numero", JOptionPane.DEFAULT_OPTION, icono1, respuestas, respuestas[0]);

                if(respuesta.equalsIgnoreCase("Es Mayor")){

                        termina=numero-1;
                        rango=termina-inicio;

                }else if(respuesta.equalsIgnoreCase("Es Menor")){

                        inicio=numero+1;
                        rango=termina-inicio;
                }
                else{
                    JOptionPane.showMessageDialog(null, "El Numero es: "+numero,null ,JOptionPane.PLAIN_MESSAGE, adivinado);
                }

                numero=inicio+(rango/2);
                System.out.println("=========================================================================================");
                System.out.println("El numero es: " + numero +" inicio: "+inicio + " termina: " + termina);
                System.out.println("Rango: " + rango);
                System.out.println("=========================================================================================");
                if(rango<=0){

                    JOptionPane.showMessageDialog(null,"El Numero es: "+numero, null ,JOptionPane.PLAIN_MESSAGE, adivinado);
                        break;

                }
                rango=rango/2;
            }

    } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Precionó Cancelar -> Salir", "Error",1);

        }
    }

    public static void main(String[] args) throws Exception {

        String[] respuestas = {
				
            "Adivino Yo",
            "Adivina La Maquina",
        };

        String respuesta="";
        CargarIcono icono1 = new CargarIcono("icono.png",300,270);
        CargarIcono icono_final= new CargarIcono("fin.png",250,180);
        CargarIcono icono_adivinar= new CargarIcono("adivinar.jpg",490,320);
        
        while(respuesta!=null){
            try{

                respuesta= (String) JOptionPane.showInputDialog(null,"¿Quien Es El Adivino?", "Seleccionar Adivino", JOptionPane.DEFAULT_OPTION, icono1, respuestas, respuestas[0]);


                if(respuesta.equalsIgnoreCase("Adivino Yo")){

                    Adivinar(icono1);

                }
                if(respuesta.equalsIgnoreCase("Adivina La Maquina")){

                    AdivinarPC(icono1,icono_adivinar);

                }

            }catch(Exception e){

                JOptionPane.showMessageDialog(null, null, "Fin Programa", JOptionPane.PLAIN_MESSAGE, icono_final);

                break;

            }
        }

    }
} 