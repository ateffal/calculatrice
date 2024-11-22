import java.util.Scanner;

public class GestionStock {

    static int nombreProduits = 0;
    static int[] codesProduits = new int[5]; // Contiendra les codes uniques pour chaque produit.
    static String[] nomsProduits = new String[5]; //Contiendra les noms des produits.
    static int[] quantitesProduits = new int[5]; //Contiendra les quantités en stock pour chaque produit.
    static double[] prixProduits = new double[5]; //Contiendra les prix unitaires de chaque produit.

    static void ajouterProduit(int code, String nom, int quantite, double prix) {
        if(nombreProduits < 100) {
            codesProduits[nombreProduits] = code;
            nomsProduits[nombreProduits] = nom;
            quantitesProduits[nombreProduits] = quantite;
            prixProduits[nombreProduits] = prix;
            nombreProduits = nombreProduits + 1;
            System.out.println("Produit crée à la position " + nombreProduits);
        } else {
            System.out.println("Nombre de produits maximal atteint !");
        }
    }

    static void modifierProduit(int code, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {

    }

    static void supprimerProduit(int code) {

        for(int i=0;i<nombreProduits;i++){
            if(codesProduits[i]==code) {
                codesProduits[i] = 0;
                nombreProduits=nombreProduits-1;
                System.out.println("Produit " + code + " supprimé.");
                return;
            }
        }
        System.out.println("code : " + code + " non trouvé");
    }

    static void afficherProduits() {
        int nbProduits = 0;
        int i = 0;
        //for(int i=0;i<nombreProduits;i++) {
        while(nbProduits<nombreProduits) {
            if(codesProduits[i]!=0) {
                System.out.println("code : " + " " + codesProduits[i]);
                System.out.println("Nom : " + " " + nomsProduits[i]);
                System.out.println("quantité : " + " " + quantitesProduits[i]);
                System.out.println("Prix : " + " " + prixProduits[i]);
                System.out.println("--------------------------------------------");
                nbProduits++;
            }
            i++;
        }

        //}

        System.out.println("Nombre de produits : " + nombreProduits);

    }

    static int rechercherProduit(String nom) {
        return -1;
    }

    static double calculerValeurStock() {
        return 0;
    }

    public static void main(String[] args) {


        int choix;

        //taking value as command line argument.
        Scanner in = new Scanner(System.in);


        do {

            System.out.println(
                    """
                            ----- Gestion de Stock -----\s
                            1. Ajouter un produit\s
                            2. Modifier un produit\s
                            3. Supprimer un produit\s
                            4. Afficher la liste des produits\s
                            5. Rechercher un produit\s
                            6. Calculer la valeur totale du stock\s
                            0. Quitter
                            
                            Choisissez une option :
                            """
            );

            choix = in.nextInt();
            if (choix < 0 | choix > 6) {
                System.out.println("!!!!!! Choisissez une option entre 0 et 6. !!!!!! ");
            }
        } while (choix < 0 | choix > 6);

        /* tu dois te servir d'une variable pour gerer le nombre de produits présents dans le stock
         * Lorsque tu crée un produit, il faut l'incrémenter (+1)
         * Lorsque tu supprimer un produit, il faut le décrémenter (-1)
         *
         * */

        switch (choix) {
            case 1 : System.out.println("case  1");
                     ajouterProduit(101,"produit 1", 100,15000);
                     ajouterProduit(102,"produit 2", 700,500);
                     ajouterProduit(103,"produit 3", 800,1500);
                     afficherProduits();
                break;

            case 2 : System.out.println("case  2");
                break;

            case 3 : int codeSuppr= in.nextInt();
                      supprimerProduit(codeSuppr);
                break;

            case 4 : System.out.println("case  4");
                break;


            case 5 : System.out.println("case  5");
                break;

            case 6 : System.out.println("case  6");
                break;

            case 0 : System.out.println("case  0");
                break;





        } //fin de swith

        System.out.println("Quel produit vous voulez supprimer ?");
        int codeSuppr2= in.nextInt();
        supprimerProduit(codeSuppr2);
        afficherProduits();
        System.out.println("++++++++++++++++++++++++++++++");
    }


}
