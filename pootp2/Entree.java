// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class Entree extends Mets
{
    // constructeur par défaut
    Entree()
    {
    }

    // constructeur fesant l'appel de la superclasse
    Entree(int code, String nom, String description, double prix)
    {
        super(code, nom, description, prix);
    }

}
