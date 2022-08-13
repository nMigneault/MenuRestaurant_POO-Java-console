// Natacha Migneault 966-2561 | TP2 | 19 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

public class MyUtil 
{
    /*
    La méthode afficherMenu() fait l'affichage des choix du menu principal
    @param aucun
    @return aucun
    */
    public static void afficherMenu()
    {
        afficherSeparateur();
        System.out.println("GESTION DES MENUS \n");   
        System.out.println("\t 0 - Terminer");
        System.out.println("\t 1 - Lister les menus");
        System.out.println("\t 2 - Lister les mets");
        System.out.println("\t 3 - Créer un nouveau menu");
        System.out.println("\t 4 - Créer un nouveau mets");
        System.out.println("\t 5 - Ajouter des mets à un menu");
        System.out.println("\t 6 - Statistiques");
        System.out.println(" ");
        entrezVotreChoix();
    }

    /*
    La méthode afficherSousMenuListerMenus() présente la liste des menus
    @param aucun
    @return aucun
    */
    public static void afficherSousMenuListerMenus()
    {
        afficherSeparateur();
        System.out.println("LISTER LES MENUS \n");   
        System.out.println("\t 1 - Tous les menus");
        System.out.println("\t 2 - Les déjeuners");
        System.out.println("\t 3 - Les dîners");
        System.out.println("\t 4 - Les soupers");
        System.out.println("\t 5 - Les menus en vigueur");
        System.out.println(" ");
        entrezVotreChoix();
    }

    /*
    La méthode affichersousMenuListerLesMets() présente la liste des mets
    @param aucun
    @return aucun
    */
    public static void affichersousMenuListerLesMets()
    {
        afficherSeparateur();
        System.out.println("LISTER LES METS \n");   
        System.out.println("\t 1 - Tous les mets");
        System.out.println("\t 2 - Les entrées");
        System.out.println("\t 3 - Les plats principaux");
        System.out.println("\t 4 - Les desserts");
        System.out.println(" ");
        entrezVotreChoix();
    }

    /*
    La méthode afficherMessageErreurChoix() affiche un message d'erreur 
    lorsque l'usager n'entre pas un choix valide.
    @param aucun
    @return aucun
    */
    public static void afficherMessageErreurChoix()
    {
        System.out.println("\n>>> Veuillez entrer un choix valide ! ");
    }

    /*
    La méthode afficherMessageErreurValeurNumerique() affiche un message d'erreur 
    lorsque l'usager n'entre pas une valeur numérique.
    @param aucun
    @return aucun
    */
    public static void afficherMessageErreurValeurNumerique()
    {
        System.out.println("\n>>> Veuillez entrer une valeur numérique valide ! ");
    }

    /*
    La méthode afficherMessageErreurOption() affiche un message d'erreur 
    lorsque l'usager ne choisi pas une valeur offerte.
    @param aucun
    @return aucun
    */
    public static void afficherMessageErreurOption()
    {
        System.out.println("\n>>> Veuillez choisir parmi les options offertes. ");
    }

    /*
    La méthode afficherMessageErreurInfo() affiche un message d'erreur 
    lorsque l'usager n'entre pas une information valide.
    @param aucun
    @return aucun
    */
    public static void afficherMessageErreurInfo()
    {
        System.out.println("\n>>> Veuillez entrer une information valide ! ");
    }

    /*
    La méthode afficherMessageCodeExistant() affiche un message d'erreur 
    lorsque l'usager entre un code déjà utilisé.
    @param aucun
    @return aucun
    */
    public static void afficherMessageCodeExistant()
    {
        System.out.println("\t>>> Merci d'entrer un code non utilisé. \n");
    }

    /*
    La méthode entrezVotreChoix() affiche un message pour demander à l'usager 
    d'entrer son choix.
    @param aucun
    @return aucun
    */
    public static void entrezVotreChoix()
    {
        System.out.print(" ------> Entrez votre choix : ");
    }
    
    /*
    La méthode afficherSeparateur() affiche un séparateur.
    @param aucun
    @return aucun
    */
    public static void afficherSeparateur()
    {
        System.out.print("\n ---------------------------------------------------------" + 
                                "\n\t >>> ");
    }
        
    /*
    La méthode estUnREntier vérifie si la chaîne de caractères reçue en paramètre
    correspond à un nombre entier. 
    Source (fait avant que M. Gravel ne donne son explication) https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java 
    @param str  chaine de caractères à vérifier
    @return boolean true si la chaîne correspond à un nombre entier
    */
    public static boolean estUnEntier(String str)
    { 
        boolean estUnEntier;
        try
        {  
            Integer.parseInt(str);  
            estUnEntier = true;
        }
        catch(NumberFormatException exeption)
        {  
            estUnEntier = false;  
        }  

        return estUnEntier;
    }

    /*
    La méthode estUnDouble vérifie si la chaîne de caractères reçue en paramètre
    correspond à un nombre réel.
    Source (fait avant que M. Gravel ne donne son explication) https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java 
    @param str   chaine de caractères à vérifier
    @return boolean true si la chaîne correspond à un nombre réel
     */
    public static boolean estUnDouble(String str)
    { 
        boolean estUnDouble;
        try
        {  
            Double.parseDouble(str);  
            estUnDouble = true;
        }
        catch(NumberFormatException exeption)
        {  
            estUnDouble = false;  
        }  

        return estUnDouble;
    }
}
