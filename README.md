# PiFeeder (for fish) Project
<br/>
Description: <br/>
<br/>
Projet de distributeur de nourriture automatique pour poisson, orienté Nano-Aquarium.<br/>
Pourquoi me direz-vous? Car ceux du commerce ne correspondaient pas à ce que je recherchais:<br/>
<br/>
-Ils sont trop gros pour un nano.<br/>
-Donnent de trop grosse portions (pour la plupart).<br/>
-Sont moches.<br/>
-Sont fait pour les vacances (ne correspondent pas forcément à un usage journalier. Oui je suis aquariophile mais surtout fainéant...)<br/>
<br/>
J'ai donc décidé d'en faire un petit et discret, capable de nourrir mes poissons toute l'année et qui est capable 
de donner de toutes petites portions.<br/>
<br/>
![De près](vue1.jpg)
![De loin](vue2.jpg)
<br/>
Pour cela j'utilise:<br/>

 # 1 Raspberry Pi Zer0      (8€)  <br/>
 # 1 ServoMoteur SG90       (2€)  <br/>
 # 1 Dongle USB WIFI petit  (2€)  <br/>
 # 1 impression 3D PLA      (9€)  <br/>
 # _______________________________ <br/>
 # Total:                  ~ 21€<br/>
 
 <br/>
 L'appli sera développée en Java avec Reslet et AngularJs avec une IHM en SemanticUI.<br/>
 (Ne commencez pas à critiquer mes choix ou bien créez votre propre projet Nerds!)<br/>
 
 Commençons:
 
### Partie mécanique
======
Imprimez ou faites imprimer le boitier; Pour cela je vous fournir le .stl qui correspond à mon distributeur.<br/>
<br/>
Si toutefois votre aquarium était plus grand, la vitre plus épaisse ou que la contenance de mon distributeur est trop petite pour vos<br/> 
besoins, je vous ai mis le fickier .skp sketchup, vous n'avez plus qu'à adapter.<br/>
<br/>
Visez le ServoMoteur à son emplacement, et brancher les 3 fils au Raspberry comme suit:<br/>

> la masse sur une masse du GPIO

> le + sur un +5v du GPIO

> le port controle sur le GPIO25

![Branchez comme suit](plan_branchement.png)


 
