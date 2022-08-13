// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class Dejeuner extends Menu
{
    // constructeur par défaut
    Dejeuner()
    {
    }

    // constructeur fesant l'appel de la superclasse
    Dejeuner(int code, String nom, String description, boolean actif)
    {
        super(code, nom, description, actif);
    }    
}
