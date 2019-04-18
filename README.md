# Eco-Rallye (Projet cadre scolaire)

Pour ce projet, l’objectif est de faire un jeu ou le joueur va piloter une voiture electrique pourvue de plusieurs systèmes (moteur(s) électrique(s), batterie, panneaux solaires, pile à combustibles, pneu faible contact…). L’objectif n’est pas d’arriver le plus vite possible (même si l’ajout d’une fourchette de temps pourrait être intéressante) mais de consommer le moins possible. Le(s) terrain(s) de jeu devront avoir des dénivelés afin de rendre la conduite intéressante. Par ailleurs, il sera possible d’améliorer la voiture après chaque course en fonction des gains réalisés.

Par rapport aux spécificités du projet nous avons réussi à implémenter les fonctionnalités suivantes :
- Physique du jeu à base de la bibliothèque Physics qui est une implémentation des équations de Verlet
- Moteur électrique
- Pneu faible contact
- Piste avec des dénivelés 
- Fourchette de temps
- Ajout d'une sorte de Turbo qui ici est plutôt une Range Extender (prolongateur d'autonomie) de la voiture
- Freinage régénératif

Le langage utilisé pour le code est le JAVA. Pour l'interface nous avons fait le choix de Java Swing. Le code est structuré en pattern MVC (Model View Controller).
Les interfaces sont les suivantes :

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20Menu%20Principal.png)
C'est le menu principal. L'utilisateur peut choisir de débuter le jeu ou s'il possède assez de points peut acheter une fourchette de temps et/ou un range extender.

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20Shop.png)
Interface de la boutique du jeu pour l'achat des supers.

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20Choisir%20une%20piste.png)
Interfarce de choix des pistes. Nous n'avons construit que deux pistes pour le jeu.

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye.png)
Capture d'écran d'une course sur la première piste. (Désolé pour la qualité de l'image, vous pouvez le remplacer :) )

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye_denivelle.png)
Une autre capture d'une course

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20enneige.png)
Capture d'une course sur la piste 2 (enneigée ;) )

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20You%20win%20!.png)
Interface qui apparaît lorsqu'on gagne une course. Le bonus gagné est affiché.

![alt text](https://github.com/lordkevinmo/Eco-Rallye/blob/master/Eco%20Rallye%20-%20Game%20Over.png)
Interface qui apparaît lorsqu'on perd une course.
