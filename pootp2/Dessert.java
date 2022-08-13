// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class Dessert extends Mets
{
    private int calories;
    // constructeur par défaut
    Dessert()
    {
    }

    // constructeur fesant l'appel de la superclasse
    Dessert(int code, String nom, String description, double prix)
    {
        super(code, nom, description, prix);
    }

    // constructeur fesant l'appel de la superclasse et attribut supplémentaire
    Dessert(int code, String nom, String description, double prix, int calories)
    {
        super(code, nom, description, prix);
        this.calories = calories;
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

        switch(type)
        {
            case 1:
            {
                outString = super.formater(type) + ", "+ calories + " calories" ;
            }
            break;

            case 2:
            {
                outString =  super.formater(type) + "\t"+ calories + " calories" ;
            }
            break;

            default:
            break;
        }
        
        return outString;
    }

    /*
    Méthode toString()
    @param aucun
    @return outstring   Retourne une chaîne de caractères qui correspond à l’énumération 
                        des attributs de la classe parent de et de l’objet lui-meme, 
                        ainsi que ses valeurs respectives
    */
    @Override
    public String toString()
    {
        String outString =  super.toString() + ", " + calories + " calories";
        
        return outString;
    }   
}
