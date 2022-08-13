package pootp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    static final String FICHIER_MENUS = "menus.txt";
    static final String FICHIER_METS = "mets.txt";
    static final String FICHIER_METS_MENUS = "metsMenus.txt";
    static final char COMMENTAIRE = '#';

    /*
        La méthode creerMenus() permet de créer les objets menus et de leur affecter des valeurs.
        Elle lit le fichier dont le nom est affecté (dans la classe Utils)
        à la variable FICHIER_MENU.
        @param aucun
        @return ArrayList<Menu>
         */
    public static ArrayList<Menu> creerMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        String ligne;
        String[] champs;
        String type;
        int code;
        String nom, description;
        boolean actif, finDeSemaine;

        if (!new File(FICHIER_MENUS).exists()) {
            System.out.println("Le fichier " + FICHIER_MENUS + " n'existe pas");
        } else {
            try {
                BufferedReader input = new BufferedReader(new FileReader(FICHIER_MENUS));
                while (input.ready()) {
                    ligne = input.readLine().trim();
//                    System.out.println("***TRACE Menu lu: " + ligne);
                    if (!ligne.isBlank() && (ligne.charAt(0) != COMMENTAIRE)){
                        champs = ligne.split(";");
                        type = champs[0].trim();
                        code = Integer.parseInt(champs[1].trim());
                        nom = champs[2].trim();
                        description = champs[3].trim();
                        if (champs[4].trim().equalsIgnoreCase("actif"))
                            actif = true;
                        else
                            actif = false;
                        switch (type.toUpperCase()) {
                            case "DEJEUNER":
                                menus.add(new Dejeuner(code, nom, description, actif));
                                break;
                            case "DINER":
                                menus.add(new Diner(code, nom, description, actif));
                                break;
                            case "SOUPER":
                                if (champs[5].trim().equalsIgnoreCase("fin de semaine"))
                                    finDeSemaine = true;
                                else
                                    finDeSemaine = false;
                                menus.add(new Souper(code, nom, description, actif, finDeSemaine));
                                break;
                        }
                    }
                }
                input.close();
            } catch (IOException e) {
                System.out.println("***** Erreur de lecture avec le fichier "
                        + FICHIER_MENUS);
            }
        }
        return menus;
    }

    /*
        La méthode creerMets() permet de créer les objets mets et de leur affecter des valeurs.
        Elle lit le fichier dont le nom est affecté (dans la classe Utils)
        à la variable FICHIER_METS.
        @param aucun
        @return ArrayList<Mets>
         */
    public static ArrayList<Mets> creerMets() {
        ArrayList<Mets> listeMets = new ArrayList<>();
        String ligne;
        String[] champs;
        String type;
        String nom, description;
        int code, calories;
        double prix;
        boolean demiePortion;
        ArrayList<Menu> menus = new ArrayList<>();

        if (!new File(FICHIER_METS).exists()) {
            System.out.println("Le fichier " + FICHIER_METS + " n'existe pas");
        } else {
            try {
                BufferedReader input = new BufferedReader(new FileReader(FICHIER_METS));
                while (input.ready()) {
                    ligne = input.readLine().trim();
//                    System.out.println("***TRACE Mets lu: " + ligne);
                    if (!ligne.isBlank() && (ligne.charAt(0) != COMMENTAIRE)){
                        champs = ligne.split(";");
                        type = champs[0].trim();
                        code = Integer.parseInt(champs[1].trim());
                        nom = champs[2].trim();
                        description = champs[3].trim();
                        prix = Double.parseDouble(champs[4].trim());
                        switch (type.toUpperCase()) {
                            case "ENTREE":
                                listeMets.add(new Entree(code, nom, description, prix));
                                break;
                            case "PLAT PRINCIPAL":
                                if (champs[5].trim().equalsIgnoreCase("oui"))
                                    demiePortion = true;
                                else
                                    demiePortion = false;
                                listeMets.add(new PlatPrincipal(code, nom, description, prix, demiePortion));
                                break;
                            case "DESSERT":
                                calories = Integer.parseInt(champs[5].trim());
                                listeMets.add(new Dessert(code, nom, description, prix, calories));
                                break;
                        }
                    }
                }
                input.close();
            } catch (IOException e) {
                System.out.println("***** Erreur de lecture avec le fichier "
                        + FICHIER_METS);
            }
        }
        return listeMets;
        
    }

    /*
    La méthode affecterMetsAuxMenus() permet d'associer les mets aux différents
    menus. Elle lit le fichier dont le nom est affecté (dans la classe Utils)
    à la variable FICHIER_METS_MENUS.
    @param menus    liste des menus
    @param listeMets liste des mets
    @return aucun
     */
    public static void affecterMetsAuxMenus(ArrayList<Menu> menus, ArrayList<Mets> listeMets) {
        String ligne;
        String[] champs;
        int codeMets;
        int codeMenu;
        Menu menu;
        Mets mets;

        if (!new File(FICHIER_METS_MENUS).exists()) {
            System.out.println("Le fichier " + FICHIER_METS_MENUS + " n'existe pas");
        } else {
            try {
                BufferedReader input = new BufferedReader(new FileReader(FICHIER_METS_MENUS));
                while (input.ready()) {
                    ligne = input.readLine().trim();
//                    System.out.println("***TRACE relation lue: " + ligne);
                    if (!ligne.isBlank() && (ligne.charAt(0) != COMMENTAIRE)){
                        champs = ligne.split(";");
                        codeMets = Integer.parseInt(champs[0]);
                        codeMenu = Integer.parseInt(champs[1]);
                        mets = getMetsParCode(listeMets, codeMets);
                        menu = getMenuParCode(menus, codeMenu);
                        menu.ajouterMets(mets);
                    }
                }
                input.close();
            } catch (IOException e) {
                System.out.println("***** Erreur de lecture avec le fichier "
                        + FICHIER_METS_MENUS);
            }
        }
    }

    /*
    La méthode getMenuarCode() recherche dans une liste de Menus un élément
    dont le code correspond à celui reçu en paramètre. Elle retourne le 1er
    élément qui correspond à ce code.
    @param menus        liste dans laquelle s'effectue la recherche
    @param code         code du menu recherché
    @return Menu        L'élément de la liste (menu) qui a été trouvé ou null
                        si aucun élément n'a été trouvé
     */
    public static Menu getMenuParCode(ArrayList<Menu> menus, int code) {
        boolean trouve = false;
        int idx = 0;
        Menu menu = null;

        while (!trouve && (idx < menus.size())) {
            if (menus.get(idx).getCode() == code)
                trouve = true;
            else
                idx++;
        }
        if (trouve)
            menu = menus.get(idx);
        else
            System.out.println("***ATTENTION*** getMenuParNom retourne null avec: " + code);
        return menu;
    }

    /*
    La méthode getMetsParCode() recherche dans une liste de Mets un élément
    dont le code correspond à celui reçu en paramètre. Elle retourne le 1er
    élément qui correspond à ce code.
    @param listeMets    liste dans laquelle s'effectue la recherche
    @param code         code du mets recherché
    @return Mets        L'élément de la liste (mets) qui a été trouvé ou null
                        si aucun élément n'a été trouvé
     */
    public static Mets getMetsParCode(ArrayList<Mets> listeMets, int code) {
        boolean trouve = false;
        int idx = 0;
        Mets mets = null;

        while (!trouve && (idx < listeMets.size())) {
            if (listeMets.get(idx).getCode() == code)
                trouve = true;
            else
                idx++;
        }
        if (trouve)
            mets = listeMets.get(idx);
        else
            System.out.println("***ATTENTION*** getMetsParNum retourne null avec numero: " + code);
        return mets;
    }

    /*
    La méthode fixeS retourne une chaine de longueur fixe;
    a chaine initiale est tronquée si elle est plus longue que
    le paramètre reçu, ou complétée avec le padding si trop courte.
    @param s        chaîne de caractères à transformer
    @param longueur longueur de la chaîne à retourner
    @param pad      caractère de remplissage pour combler les "espaces"
    @param alignement indique si l'alignement de la chaîne reçue se fera à gauche (-1) ou
                      à droite (1) de la chaîne retournée par la méthode
    @return String    La chaîne de caractères transformée
     */
    public static String fixeS(String s, int longueur, char pad, int alignement) {
        String chaineFixe = "";
        String espace = " ";
        boolean fin = false;
        int i = 0;

        while (i < longueur) {
            if (i == s.length()) {
                fin = true;
            }
            if (!fin) {
                chaineFixe = chaineFixe + s.charAt(i);
            } else {
                if (alignement == -1)
                    chaineFixe = chaineFixe + pad;
                else
                    chaineFixe = pad + chaineFixe;
            }
            i++;
        }
        return chaineFixe;
    }
    /*
        La méthode fixeS retourne une chaine de longueur fixe;
        a chaine initiale est tronquée si elle est plus longue que
        le paramètre reçu, ou complétée avec le padding si trop courte.
        @param s        chaîne de caractères à transformer
        @param longueur longueur de la chaîne à retourner
        @param pad      caractère de remplissage pour combler les "espaces"
        @return String    La chaîne de caractères transformée
         */
    public static String fixeS(String s, int longueur, char pad) {
        String chaineFixe = "";
        String espace = " ";
        boolean fin = false;
        int i = 0;
        int alignement = -1; //alignement à gauche

        while (i < longueur) {
            if (i == s.length()) {
                fin = true;
            }
            if (!fin) {
                chaineFixe = chaineFixe + s.charAt(i);
            } else {
                if (alignement == -1)
                    chaineFixe = chaineFixe + pad;
                else
                    chaineFixe = pad + chaineFixe;
            }
            i++;
        }
        return chaineFixe;
    }

    /*
    La méthode fixeS retourne une chaine de longueur fixe;
    a chaine initiale est tronquée si elle est plus longue que
    le paramètre reçu, ou complétée avec le padding si trop courte.
    @param s        chaîne de caractères à transformer
    @param longueur longueur de la chaîne à retourner
    @param alignement indique si l'alignement de la chaîne reçue se fera à gauche (-1) ou
                      à droite (1) de la chaîne retournée par la méthode
    @return String    La chaîne de caractères transformée
     */
    public static String fixeS(String s, int longueur, int alignement) {
        String chaineFixe = "";
        boolean fin = false;
        int i = 0;
        char pad = ' '; //caractère de remplissage

        while (i < longueur) {
            if (i == s.length()) {
                fin = true;
            }
            if (!fin) {
                chaineFixe = chaineFixe + s.charAt(i);
            } else {
                if (alignement == -1)
                    chaineFixe = chaineFixe + pad;
                else
                    chaineFixe = pad + chaineFixe;
            }
            i++;
        }
        return chaineFixe;
    }
    /*
        La méthode fixeS retourne une chaine de longueur fixe;
        a chaine initiale est tronquée si elle est plus longue que
        le paramètre reçu, ou complétée avec le padding si trop courte.
        @param s        chaîne de caractères à transformer
        @param longueur longueur de la chaîne à retourner
        @return String    La chaîne de caractères transformée
         */
    public static String fixeS(String s, int longueur) {
        String chaineFixe = "";
        boolean fin = false;
        int i = 0;
        int alignement = -1;    //alignement à gauche
        char pad = ' ';         //caractère de remplissage

        while (i < longueur) {
            if (i == s.length()) {
                fin = true;
            }
            if (!fin) {
                chaineFixe = chaineFixe + s.charAt(i);
            } else {
                if (alignement == -1)
                    chaineFixe = chaineFixe + pad;
                else
                    chaineFixe = pad + chaineFixe;
            }
            i++;
        }
        return chaineFixe;
    }

    /*
    La méthode estUnREntier vérifie si la chaîne de caractères reçue en paramètre
    correspond à un nombre entier
    @param chaine   chaine de caractères à vérifier
    @return boolean true si la chaîne correspond à un nombre entier
     */
    public static boolean estUnEntier(String chaine){
        boolean estUnEntier = true;
        int idx = 0;

        while(estUnEntier && idx < chaine.length()){
            if (!Character.isDigit(chaine.charAt(idx)))
                estUnEntier = false;
            else
                idx++;
        }
        return estUnEntier;
    }

    /*
    La méthode estUnReel vérifie si la chaîne de caractères reçue en paramètre
    correspond à un nombre réel
    @param chaine   chaine de caractères à vérifier
    @return boolean true si la chaîne correspond à un nombre réel
     */
    public static boolean estUnReel(String chaine){
        boolean estUnReel;
        double nombre;

        try{
            nombre = Double.parseDouble(chaine);
            estUnReel = true;
        } catch (NumberFormatException e){
            estUnReel = false;
        }
        return estUnReel;
    }

}
