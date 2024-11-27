
package Model;
import java.util.ArrayList; 


public class Alimentaire extends Service {
   
    private String typeRepas;
    private String heureRepas;
    private final ArrayList<String> repasList;


    public Alimentaire(int idService, String nomService, int capacite, double cout) {
        super(idService, nomService, capacite, cout);
        typeRepas = "";
        heureRepas = "";
        repasList = new ArrayList<>();
    }

    public String getTypeRepas() {
        return typeRepas;
    }

    public void setTypeRepas(String typeRepas) {
        this.typeRepas = typeRepas;
    }

    public String getHeureRepas() {
        return heureRepas;
    }

    public void setHeureRepas(String heureRepas) {
        this.heureRepas = heureRepas;
    }

    public void ajouterRepas(String repas) {
        repasList.add(repas);
    }

    public void afficherRepasParType(String type) {
        System.out.println("Repas de type " + type + " :");
        for (String repas : repasList) {
            if (type.equalsIgnoreCase(typeRepas)) {
        System.out.println(repas);
            }
        }
    }  
}
