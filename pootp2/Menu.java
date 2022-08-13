// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

import java.util.ArrayList;

public class Menu
{
    private int code;
    private String nom;
    private String description;
    private boolean actif = true; // indique si le menu est toujours en vigueur
    private ArrayList<Mets> listeMets;   

    // constructeur de la classe parent
    Menu()
    {
        listeMets = new ArrayList<>(); 
    }

    // constructeurs de la classe parent fesant appel au constructeur par défaut 
    // et aux attributs de la classe
    Menu(int code, String nom, String description, boolean actif)
    {
        this();
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.actif = actif;
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

    public boolean getActif()
    {
        return actif;
    }
    public void setActif(boolean actif)
    {
        this.actif = actif;
    } 

    /*
    La méthode ajouterMets() permet d'ajouter un mets à listeMets
    @param mets     liste dans laquelle s'effectue l'ajout
    @return aucun
    */
    public void ajouterMets(Mets mets)
    {
        listeMets.add(mets);
    }
    
    /*
    La méthode presenter() affiche le menu et liste des mets qui le composent
    @param format   format de l'affichage demandé par l'utilisateur
    @return aucun
    */
    public void presenter(int format)
    {
        String entrees = "";
        String platsPrincipaux = "";
        String desserts = "";
        
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            if ( mets instanceof Entree )
            {
                entrees += mets.formater(format) + "\n";
            }
            else if ( mets instanceof PlatPrincipal )
            {
                platsPrincipaux += mets.formater(format) + "\n";
            }
            else if ( mets instanceof Dessert )
            {
                desserts += mets.formater(format) + "\n";
            }
        }

        System.out.println("==============================================");
        System.out.println("\t" + nom + "  (" + code + ")");
        System.out.println("==============================================");

        if ( !entrees.isEmpty() )
        {
            System.out.println("\tENTREES");
            System.out.println("------------------------");
            System.out.println(entrees);
        }

        if ( !platsPrincipaux.isEmpty() )
        {
            System.out.println("\tPLATS PRINCIPAUX");
            System.out.println("------------------------");
            System.out.println(platsPrincipaux);
        }

        if ( !desserts.isEmpty() )
        {
            System.out.println("\tDESSERTS");
            System.out.println("------------------------");
            System.out.println(desserts);
        }
    }

    /*
    La méthode afficherMets() affiche la liste des mets du menu
    @param aucun
    @return aucun
    */
    public void afficherMets()
    {
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            System.out.println(mets.toString());
        }
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
        return code + ", " + nom + ", " + description + ", " + actif ;
    }

}
