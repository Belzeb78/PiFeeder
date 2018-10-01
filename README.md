# PiFeeder (for fish) Project

Description: <br/>

Fish Feeder autobot project, designed for Nano-FishTank.<br/>
Why? Cause commercial one doesn't match with my need:<br/>

 - they're too large for 

-Ils sont trop gros pour un nano.<br/>
-Donnent de trop grosse portions (pour la plupart).<br/>
-Sont moches.<br/>
-Sont fait pour les vacances (ne correspondent pas forcément à un usage journalier. Oui je suis aquariophile mais surtout fainéant...)<br/>
<br/>
J'ai donc décidé d'en faire un petit et discret, capable de nourrir mes poissons toute l'année et qui est capable 
de donner de toutes petites portions.<br/>
<br/>
<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue1.jpg" width="300"><img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue2.jpg" width="300">
<br/>
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

<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/plan_branchement.png" width="500">


<hr>

## Version Française:

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
<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue1.jpg" width="300"><img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue2.jpg" width="300">
<br/>
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

<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/plan_branchement.png" width="500">
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE5MzEzMzQyMjMsNjA3ODU1MjU4LC04Nj
Y2MTY2NThdfQ==
-->