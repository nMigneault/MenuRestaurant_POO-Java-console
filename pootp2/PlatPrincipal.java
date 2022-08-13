// Natacha Migneault 966-2561 | TP2 | 19 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class PlatPrincipal extends Mets
{
    protected boolean demiPortion = false;

    // constructeur par défaut
    PlatPrincipal()
    {
    }

    // constructeurs fesant l'appel de la superclasse et attribut supplémentaire
    PlatPrincipal(int code, String nom, String description, double prix)
    {
        super(code, nom, description, prix);
        this.demiPortion = false;
    }

    // constructeurs fesant l'appel de la superclasse et attribut supplémentaire
    PlatPrincipal(int code, String nom, String description, double prix, boolean demiPortion)
    {
        super(code, nom, description, prix);
        this.demiPortion = demiPortion;
    }

    /*
    La méthode formater() prend les attributs et les affiches selon le formatage demandé
    @param type         type d'affichage demandé
    @return outstring   retourne une chaîne de caractères qui correspond à l’énumération 
                        des attributs de l’objet et de leur valeur respective selon le type
    */
    @Override
    public String formater(int type)
    {
        String outString = "";
        String demiPortionString = "";

        switch(type)
        {
            case 1:
            {
                demiPortionString = getDemiPortion(demiPortion, demiPortionString);
                outString = super.formater(type) + ", " + demiPortionString ;
            }
            break;

            case 2:
            {
                demiPortionString = getDemiPortion(demiPortion, demiPortionString);
                outString = super.formater(type) + "\t" + demiPortionString ;
            }
            break;

            default:
            break;
        }
        
        return outString;
    }

    /*
    Méthode getDemiPortion()
    @param demiPortion          boolean démontre si le plat est offert en demi-portion
    @param demiPortionString    String 
    @return demiPortionString   retourne une chaîne de caractères qui correspond à la valeur du boolean
    */
    public static String getDemiPortion(boolean demiPortion, String demiPortionString)
    {
        if (demiPortion == false )
        {
            demiPortionString = "Non offert en demi-portion";
        }
        if (demiPortion == true )
        {
            demiPortionString = "Offert en demi-portion";

        }
        
        return demiPortionString;
    }


}
