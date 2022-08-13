// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class Mets
{
    private int code;
    private String nom;
    private String description;
    private double prix;

    // constructeurs par défaut de la classe parent
    Mets()
    {
    }

    // constructeurs de la classe parent fesant appel au constructeur par défaut 
    // et aux attributs de la classe
    Mets(int code, String nom, String description, double prix)
    {
        this();
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    // accesseurs et mutateurs ( getters / setters )
    public int getCode()
    {
        return code;
    }
    public void setCode(int code)
    {
        this.code = code;
    } 
    
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    } 

    public double getPrix()
    {
        return prix;
    }
    public void setPrix(double prix)
    {
        this.prix = prix;
    }

    /*
    La méthode formater() prend les attributs et les affiches selon le formatage demandé
    @param type         type d'affichage demandé
    @return outstring   retourne une chaîne de caractères qui correspondant aux informations du mets
    */
    public String formater(int type)
    {
        String outString = "";

        switch(type)
        {
            case 1:
            {
                outString = code + ", " + 
                            nom + ", " + 
                            String.format("%.2f",prix) + " $" + ", " + 
                            description ;
            }
            break;

            case 2:
            {
                outString = " --> " + code + "\n" +
                            "\t" + nom + 
                            "\t\t" + String.format("%.2f",prix) + " $" + "\n" +
                            "\t" + description + "\n" ;
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
    @return String  retourne une chaîne de caractères qui correspond à l’énumération 
                    des attributs de l’objet et de leur valeur respective 
    */
    @Override
    public String toString()
    {
        String outString =  code + ", " + 
                            nom + ", " + 
                            String.format("%.2f",prix) + " $" + ", " + 
                            description ;

        return outString;
    }
}
