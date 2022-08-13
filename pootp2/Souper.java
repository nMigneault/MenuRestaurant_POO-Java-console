// Natacha Migneault 966-2561 | TP2 | 19 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class Souper extends Menu
{
    protected boolean finDeSemaine = false;

    // constructeurs par défaut
    Souper()
    {
    }

    // constructeurs fesant l'appel de la superclasse et attribut supplémentaire
    Souper(int code, String nom, String description, boolean actif)
    {
        super(code, nom, description, actif);
        this.finDeSemaine = false;
    }
    
    // constructeurs fesant l'appel de la superclasse et attribut supplémentaire
    Souper(int code, String nom, String description, boolean actif, boolean finDeSemaine)
    {
        super(code, nom, description, actif);
        this.finDeSemaine = finDeSemaine;
    }

    /*
    Méthode toString()
    @param aucun
    @return String  retourne une chaîne de caractères qui correspond à l’énumération 
                    des attributs de la superclasse de l’objet et de leur valeur respective 
                    ainsi que les attributs de la classe dérivée
    */
    @Override
    public String toString()
    {
        return super.toString() + ", " + finDeSemaine ;
    }
}
