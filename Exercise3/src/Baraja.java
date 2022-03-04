import java.nio.charset.StandardCharsets;
import java.util.*;

public class Baraja {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<Carta> barajaList = new ArrayList<>();
    ArrayList<Carta> barajaAux = new ArrayList<>();

    public void agregarCarta(){
        Carta carta = null;

        for (int i = 0; i < 12; i++) {
            if(i >= 0 && i < 7 || i > 8 && i < 12){
                for (PaloEnum p : PaloEnum.values()) {
                    carta = new Carta((i+1), p);
                    barajaList.add(carta);
                }
            }
        }
    }

    public void crearBaraja(){
        barajaList.clear();
        barajaAux.clear();

        agregarCarta();
        System.out.println("Se creo la baraja");
    }

    public void barajar(){
        if(!barajaList.isEmpty()){
            Collections.shuffle(barajaList);
            System.out.println("Se mezclaron las cartas");
        }else {
            System.out.println("Ya no hay cartas");
        }
    }

    public void siguienteCarta(){
        if(!barajaList.isEmpty()){
            Iterator<Carta> it = barajaList.iterator();
            Carta c = it.next();
            System.out.println("Carta sacada: " + c);
            barajaAux.add(c);
            it.remove();
        }else{
            System.out.println("Ya no hay mas cartas");
        }
    }

    public void cartasDisponibles(){
        if(!barajaList.isEmpty()){
            System.out.printf("CARTAS DISPONIBLES: %d\n",barajaList.size());
        }else{
            System.out.println("No hay mas cartas disponibles");
        }
    }

    public void darCartas(){
        boolean b;

        System.out.println("Ingrese el numero de cartas: ");
        int n = input.nextInt();

        b = repartirCartas(n);

        if(!b){
            System.out.println("No hay cartas para la cantidad solicitada");
        }
    }

    public boolean repartirCartas(int c){

        if((!barajaList.isEmpty()) && (c <= barajaList.size())){
            for(int i = 0; i < c; i++){
                Iterator<Carta> it = barajaList.iterator();
                Carta ca = it.next();
                System.out.println(ca);
                barajaAux.add(ca);
                it.remove();
            }
            return true;
        }
        return false;
    }

    public void cartasMonton(){
        if(!barajaAux.isEmpty()){
            for (Carta bA : barajaAux) {
                System.out.println(bA);
            }
        }else{
            System.out.println("No ha salido ninguna carta");
        }
    }

    public void mostrarBaraja(){
        if(!barajaList.isEmpty()){
            for (Carta c : barajaList) {
                System.out.println(c);
            }
        }else{
            System.out.println("No hay cartas en la baraja");
        }
    }

    public void menu(){
        String op;

        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Crear baraja");
            System.out.println("2- Mezclar Baraja");
            System.out.println("3- Sacar carta");
            System.out.println("4- Mostrar cartas disponibles");
            System.out.println("5- Pedir cartas");
            System.out.println("6- Mostrar cartas salientes");
            System.out.println("7- Mostrar baraja");
            System.out.println("8- Exit");
            System.out.println("-------------------");
            System.out.print("\nOpcion: "); op = input.next();

            switch (op) {
                case "1":
                    crearBaraja();
                    break;
                case "2":
                    barajar();
                    break;
                case "3":
                    siguienteCarta();
                    break;
                case "4":
                    cartasDisponibles();
                    break;
                case "5":
                    darCartas();
                    break;
                case "6":
                    cartasMonton();
                    break;
                case "7":
                    mostrarBaraja();
                    break;
                case "8":
                    System.out.println("Cerrando menu. Bye!");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }while(!op.equalsIgnoreCase("8"));
    }
}
