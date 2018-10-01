# PiFeeder (for fish) Project

Description: <br/>

Fish Feeder autobot project, designed for Nano-FishTank.<br/>
Why? Cause commercial one doesn't match with my need:<br/>

 - they're too large for a nano fish tank
 - they deliver too much food
 - they are oriented for "holidays usage" (I want feed my fishes only by this way)
 - they are ugly!

So I decided to create a small and discret robot, able to feed my fishes all year long with a configurable portion of food.

This is the result of my experimentation:

<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue1.jpg" width="300"><img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/vue2.jpg" width="300">

Required stuff:

	 1. 1x Raspberry Pi Zer0      	(8€)
	 2. 1x ServoMotor SG90			(2€)	 
	 3. 1 impression 3D PLA      	(9€)
	 _____________________________________
		Total:                  	~21€
 
 <br/>
 The software is developed in Java with Reslet, AngularJs and SemanticUI as frontend.<br/>
_Don't criticize my framework choice, your're free to develop your own..._
 
## Detailed description:
 
### Mechanic part
======
I created the 3d plan on Sketchup, feel free to adapt it to your fish tank; I provide you my .stl file  [here](https://github.com/Belzeb78/PiFeeder/blob/master/3d_print/fishfeeder.stl).

![
](https://github.com/Belzeb78/PiFeeder/raw/master/pictures/Pifeeder.png)
![enter image description here](https://github.com/Belzeb78/PiFeeder/raw/master/pictures/Print_pic.png)

How to mount it:
Screw the servo motor SG90 in is place and screw the food tank to this.
Plug the wires like that:
 - SG90 ground to GPIO ground (Pin 6 by example)
 - SG90 +5V to GPIO +5V (Pin 2)
 - SG90 control wire to the GPIO Pin 25
<img src="https://github.com/Belzeb78/PiFeeder/raw/master/pictures/plan_branchement.png" width="500">

### Software installation:

 1. Install ServoBlaster (By RichardGhirst): https://github.com/richardghirst/PiBits/tree/master/ServoBlaster
 2. Add the jar file you compile (or take [here](https://github.com/Belzeb78/PiFeeder/blob/master/compiled/pifeeder.jar))
 3. Create a service from ([here](https://github.com/Belzeb78/PiFeeder/blob/master/services/pifeeder))

I hope it will help you. 
Feel free to contact me if you need some precisions.




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
eyJoaXN0b3J5IjpbNzkxMjgzNTE0LDE1NTI5NzY2NjJdfQ==
-->