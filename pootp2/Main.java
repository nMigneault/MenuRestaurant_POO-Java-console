// Natacha Migneault 966-2561 | TP2 | 18 janvier 2022
// 420-935-RO | GR802 | Concepts de la programmation orientée objet
package pootp2;

import java.util.Scanner;
import java.util.ArrayList;
import static pootp2.Utils.*;

public class Main
{
    static Scanner clavier = new Scanner(System.in);
    
    /*
     * Dans un contexte de la restauration, ce programme permet de composer 
     * différents menus à partir d’une liste de mets, à laquelle on peut 
     * également ajouter de nouveaux plats.
     */
    public static void main(String[] args)
    {
        String input;
        int choix;
        boolean valide = false;

        ArrayList<Menu> listeMenu = new ArrayList<>();
        ArrayList<Mets> listeMets = new ArrayList<>();
        listeMenu = creerMenus();
        listeMets = creerMets();
        affecterMetsAuxMenus(listeMenu,listeMets);

        while (!valide)
        {
            MyUtil.afficherMenu();

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurChoix();
            }
            else if ( !MyUtil.estUnEntier(input) )  // same Utils.estUnEntier()
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else 
            {
                choix = Integer.parseInt(input);

                switch(choix)
                {
                    case 0:
                        System.out.println("\n Au revoir ! \n");
                        valide = true;
                        break;
                        
                    case 1:                    
                        sousMenuListerMenus(listeMenu); // Lister les menus
                        break;
                        
                    case 2:
                        sousMenuListerMets(listeMets); // Lister les mets
                        break;
                        
                    case 3:
                        CreerNouveauMenu(listeMenu);
                        break;
                        
                    case 4:
                        creerNouveauMet(listeMets);
                        break;
                        
                    case 5:
                        AjouterMetsAMenu(listeMenu, listeMets);
                        break;
                    
                    case 6:
                        afficherStatistiques(listeMenu, listeMets);
                        break;
                    // vérifie que l'usager a entré une option du switch case.
                    default:
                    MyUtil.afficherMessageErreurChoix();
                }
            }
        }
        clavier.close();
    }
    
    /*
    La méthode sousMenuListerMenus() présente le sous-menu "Lister les menus"
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @return aucun
    */
    public static void sousMenuListerMenus(ArrayList<Menu> listeMenu)
    {
        String input;
        int choix;
        int format = -1;
        boolean valide = false;
        
        while (!valide)
        {
            MyUtil.afficherSousMenuListerMenus();
            
            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurChoix();
            }
            else if ( !MyUtil.estUnEntier(input) )  // same Utils.estUnEntier()
            {
                MyUtil.afficherMessageErreurChoix();
            }
            else 
            {
                choix = Integer.parseInt(input);                
            
                switch(choix)
                {
                    case 1:
                        format = choisirFormatAffichage();
                        afficherTousLesMenus(listeMenu, format);
                        valide = true;
                        break;

                    case 2:
                        format = choisirFormatAffichage();
                        afficherDejeuners(listeMenu, format);
                        valide = true;
                        break;

                    case 3:
                        format = choisirFormatAffichage();
                        afficherDiners(listeMenu, format);
                        valide = true;
                        break;

                    case 4:
                        format = choisirFormatAffichage();
                        afficherSoupers(listeMenu, format);
                        valide = true;
                        break;

                    case 5:
                        format = choisirFormatAffichage();
                        afficherMenusEnVigueur(listeMenu, format);
                        valide = true;
                        break;

                    // vérifie que l'usager a entré une option du switch case.
                    default:
                        MyUtil.afficherMessageErreurChoix();
                        break;
                }
            }
        }
    }
    
    /*
    La méthode sousMenuListerMets() présente le sous-menu "Lister les mets"
    @param listeMets   liste pour laquelle s'effectue l'affichage
    @return aucun
    */
    public static void sousMenuListerMets(ArrayList<Mets> listeMets)
    {
        String input;
        int choix;
        boolean valide = false;
        int format;

        while (!valide)
        {
            MyUtil.affichersousMenuListerLesMets(); // LISTER LES METS
           
            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurChoix();
            }
            else if ( !MyUtil.estUnEntier(input) )  // same as Utils.estUnEntier()
            {
                MyUtil.afficherMessageErreurChoix();
            }
            else 
            {
                choix = Integer.parseInt(input);                
            
                switch(choix)
                {
                    case 1:
                        format = choisirFormatAffichage();
                        afficherTousLesMets(listeMets, format);
                        valide = true;
                        break;

                    case 2:
                        format = choisirFormatAffichage();
                        afficherEntrees(listeMets, format);
                        valide = true;
                        break;

                    case 3:
                        format = choisirFormatAffichage();
                        afficherPlatsPrincipaux(listeMets, format);
                        valide = true;
                        break;

                    case 4:
                        format = choisirFormatAffichage();
                        afficherDesserts(listeMets, format);
                        valide = true;
                        break;

                    // vérifie que l'usager a entré une option du switch case.
                    default:
                        MyUtil.afficherMessageErreurChoix();
                        break;
                }
            }
        }
    }

    /*
    La méthode choisirFormatAffichage() permet à l'usager de selectionner le format d'affichage
    @param aucun
    @return format  retourne le format sélectionné
    */
    public static int choisirFormatAffichage()
    {
        String input;
        int format = -1;
        boolean valide = false;

        while (!valide)
        {
            MyUtil.afficherSeparateur();
            System.out.println("Quel format d'affichage désirez-vous ? \n");   
            System.out.println("\t 1 - Liste des informations");
            System.out.println("\t 2 - Affichage de style « Menu » \n");
            MyUtil.entrezVotreChoix();

            if (!clavier.hasNextInt()) 
            {
                clavier.nextLine();
                MyUtil.afficherMessageErreurChoix();
            }
            else 
            {
                input = clavier.nextLine();
                format = Integer.parseInt(input);
                if ( format == 1 || format == 2 )
                {
                    valide = true;
                }
                else
                {
                    MyUtil.afficherMessageErreurChoix();
                }           
            }
        }
        
        return format;
    }

    /*
    La méthode afficherTousLesMenus() affiche la liste de tous les menus
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherTousLesMenus(ArrayList<Menu> listeMenu, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("TOUS LES MENUS");
        
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            menu.presenter(format);
        }
        
    }

    /*
    La méthode afficherDejeuners() affiche la liste des déjeuners
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherDejeuners(ArrayList<Menu> listeMenu, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("DÉJEUNERS");
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            if ( menu instanceof Dejeuner )
            {
                menu.presenter(format);
            }
        }
    }

    /*
    La méthode afficherDiners() affiche la liste des dîners
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherDiners(ArrayList<Menu> listeMenu, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("DÎNERS");
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            if ( menu instanceof Diner )
            {
                menu.presenter(format);
            }
        }
    }
    
    /*
    La méthode afficherSoupers() affiche la liste des soupers
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherSoupers(ArrayList<Menu> listeMenu, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("SOUPERS");
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            if ( menu instanceof Souper )
            {
                menu.presenter(format);
            }
        }
    }

    /*
    La méthode afficherMenusEnVigueur() affiche la liste des menus actuellement en vigueurs, 
    donc ceux dont le boolean "actif" est true
    @param listeMenu   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherMenusEnVigueur(ArrayList<Menu> listeMenu, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("MENUS EN VIGUEUR");
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            if ( menu.getActif() )
            {
                menu.presenter(format);
            }
        }
    }

    /*
    La méthode afficherTousLesMets() affiche la liste de tous les mets
    @param listeMets   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherTousLesMets(ArrayList<Mets> listeMets, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("TOUS LES METS");
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            System.out.println(mets.formater(format) + "\n");
        }
    }

    /*
    La méthode afficherEntrees() affiche la liste des entrées
    @param listeMets   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherEntrees(ArrayList<Mets> listeMets, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("ENTRÉES");
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            if ( mets instanceof Entree )
            {
                System.out.println(mets.formater(format) + "\n");
            }
        }
    }

    /*
    La méthode afficherPlatsPrincipaux() affiche la liste des plats principaux
    @param listeMets   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherPlatsPrincipaux(ArrayList<Mets> listeMets, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("PLATS PRINCIPAUX");
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            if ( mets instanceof PlatPrincipal )
            {
                System.out.println(mets.formater(format) + "\n");
            }
        }
    }

    /*
    La méthode afficherDesserts() affiche la liste des desserts
    @param listeMets   liste pour laquelle s'effectue l'affichage
    @param format      format d'affichage choisi
    @return aucun
    */
    public static void afficherDesserts(ArrayList<Mets> listeMets, int format)
    {
        MyUtil.afficherSeparateur();
        System.out.println("DESSERTS");
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            if ( mets instanceof Dessert )
            {
                System.out.println(mets.formater(format) + "\n");
            }
        }
    }

    /*
    La méthode CreerNouveauMenu() permet à l'usager de créer un nouveau menu
    et les ajoute à la liste selon les spécifications demandés
    @param listeMenu   liste dans laquelle l'usager peut créer un nouveau menu
    @return aucun
    */
    public static void CreerNouveauMenu(ArrayList<Menu> listeMenu)
    {
        int code;
        String nom;
        String description;
        boolean actif = false;
        int type;

        MyUtil.afficherSeparateur();
        System.out.println("CRÉER UN NOUVEAU MENU");
        System.out.println("\t >>> Veuillez saisir les informations du menu : \n"); 
        
        code = saisirCodeMenu(listeMenu);
        nom = saisirNomMenu();
        description = saisirDescriptionMenu();
        actif = saisirStatutMenu();
        type = saisirTypeMenu();

        // ajouter les saisis de menu a la liste des menus
        switch(type)
        {                    
            case 1:                    
                listeMenu.add(new Dejeuner(code, nom, description, actif));
                break;
                
            case 2:
                listeMenu.add(new Diner(code, nom, description, actif));
                break;
                
            case 3:
                listeMenu.add(new Souper(code, nom, description, actif));
                break;
                
            default:
        }
        MyUtil.afficherSeparateur();
        System.out.println("Merci d'avoir créé ce nouveau menu :\n" +
                                listeMenu.get(listeMenu.size()-1).toString());
    }        
    
    /*
    La méthode saisirCodeMenu() demande à l'usager de saisir un code. 
    Recherche dans une liste de menu un élément dont le code correspond 
    à celui saisi au clavier. S'il y est, un message d'erreur s'afffiche. 
    Sinon, il retourne le code.
    @param listeMenu    liste dans laquelle s'effectue la recherche
    @return code        code saisi au clavier
    */
    public static int saisirCodeMenu(ArrayList<Menu> listeMenu)
    {
        String input;
        int code = 0;
        boolean valide = false;

        while (!valide)
        {
            System.out.print("--> Code du menu : ");

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else if ( !MyUtil.estUnEntier(input) )  // same Utils.estUnEntier()
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else 
            {
                code = Integer.parseInt(input);
                int idx = 0;
                if (listeMenu.get(idx).getCode() == code)
                {
                    MyUtil.afficherMessageCodeExistant();
                }
                else
                {
                    valide = true;
                }           

            }
        }
        
        return code;
    }
    
    /*
    La méthode getStringFromUser() fait une lecture au clavier de la chaine 
    de caractère saisi par l'utilisateurE et le retourne dans un String. 
    Affiche un message d'erreur si la saisi est invalide
    @param aucun
    @return input   La chaine de caractère saisi par l'utilisateurE
    */
    public static String getStringFromUser()
    {
        String input = "";
        boolean valide = false;

        while (!valide)
        {
            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurInfo();           
            }
            else if ( MyUtil.estUnEntier(input) )
            {
                MyUtil.afficherMessageErreurInfo();           
            }
            else
            {
                valide = true;
            }
        }

        return input;
    }

    /*
    La méthode saisirNomMenu() appelle une méthode pour faire une lecture 
    au clavier saisi par l'utilisateurE et retourne dans un String 
    @param aucun
    @return nom   La chaine de caractère saisi par l'utilisateurE
    */
    public static String saisirNomMenu()
    {
        String nom = "";
    
        while (nom == "")
        {
            System.out.print("--> Nom du menu : ");
            nom = getStringFromUser();
        }

        return nom;
    }

    /*
    La méthode saisirDescriptionMenu() appelle une méthode pour faire une lecture 
    au clavier saisi par l'utilisateurE et retourne dans un String 
    @param aucun
    @return description   La chaine de caractère saisi par l'utilisateurE
    */
    public static String saisirDescriptionMenu()
    {
        String description = "";
        
        while (description == "")
        {
            System.out.print("--> Description du menu : ");
            description = getStringFromUser();
        }

        return description;
    }

    /*
    La méthode saisirStatutMenu() demande à l'usager de choisir entre deux options,
    soit si le menu est "actif" ou non 
    @param aucun
    @return actif   true si le menu est actif
    */
    public static boolean saisirStatutMenu()
    {
        String input;
        Boolean actif = false;
        boolean valide = false;

        while (!valide)
        {
            System.out.println("--> Statut du menu : ");   
            System.out.println("\t A - Actif" );
            System.out.println("\t I - Inactif ");
            MyUtil.entrezVotreChoix();
            
            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else if ( MyUtil.estUnEntier(input) )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else if ( MyUtil.estUnDouble(input) )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else 
            {
                if ( input.toUpperCase().contentEquals("A") )
                {
                    actif = true;
                    valide = true;
                }                
                else if ( input.toUpperCase().contentEquals("I") )
                {
                    valide = true;
                }
                else
                {
                    MyUtil.afficherMessageErreurOption();
                }           
            }
        }

        return actif;
    }

    /*
    La méthode saisirTypeMenu() demande à l'usager de choisir entre trois options,
    soit si le menu est de type : Déjeuner, Dîner ou Souper
    @param aucun
    @return type   un entier correspondant au type de menu 
    */
    public static int saisirTypeMenu()
    {
        String input;
        int type = -1;
        boolean valide = false;

        while (!valide)
        {
            System.out.println("--> Type de menu : ");   
            System.out.println("\t 1 - Déjeuner" );
            System.out.println("\t 2 - Dîner ");
            System.out.println("\t 3 - Souper ");
            MyUtil.entrezVotreChoix();

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else if ( !MyUtil.estUnEntier(input) )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else 
            {
                type = Integer.parseInt(input);
                if ( type == 1 || type == 2 || type == 3 )
                {
                    valide = true;
                }
                else
                {
                    MyUtil.afficherMessageErreurOption();
                }           
            }
        }
        
        return type;
    }

    /*
    La méthode creerNouveauMet() permet à l'usager de créer un nouveau met
    et les ajoute à la liste selon les spécifications saisis par l'utilisateurE
    @param listeMet   liste dans laquelle l'usager peut créer un nouveau met
    @return aucun
    */
    public static void creerNouveauMet(ArrayList<Mets> listeMets)
    {
        int code;
        String nom;
        String description;
        double prix;
        int type;

        MyUtil.afficherSeparateur();
        System.out.println("CRÉER UN NOUVEAU MET");
        System.out.println("\t >>> Veuillez saisir les informations du met : \n"); 
        
        code = saisirNouveauCodeMet(listeMets);
        nom = saisirNouveauNomMet();
        description = saisirNouvelleDescriptionMet();
        prix = saisirNouveauPrixMet();
        type = saisirTypeMet();

        // ajouter les saisis de menu a la liste des menus
        switch(type)
        {                    
            case 1:                    
                listeMets.add(new Entree(code, nom, description, prix));
                break;
                
            case 2:
                listeMets.add(new PlatPrincipal(code, nom, description, prix));
                break;
                
            case 3:
                listeMets.add(new Dessert(code, nom, description, prix));
                break;
                
            default:
        }
        
        System.out.println("Merci d'avoir créé ce nouveau met :\n" +
                        listeMets.get(listeMets.size()-1).formater(1));

    }    

    /*
    La méthode saisirNouveauCodeMet() demande à l'usager de saisir un code. 
    Recherche dans une liste de mets un élément dont le code correspond 
    à celui saisi au clavier. S'il y est, un message d'erreur s'afffiche. 
    Sinon, il retourne le code.
    @param listeMets    liste dans laquelle s'effectue la recherche
    @return code        code saisi au clavier
    */
    public static int saisirNouveauCodeMet(ArrayList<Mets> listeMets)
    {
        String input;
        int code = 0;
        boolean valide = false;

        while (!valide)
        {
            System.out.print("--> Code du met : ");

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else if ( !MyUtil.estUnEntier(input) ) 
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else 
            {
                code = Integer.parseInt(input);
                int idx = 0;
                if (listeMets.get(idx).getCode() == code)
                {
                    MyUtil.afficherMessageCodeExistant();
                }
                else
                {
                    valide = true;
                }           

            }
        }

        return code;
    }

    /*
    La méthode saisirCodeMet() demande à l'usager de saisir un code existant.
    Recherche dans une liste de mets un élément dont le code correspond à celui 
    saisi au clavier et le retourne. S'il n'y est pas, un message d'erreur s'afffiche. 
    @param listeMets    liste dans laquelle s'effectue la recherche
    @return metChoisi   élément de la liste (mets) qui a été trouvé
    */
    public static Mets saisirCodeMet(ArrayList<Mets> listeMets)
    {
        String input;
        int code = 0;
        boolean valide = false;
        Mets metChoisi = null;

        do
        {
            System.out.print("--> Veuillez saisir le code du met a ajouter (Retour pour terminer) : ");

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                valide = true;
            }
            else if ( !MyUtil.estUnEntier(input) ) 
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else
            {
                boolean trouve = false;
                int idx = 0;
                code = Integer.parseInt(input);
                while ( !trouve && (idx < listeMets.size()))
                {
                    if (listeMets.get(idx).getCode() == code)
                    {
                        metChoisi = listeMets.get(idx);
                        trouve = true;
                        valide = true;
                    }
                    else
                    {
                        idx++;
                    }
                }
            }

            if (!valide)
            {
                MyUtil.afficherMessageErreurChoix();
            }

        }
        while (!valide);
        
        return metChoisi;
    }

    /*
    La méthode saisirNouveauNomMet() appelle une méthode qui fait 
    la lecture au clavier saisi par l'utilisateurE et retourne dans un String 
    @param aucun
    @return nom   La chaine de caractère saisi par l'utilisateurE
    */
    public static String saisirNouveauNomMet()
    {
        String nom = "";

        while (nom == "")
        {
            System.out.print("--> Nom du met : ");
            nom = getStringFromUser();
        }

        return nom;
    }

    /*
    La méthode saisirNouvelleDescriptionMet() appelle une méthode qui fait 
    la lecture au clavier saisi par l'utilisateurE et retourne dans un String 
    @param aucun
    @return description La chaine de caractère saisi par l'utilisateurE
    */
    public static String saisirNouvelleDescriptionMet()
    {
        String description = "";

        while (description == "")
        {
            System.out.print("--> Description du met : ");
            description = getStringFromUser();
        }

        return description;
    }

    /*
    La méthode saisirNouveauPrixMet() fait la lecture au clavier saisi 
    correspondant au prix et le retourne dans un double 
    @param aucun
    @return prix    La valeur réelle saisi
    */
    public static double saisirNouveauPrixMet()
    {
        String input;
        double prix = 0.00;
        boolean valide = false;

        while (!valide)
        {
            System.out.print("--> Prix du met : ");
            input = clavier.nextLine();

            if ( !MyUtil.estUnDouble(input) ) // Utils.estUnReel
            {
                MyUtil.afficherMessageErreurValeurNumerique();
            }
            else 
            {
                prix = Double.parseDouble(input);
                valide = true;
            }
        }

        return prix;
    }

    /*
    La méthode saisirTypeMet() demande à l'usager de choisir entre trois options,
    soit si le met est de type : Entrée, Plat principal ou Dessert
    @param aucun
    @return type   un entier correspondant au type de met 
    */    public static int saisirTypeMet()
    {
        String input;
        int type = -1;
        boolean valide = false;

        while (!valide)
        {
            System.out.println("--> Type de met : ");   
            System.out.println("\t 1 - Entrée" );
            System.out.println("\t 2 - Plat principal ");
            System.out.println("\t 3 - Dessert ");
            MyUtil.entrezVotreChoix();

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else if ( !MyUtil.estUnEntier(input) )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else 
            {
                type = Integer.parseInt(input);
                if ( type == 1 || type == 2 || type == 3 )
                {
                    valide = true;
                }
                else
                {
                    MyUtil.afficherMessageErreurOption();
                }           
            }
        }
        
        return type;
    }

    /*
    La méthode AjouterMetsAMenu() permet à l'usager d'ajouter un met à un menu existant.
    Affiche la liste des menus puis celle des codes de mets existants. 
    Demande à l'usager de choisir un menu dans lequel il veut ajouter un met.
    Ajoute le mets choisi au menu choisi.
    @param listeMenu    liste dans laquelle s'effectue l'ajout
    @param listeMets    liste pour laquelle s'effectue l'affichage
    @return aucun
    */
    public static void AjouterMetsAMenu(ArrayList<Menu> listeMenu, ArrayList<Mets> listeMets)
    {
        Menu menu = null;
        Mets mets = null;
        
        MyUtil.afficherSeparateur();
        System.out.println("AJOUTER UN MET À UN MENU");
        
        MyUtil.afficherSeparateur();
        System.out.println("Voici la liste des menus : \n");
        for (int i = 0; i < listeMenu.size(); i++ )
        {
            menu = listeMenu.get(i);
            System.out.println(" \t" + (i+1) + " - " + menu.getNom() );
        }

        menu = choisirMenu(listeMenu);

        MyUtil.afficherSeparateur();
        System.out.println("Voici les mets actuellement disponibles pour le menu --> " + menu.getNom() + "\n");
        menu.afficherMets();

        MyUtil.afficherSeparateur();
        System.out.println("\n--> Voici la liste de tous les codes de mets existants ");
        for (int i = 0; i < listeMets.size(); i++ )
        {
            System.out.print(listeMets.get(i).getCode() + ", ");
        }        
        System.out.println("\n");

        do 
        {
            mets = saisirCodeMet(listeMets);
            if (mets != null)
            {
                menu.ajouterMets(mets);
            }
        }
        while (mets != null);
        menu.afficherMets();
    }

    /*
    La méthode choisirMenu() recherche dans une liste de menu un élément 
    qui correspond à l'option saisi au clavier et le retourne. Un message 
    d'erreur s'afffiche tant et aussi longtemps que l'option choisi n'est pas valide.
    @param listeMenu    liste dans laquelle s'effectue la recherche
    @return menu        élément de la liste (menu) qui a été trouvé
    */
    public static Menu choisirMenu(ArrayList<Menu> listeMenu)
    {      
        Menu menu = null;
        String input;
        int idx = -1;
        boolean valide = false;

        while (!valide)
        {
            MyUtil.afficherSeparateur();
            System.out.println("Dans quel menu voulez-vous ajouter des mets \n" +
                            "\t     parmi les options ci-dessus ? \n");
            MyUtil.entrezVotreChoix();

            input = clavier.nextLine();
            if ( input.isEmpty() )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else if ( !MyUtil.estUnEntier(input) )
            {
                MyUtil.afficherMessageErreurOption();
            }
            else 
            {
                idx = Integer.parseInt(input) - 1 ;
                if ( idx >= 0 && idx < listeMenu.size() )
                {
                    menu = listeMenu.get(idx);
                    valide = true;
                }
                else
                {
                    MyUtil.afficherMessageErreurOption();
                }
            }
        }

        return menu;
    }

    /*
    La méthode afficherStatistiques() affiche les statistiques des liste de mets et menus
    @param listeMenu    liste pour laquelle s'effectue le calcul
    @param listeMets    liste pour laquelle s'effectue le calcul
    @return aucun
    */
    public static void afficherStatistiques(ArrayList<Menu> listeMenu, ArrayList<Mets> listeMets)
    {
        MyUtil.afficherSeparateur();
        System.out.println("STATISTIQUES \n");

        System.out.println(" Nombre de menus :\t" + listeMenu.size());
        compterNombreMenu(listeMenu);

        System.out.println(" Nombre de mets :\t" + listeMets.size());
        calculerNombrePrixMets(listeMets);
    }

    /*
    La méthode compterNombreMenu() parcour la liste du menu et affiche 
    le nombre de déjeuners, dîners et soupers.
    @param listeMenu    liste parcouru
    @return aucun
    */
    public static void compterNombreMenu(ArrayList<Menu> listeMenu)
    {
        int compteurDejeuner = 0;
        int compteurDiner = 0;
        int compteurSouper = 0;

        for (int i = 0; i < listeMenu.size(); i++ )
        {
            Menu menu = listeMenu.get(i);
            if ( menu instanceof Dejeuner )
            {
                compteurDejeuner++;
            }
            else if ( menu instanceof Diner )
            {
                compteurDiner++;
            }
            else if ( menu instanceof Souper )
            {
                compteurSouper++;
            }
        }

        System.out.println(" Nombre de déjeuners :\t" + compteurDejeuner);
        System.out.println(" Nombre de dîners : \t" + compteurDiner);
        System.out.println(" Nombre de soupers : \t" + compteurSouper);
        System.out.println("");
    }

    /*
    La méthode calculerNombrePrixMets() parcour la liste de mets et affiche 
    le nombre de déjeuners, dîners et soupers en plus du prix moyen de chacun.
    @param listeMets    liste parcouru
    @return aucun
    */
    public static void calculerNombrePrixMets(ArrayList<Mets> listeMets)
    {
        int compteurEntree = 0;
        int compteurPlatPrincipal = 0;
        int compteurDessert = 0;
        Double prixMoyenEntree = 0.0;
        Double prixMoyenPlatPrincipal = 0.0;
        Double prixMoyenDessert = 0.0;
        
        for (int i = 0; i < listeMets.size(); i++ )
        {
            Mets mets = listeMets.get(i);
            if ( mets instanceof Entree )
            {
                compteurEntree++;
                Double prixEntree = mets.getPrix();
                prixMoyenEntree += prixEntree/compteurEntree;
            }
            else if ( mets instanceof PlatPrincipal )
            {
                compteurPlatPrincipal++;
                Double prixPlatPrincipal = mets.getPrix();
                prixMoyenPlatPrincipal += prixPlatPrincipal/compteurPlatPrincipal;
            }
            else if ( mets instanceof Dessert )
            {
                compteurDessert++;
                Double prixDessert = mets.getPrix();
                prixMoyenDessert += prixDessert/compteurDessert;
            }
        }

        System.out.println(" Nombre d’entrées :\t" + compteurEntree + "\n\t " +
                                "Prix moyen : " + String.format("%.2f",prixMoyenEntree) + "$");
        System.out.println(" Nombre de plats principaux : " + compteurPlatPrincipal + "\n\t " + 
                                "Prix moyen : " + String.format("%.2f",prixMoyenPlatPrincipal) + "$");
        System.out.println(" Nombre de desserts : " + compteurDessert + "\n\t " + 
                                "Prix moyen : " + String.format("%.2f",prixMoyenDessert) + "$");
        System.out.println("");
    }
}