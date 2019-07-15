javac gofish/Utils.java
jar   -cf gofish/Utils.jar gofish/Utils.class
javac -cp "gofish/Utils.jar" gofish/Player.java gofish/Card.java gofish/Deck.java gofish/GoFish.java