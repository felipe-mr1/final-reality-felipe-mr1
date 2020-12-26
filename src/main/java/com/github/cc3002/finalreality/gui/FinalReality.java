package com.github.cc3002.finalreality.gui;

import com.github.cc3002.finalreality.model.Controller.ControllerFF;
import com.github.cc3002.finalreality.model.Controller.GameFactoryFF;
import com.github.cc3002.finalreality.model.Controller.Phases.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class FinalReality extends Application {

  private ControllerFF controllerFF = new ControllerFF();
  Scene creation_scene, main_scene, attack_scene, inventory_scene, partyInfo_scene;
  private String currentTurn;
  private final Label userPlayers = new Label("");
  private final Label Enemies = new Label("");
  private final Label Players = new Label("");
  private final Label turnOf = new Label("");
  private final Label EnemiesA = new Label("");
  private final Label PlayersA = new Label("");
  private final Label GameOver = new Label("");
  private final Label Inventory = new Label("");
  private final Label PartyInfo = new Label("");
  private final Label attackInfo = new Label("");
  private TextField weapon_to_equip = new TextField();

  private Button btn_attack = new Button("Attack");

  private String help;
  private final Label attacker = new Label("");
  //
  private Stage primary_stage;
  //
  private final Group root4 = new Group();
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primary_stage = primaryStage;
    primaryStage.setTitle("Final reality");

    Group root = new Group();
    Label label = new Label("Welcome to Final Reality: Super Mega Alpha Edition");
    Label note = new Label("You will encounter a random set of enemies between 1 and 4\nPlease DO NOT attack too fast");
    root.getChildren().addAll(label, note);
    label.setLayoutX(200);
    label.setLayoutY(100);
    note.setLayoutX(200);
    note.setLayoutY(220);

    // Button Scene 0
    Button btn1 = new Button("Choose Characters");
    btn1.setOnAction(e -> primary_stage.setScene(creation_scene));
    btn1.setLayoutX(270);
    btn1.setLayoutY(180);
    root.getChildren().add(btn1);

    // Root 2 -- Creation
    Group root2 = new Group();

    // Button Creation
    Button btn2 = new Button("Black Mage");
    btn2.setOnAction(e -> TryToCreatePlayer("Emily", "Black Mage", "Knife", "Cuchillito"));
    btn2.setLayoutX(10);
    btn2.setLayoutY(50);

    Button btn3 = new Button("Engineer");
    btn3.setOnAction(e -> TryToCreatePlayer("Emo", "Engineer", "Bow", "Arco"));
    btn3.setLayoutX(130);
    btn3.setLayoutY(50);

    Button btn4 = new Button("Knight");
    btn4.setOnAction((e-> TryToCreatePlayer("Karol", "Knight", "Axe", "Hacha")));
    btn4.setLayoutX(215);
    btn4.setLayoutY(50);

    Button btn5 = new Button("Thief");
    btn5.setOnAction(e-> TryToCreatePlayer("Tata", "Thief", "Sword", "Espada"));
    btn5.setLayoutX(300);
    btn5.setLayoutY(50);

    Button btn6 = new Button("White Mage");
    btn6.setOnAction(e-> TryToCreatePlayer("Waldo", "White Mage", "Staff", "Baston"));
    btn6.setLayoutX(370);
    btn6.setLayoutY(50);

    Button btn_set_scn3 = new Button("Start");
    btn_set_scn3.setLayoutX(200);
    btn_set_scn3.setLayoutY(140);
    btn_set_scn3.setOnAction(e->begin());

    Button reset = new Button("Reset");
    reset.setOnAction(e-> {controllerFF = new ControllerFF(); primary_stage.setScene(creation_scene);});
    reset.setLayoutX(200);
    reset.setLayoutY(180);

    root2.getChildren().addAll(btn2, btn3, btn4, btn5, btn6, btn_set_scn3, reset);


    // Creation Scene
    Label instruction = new Label("Choose 4 Characters");
    instruction.setLayoutX(0);
    instruction.setLayoutY(0);
    Label label2 = new Label("Black Mage: Emily || Engineer: Emo || Knight: Karol || Thief: Tata || White Mage: Waldo");
    label2.setLayoutX(10);
    label2.setLayoutY(20);

    userPlayers.setLayoutX(10);
    userPlayers.setLayoutY(100);
    root2.getChildren().addAll(label2, userPlayers, instruction);
    root2.setLayoutX(80);
    root2.setLayoutY(175);

    creation_scene = new Scene(root2, 640, 480);

    // Root 3 -- Main Phase
    Group root3 = new Group();

    // Button Main Phase
    btn_attack = new Button("Attack");
    btn_attack.setOnAction(actionEvent -> {
      if(!(controllerFF.gameOver())){ if (enemyTurn(currentTurn)){primaryStage.setScene(main_scene);}
      else{primaryStage.setScene(attack_scene);
      controllerFF.setPhase(new AttackPhase(controllerFF));}}
    });
    btn_attack.setLayoutX(50);
    btn_attack.setLayoutY(250);
    Button btn_inventory = new Button("Inventory");
    btn_inventory.setOnAction(e->{controllerFF.setPhase(new InventoryPhase(controllerFF));primaryStage.setScene(inventory_scene);});
    btn_inventory.setLayoutX(150);
    btn_inventory.setLayoutY(250);
    Button btn_team_info = new Button("Party info");
    btn_team_info.setOnAction(e->primaryStage.setScene(partyInfo_scene));
    btn_team_info.setLayoutX(250);
    btn_team_info.setLayoutY(250);

    // Main Scene
    Enemies.setLayoutX(10);
    Enemies.setLayoutY(10);
    Players.setLayoutX(200);
    Players.setLayoutY(200);


    turnOf.setLayoutX(200);
    turnOf.setLayoutY(100);
    GameOver.setLayoutX(200);
    GameOver.setLayoutY(290);
    attackInfo.setLayoutX(200);
    attackInfo.setLayoutY(330);
    root3.getChildren().addAll(Enemies, Players, turnOf, GameOver, btn_attack, btn_inventory, btn_team_info, attackInfo);

    main_scene = new Scene(root3, 640, 480);

    // Root 4 -- Attack
    //Group root4 = new Group();

    // Button Attack
    /*Button btn_enemy1 = new Button("Attack 0");
    btn_enemy1.setOnAction(e->tryToAttack("Goblin0"));
    btn_enemy1.setLayoutX(10);
    btn_enemy1.setLayoutY(240);
    Button btn_enemy2 = new Button("Attack 1");
    btn_enemy2.setOnAction(e->tryToAttack("Goblin1"));
    btn_enemy2.setLayoutX(100);
    btn_enemy2.setLayoutY(240);
    Button btn_enemy3 = new Button("Attack 2");
    btn_enemy3.setOnAction(e->tryToAttack("Goblin2"));
    btn_enemy3.setLayoutX(190);
    btn_enemy3.setLayoutY(240);
    Button btn_enemy4 = new Button("Attack 3");
    btn_enemy4.setOnAction(e->tryToAttack("Goblin3"));
    btn_enemy4.setLayoutX(280);
    btn_enemy4.setLayoutY(240);*/

    /*TextField target_input = new TextField();
    target_input.setPromptText("Enemy target");
    target_input.setLayoutX(10);
    target_input.setLayoutY(300);

    Button btn_target = new Button("Attack");
    btn_target.setOnAction( e-> tryToAttack(target_input.getText()));
    btn_target.setLayoutX(10);
    btn_target.setLayoutY(330);*/

    Button btn_attack_back = new Button("<-- Back");
    btn_attack_back.setOnAction(e->primaryStage.setScene(main_scene));
    btn_attack_back.setLayoutX(100);
    btn_attack_back.setLayoutY(300);

    // Attack Scene
    EnemiesA.setLayoutX(10);
    EnemiesA.setLayoutY(10);
    PlayersA.setLayoutX(200);
    PlayersA.setLayoutY(200);
    attacker.setLayoutX(200);
    attacker.setLayoutY(100);

    root4.getChildren().addAll(/*btn_enemy1, btn_enemy2, btn_enemy3, btn_enemy4,*/ EnemiesA, PlayersA, attacker, /*btn_target, target_input,*/ btn_attack_back);

    attack_scene = new Scene(root4, 640, 480);

    // Root 5 -- Inventory
    Group root5 = new Group();

    // Button Inventory
    Button btn_inv_goBack = new Button("<-- Back");
    btn_inv_goBack.setOnAction(e->{controllerFF.setPhase(new MainPhase(controllerFF)); primaryStage.setScene(main_scene);});
    btn_inv_goBack.setLayoutX(450);
    btn_inv_goBack.setLayoutY(150);

    weapon_to_equip.setLayoutX(450);
    weapon_to_equip.setLayoutY(50);

    Button btn_equip = new Button("Equip Weapon");
    btn_equip.setOnAction(e->tryToEquip(weapon_to_equip.getText()));
    btn_equip.setLayoutX(450);
    btn_equip.setLayoutY(80);

    // Inventory Scene
    Inventory.setLayoutX(30);
    Inventory.setLayoutY(30);

    root5.getChildren().addAll(btn_inv_goBack, Inventory, btn_equip, weapon_to_equip);

    inventory_scene = new Scene(root5, 640, 480);

    // Root 6 -- Party info
    Group root6 = new Group();

    // Party info buttons
    Button go_back = new Button("<-- Back");
    go_back.setOnAction(e->primaryStage.setScene(main_scene));
    go_back.setLayoutX(490);
    go_back.setLayoutY(50);

    // Party info scene

    PartyInfo.setLayoutX(30);
    PartyInfo.setLayoutY(30);

    root6.getChildren().addAll(go_back, PartyInfo);

    partyInfo_scene = new Scene(root6, 640, 480);

    // This sets the size of the Scene to be 400px wide, 200px high
    primary_stage.setOnCloseRequest(e->closeProgram());
    setupTimer();
    Scene scene = new Scene(root, 640, 480);
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  private void closeProgram() {
    System.exit(0);
  }

  private void tryToEquip(String text) {
    controllerFF.tryToEquip(currentTurn, text);
    //controllerFF.equip(currentTurn, text);
  }

  private void begin() {
    if (controllerFF.partySize() == 4){
      controllerFF.createEnemies();
      try{
        controllerFF.addToQueue();
        controllerFF.createWeapon("Wooden Axe", 15, 20, "Axe", 0);
        controllerFF.createWeapon("Super Bow", 50, 40, "Bow", 0);
        controllerFF.createWeapon("Lil Knife", 5, 15, "Knife", 0);
        controllerFF.createWeapon("Normal Staff", 10, 25, "Staff", 0);
        controllerFF.createWeapon("Master Sword", 200, 30, "Sword", 0);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
      int x = 10;
      for (int i = 0; i < controllerFF.enemySize(); i++) {

        Button btn = new Button("Attack" + i);
        int j = i;
        btn.setOnAction(e->tryToAttack("Goblin"+j));
        btn.setLayoutX(x);
        btn.setLayoutY(240);
        root4.getChildren().add(btn);
        x+=90;
      }
      controllerFF.setPhase(new MainPhase(controllerFF));
      currentTurn = controllerFF.getTurnOf();
      turnOf.setText("Turn of: "+ currentTurn);
      primary_stage.setScene(main_scene);
    }
  }


  private void setupTimer() {
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        String userParty = controllerFF.getParty();
        userPlayers.setText("Party: " + userParty);

        String listOfEnemies = controllerFF.getEnemies();
        Enemies.setText(listOfEnemies);

        String listOfPlayers = controllerFF.getPartyInfo();
        Players.setText(listOfPlayers);

        EnemiesA.setText(listOfEnemies);

        PlayersA.setText(listOfPlayers);

        help = currentTurn;
        attacker.setText("Turn of: "+ help);

        String user_inventory = controllerFF.inventory();
        Inventory.setText(user_inventory);

        String party_info = controllerFF.getBattleInfo();
        PartyInfo.setText(party_info);
      }
    };
    timer.start();
  }

  private void TryToCreatePlayer(String aName, String aClass, String aWeapon, String aWeaponName) {
    controllerFF.TryToCreatePlayer(aName, aClass, aWeapon, aWeaponName);
  }

  private void tryToAttack(String target)  {
    if ((controllerFF.getEnemy(target)!=null)&&(controllerFF.getEnemy(target).getHealthPoints()>0)){
      controllerFF.tryToAttack(currentTurn, target);
      attackInfo.setText(currentTurn + " attacked " + target + " for " + controllerFF.getEnemy(target).getDamageReceived());

      // Next turn
      currentTurn = controllerFF.getTurnOf();
      turnOf.setText("Turn of: " + currentTurn);

      setAttackButton(currentTurn);
      primary_stage.setScene(main_scene);
    }

    if (controllerFF.gameOver()){
      //controllerFF.setPhase(new GameOverPhase(controllerFF));
      GameOver.setText("Game Over!");
    }
  }

  private void setAttackButton(String currentTurn) {
    if (controllerFF.getEnemy(currentTurn)!=null){
      btn_attack.setText("Next");
    } else {
      btn_attack.setText("Attack");
    }
  }

  private boolean enemyTurn(String character)  {

    if (controllerFF.getEnemy(character)!= null){
        //btn_attack.setText("Next");
        controllerFF.enemyTurn(controllerFF.getEnemy(character));

        attackInfo.setText(character + " attacked " + controllerFF.getAttackedPlayer() + " for "+ controllerFF.getPlayer(controllerFF.getAttackedPlayer()).getDamageReceived());

        currentTurn = controllerFF.getTurnOf();
        turnOf.setText("Turn of: " + currentTurn);

        setAttackButton(currentTurn);
        return true;
    }
    return false;
  }
}