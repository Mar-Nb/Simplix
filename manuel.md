# Manuel utilisateur

## Introduction
Ceci est le **manuel utilisateur** de l'API Simplexe. Vous y trouverez toutes les informations qu'il vous faut pour bien utiliser cette API.

## De la cr�ation � la r�solution
### Cr�ation d'un simplexe
Le premier �cran de l'API est un panel o� l'utilisateur choisit le nombre de _contraintes_ et le nombre de _monomes_ des contraintes. Cela se fait en s�lectionnant les valeurs dans les listes d�roulantes.

![panel de cr�ation du simplexe 1](images/creerSimplexe.png)

> Figure 1 : Premier panel de cr�ation d'un simplexe --- Choix du nombre de monomes et de contraintes

Une fois les valeurs s�lectionn�es, l'utilisateur peut appuyer sur le bouton **OK**.

Apr�s avoir appuy� sur **OK**, un autre panel s'affiche. Ce nouveau panel contient le nombre exact de champ n�cessaire pour que l'utilisateur puisse saisir les valeurs de chaque monome.

![panel de cr�ation du simplexe 2](images/creerSimplexe2.PNG)

> Figure 2 : Deuxi�me panel de cr�ation d'un simplexe --- Saisie des monomes

Si les valeurs saisies ne sont pas des nombres ou si un ou plusieurs champs sont laiss�s vides, une fen�tre d'erreur s'affichera.

![erreur de saisie lors de la cr�ation du simplexe](images/erreur-creerSimplexe2.PNG)

> Figure 3 : Deuxi�me panel de cr�ation d'un simplexe --- Fen�tre d'erreur

Une fois que tous les champs ont une valeur valide, l'utilisateur peut appuyer sur le bouton **Cr�er**.

### Effectuer le calcul
Maintenant que le simplexe est cr��, un nouveau panel s'affiche. Ce panel affiche les **contraintes explicites** du simplexe cr�� ainsi que sa **fonction �conomique** dans un cadre dans la partie gauche de la fen�tre. Les variables potientiellement �changeables apparaissent dans le simplexe sous forme de **bouton**.

![panel affichant un simplexe](images/Simplexe.png)

> Figure 4 : Panel affichant le simplexe et ses boutons

Pour **�changer** une variable, il suffit d'appuyer sur un bouton. Le simplexe sera alors mis � jour avec la variable que vous avez s�lectionn�e apparaissant _dans la base_ et la variable de la contrainte apparaissant _hors base_.

Si l'utilisateur a besoin de savoir qu'elle serait l'�change le plus judicieux � faire, il peut appuyer sur le bouton se situant dans la partie sud de la fen�tre. Ce bouton, marqu� d'un point d'interrogation (**?**) permet d'afficher un indice dans le cadre se situant � sa droite. Si ce cadre indique _"Vous avez atteint le b�n�fice maximum"_, alors c'est que vous avez r�solu le simplexe et que vous n'obitendrez pas de meilleur r�sultat.

## La barre de menu
### L'onglet "Fichier"

![barre de menu de l'application](images/barre-fichier.png)

> Figure 5 : Barre de menu --- Le menu _Fichier_ est ouvert

#### Nouveau simplexe
Comme on peut le voir dans la figure ci-dessus, on peut cr�er un nouveau simplexe en appuyant sur ce bouton. Il affichera directement le panel de la **figure 1**.

#### Charger simplexe
![panel de chargement des simplexes](images/chargerSimplexe.png)

> Figure 6 : Le panel de chargement des simplexes

On peut charger un simplexe en appuyant sur le bouton _"Charger simplexe"_. Cela affiche le panel de la figure ci-dessus. L'utilisateur n'a plus qu'� s�lectionner le fichier qu'il veut charger et appuyer sur le bouton en-dessous. 
Le panel de la **figure 4** va alors s'afficher avec le dernier dictionnaire effectu�.

#### Enregistrer, enregistrer sous
En appuyant sur _"Enregistrer"_, l'utilisateur peut sauvegarder son simplexe dans un fichier, ce dernier pouvant �tre charg� plus tard.

#### Mode D�mo
Ce bouton permet d'ouvrir le mode _d�mo_. Ce mode permet � l'utilisateur de voir comment utiliser l'API pendant qu'il utilise l'API, dans le cas o� il aurait du mal.

#### Affichage
Ce bouton a pour seule utilit� d'afficher le panel principal de l'API, celui de la **figure 4**, contenant le simplexe, son historique et le panel contenant les indications.

#### Annuler
Ce bouton, comme son nom l'indique, permet d'annuler la derni�re action men� sur le simplexe. Cela effacera aussi le dernier dictionnaire de l'historique.

#### PDF
Ce bouton permet d'exporter vos dictionnaires dans un fichier au format **PDF**. _Il n'est pas possible de cr�er un fichier PDF sans avoir cr�� un simplexe au pr�alable_.

#### Quitter
Le bouton _"Quitter"_ permet de quitter l'API.

#### Aide (**?**)
Ce bouton ouvre une petite fen�tre indiquant de mani�re succinte ce que l'API peut faire et � quoi elle sert.