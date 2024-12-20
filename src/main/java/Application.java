import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        MetierProduitImpl impl = new MetierProduitImpl();

        String menu = "1. Afficher la liste des produits.\n" +
                "2. Rechercher un produit par son id.\n" +
                "3. Ajouter un nouveau produit dans la liste.\n" +
                "4. Supprimer un produit par id.\n" +
                "5. Quitter ce programme.";

        while (true) {
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println(impl.getAll());
                    break;
                case 2:
                    System.out.print("Entrez l'id du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    scanner.nextLine();
                    Produit produitRecherche = impl.findById(idRecherche);
                    if (produitRecherche != null) {
                        System.out.println("Produit trouvé : " + produitRecherche);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'id du produit : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description du produit : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int nombreEnStock = scanner.nextInt();
                    scanner.nextLine();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    impl.add(nouveauProduit);
                    System.out.println("Produit ajouté avec succès.");
                    break;
                case 4:
                    System.out.print("Entrez l'id du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    scanner.nextLine();
                    impl.delete(idSuppression);
                    System.out.println("Produit supprimé avec succès.");
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
            }
        }
    }
}
