package Ladybug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Dibujo del personaje Wayzz con transformaciones.
 * 
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 3.0. 27.09.2021
 */
public class WayzzTransformaciones extends Application {
    @Override
    public void start (Stage primaryStage){
        //Crear una caja que contendra el menu de opciones y sera agregado a la ventana
        //principal por medio del rootSecundario
        VBox menuGlobal = new VBox();
        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group();
        //Se crea otro contenedor donde se llama al contenedor principal y a su vez el menuGlobal
        //para que las transformaciones no afecten al menu
        Group rootSecundario = new Group(root, menuGlobal);
        //Creación de una zona de dibujo (canvas) de 500 x 500 puntos
        Canvas canvas = new Canvas(500, 500);
        // Obtención del contexto gráfico del canvas anterior que permitirá realizar posteriormente los dibujos
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // Se añade el canvas al contenedor principal (root)
        root.getChildren().add(canvas);
        // Creación del área (scene) correspondiente al contenido que tendrá la ventana, de 500 x 500 puntos, con color dado en rgb, indicando que el
        // elemento root va a ser el contenedor principal de este espacio
        Scene scene = new Scene(rootSecundario, 500, 500, Color.rgb(224, 151, 115));
        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Wayzz Transformaciones");
        // Orden para que se muestre la ventana
        primaryStage.show();
        //ListView
        ListView lv = new ListView();
        lv.getItems().addAll("Rotar", "Escalar", "Trasladar eje XY", 
                "Sesgar", "Salir");
        //Tamaño maximo de la lista
        lv.setMaxSize(170, 120);
        //Se agregra toda la barra de menuBar a la ventana principal por medio del menuGlobal
        //el cual es llamado por el contenedor secundario
        menuGlobal.getChildren().add(lv);
        //Acciones del ListView
        lv.setOnMouseClicked(event ->{
            if(lv.getSelectionModel().getSelectedItem() == ("Rotar")){
                rotar(root); 
            }else if(lv.getSelectionModel().getSelectedItem().equals("Escalar")){
                escalar(root);
            }else if(lv.getSelectionModel().getSelectedItem().equals("Trasladar eje XY")){
                trasladar(root); 
            }else if(lv.getSelectionModel().getSelectedItem().equals("Sesgar")){
                sesgar(root);
            }else if(lv.getSelectionModel().getSelectedItem().equals("Salir")){
                System.exit(0);
            }
        });  
        
        //CABEZA
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M146,221 C146,221 144,216 141,203"
                + "C141,203 139,190 140,178"
                + "C140,178 142,164 152,139"
                + "C152,139 159,129 184,105"
                + "C184,105 214,90 236,87"//236,87 EMPIEZA LA ANTENA SUPERIOR LADO IZQUIERDO
                + "C236,87 249,88 261,89"//261,89 TERMINA LA ANTENA SUPERIOR
                + "C261,89 261,89 288,94"
                + "C288,94 302,101 316,112"
                + "C316,112 326,122 335,135"
                + "C335,135 342,149 346,162"
                + "C346,162 349,180 348,195"
                + "C348,195 345,214 341,235"
                + "C341,235 336,248 330,266"
                + "C330,266 320,278 305,288"
                + "C270,304 248,305 240,305"//248,305 EMPIEZA EL CUELLO
                + "C240,305 231,305 213,303"//231,305 EMPIEZA EL CUELLO IZQUIERDO
                + "C213,303 193,298 178,291"
                + "C178,291 164,283 153,274"
                + "C153,274 146,265 144,254"
                + "C144,254 144,245 145,234"
                + "C145,234 146,227 145,221");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO IZQUIERDO
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(208, 231, 78));
        gc.beginPath();
        gc.appendSVGPath("M199,249 C199,249 196,251 192,253"
                + "C192,253 186,255 180,257"
                + "C180,257 173,256 168,255"
                + "C168,255 163,253 158,250"
                + "C158,250 154,246 151,241"
                + "C151,241 150,235 149,230"
                + "C149,230 156,215 163,209"
                + "C163,209 171,205 180,205"
                + "C180,205 188,211 192,215"
                + "C192,215 195,222 197,229"
                + "C197,229 199,235 200,242"
                + "C200,242 200,245 199,249");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.rgb(55, 107, 36));
        gc.setFill(Color.rgb(68, 149, 38));
        gc.beginPath();
        gc.appendSVGPath("M186,233 C186,233 184,237 181,239"
                + "C181,239 176,241 171,241"
                + "C171,241 167,238 165,235"
                + "C165,235 164,232 164,228"
                + "C164,228 165,224 168,219"
                + "C168,219 172,216 177,215"
                + "C177,215 181,216 184,219"
                + "C184,219 186,223 187,228"
                + "Q187,228 186,233");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO DERECHO
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(208, 231, 78));
        gc.beginPath();
        gc.appendSVGPath("M241,250 C241,250 241,245 242,239"
                + "C242,239 244,232 247,225"
                + "C247,225 252,218 257,213"
                + "C257,213 264,209 272,208"
                + "C272,208 279,209 286,211"
                + "C286,211 292,213 298,216"
                + "C298,216 302,219 307,223"
                + "C307,223 310,228 310,233"
                + "C310,233 308,237 302,244"
                + "C302,244 295,251 286,255"
                + "C286,255 276,257 267,258"
                + "C267,258 258,258 250,256"
                + "C250,256 244,254 241,250");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.rgb(55, 107, 36));
        gc.setFill(Color.rgb(68, 149, 38));
        gc.beginPath();
        gc.appendSVGPath("M260,241 C260,241 256,235 256,229"
                + "C256,229 256,224 259,219"
                + "C259,219 264,216 269,215"
                + "C269,215 276,217 281,222"
                + "C281,222 283,228 282,235"
                + "C282,235 279,240 272,244"
                + "C272,244 265,243 260,241");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BOCA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M205,284 C205,285 215,280 226,286");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENA SUPERIOR
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M237,87 C237,87 239,77 242,66"
                + "C242,66 245,57 251,40"
                + "C251,40 247,37 246,31"
                + "C246,31 249,23 255,18"
                + "C255,18 261,17 267,21"
                + "C267,21 269,24 270,29"
                + "C270,29 268,35 259,41"
                + "C259,41 259,42 256,53"
                + "C256,53 253,60 251,69"
                + "C251,68 249,78 248,87");       
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CAPARAZON EXTERNO
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M220,304 C220,304 210,311 204,318"
                + "C204,318 196,327 191,338"
                + "C191,338 190,350 191,362"
                + "C191,362 193,371 196,378"
                + "C196,378 200,386 204,393"
                + "C204,393 212,399 220,405"
                + "C220,405 229,410 241,413"
                + "C241,413 254,413 270,409"
                + "C270,409 283,401 294,391"
                + "C294,391 301,378 304,369"
                + "C304,369 306,355 304,341"
                + "C304,341 300,329 294,320"
                + "C294,320 284,312 274,306"
                + "C274,306 264,303 254,304"
                + "C254,304 244,305 232,305"
                + "Q232,305 220,304");       
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CAPARAZON INTERNO
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(62, 124, 66));
        gc.beginPath();
        gc.appendSVGPath("M236,318 C236,318 249,318 261,322"
                + "C261,322 268,330 276,344"
                + "C276,344 277,358 275,370"
                + "C275,370 270,379 255,389"
                + "C255,389 234,388 217,375"
                + "C217,375 211,361 210,346"
                + "C210,346 220,329 236,318");       
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //LINEAS DEL CAPARAZON
        gc.setLineWidth(1);
        gc.setStroke(Color.rgb(64, 128, 68));
        gc.setFill(Color.rgb(64, 128, 68));
        gc.beginPath();
        gc.appendSVGPath("M217,317 Q217,317 213,315"); 
        gc.appendSVGPath("M209,325 Q209,325 205,322");  
        gc.appendSVGPath("M198,347 Q198,347 192,347");
        gc.appendSVGPath("M209,358 Q209,358 196,365");
        gc.appendSVGPath("M212,371 Q212,371 202,381");
        gc.appendSVGPath("M271,397 Q271,397 278,403");
        gc.appendSVGPath("M295,381 Q295,381 278,371");
        gc.appendSVGPath("M301,348 Q301,348 281,348");
        gc.appendSVGPath("M286,317 Q286,317 273,328");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CUERPO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M232,305 C232,305 232,308 232,313"
                + "C232,313 227,316 221,320"
                + "C221,320 214,325 207,332"
                + "C207,332 201,339 201,345"
                + "C201,345 205,348 210,345"
                + "C210,345 218,337 219,341"
                + "C219,341 219,351 218,359"
                + "C218,359 218,366 218,371"
                + "C218,371 215,377 213,383"
                + "C213,383 212,391 212,399"
                + "C212,399 214,405 218,409"
                + "C218,409 222,412 217,418"
                + "C217,418 213,425 209,433"
                + "C209,433 204,443 204,452"
                + "C204,452 207,459 212,464"
                + "C212,464 218,456 223,443"
                + "C223,443 227,430 229,423"
                + "C229,423 231,411 230,408"
                + "C230,408 228,405 230,399"
                + "C230,399 233,392 238,392"//AQUI EMPIEZA LA COLA LADO IZQUIERDO
                + "C238,392 244,391 248,390"
                + "C248,390 248,396 249,402"
                + "C249,402 253,407 258,410"
                + "C258,410 261,412 260,420"
                + "C260,420 259,432 260,444"
                + "C260,444 261,452 264,460"
                + "C264,460 268,465 276,461"
                + "C276,461 279,455 279,444"
                + "C279,444 276,434 273,424"
                + "C273,424 269,417 267,410"
                + "C267,410 266,406 267,401"
                + "C267,401 267,391 265,381"
                + "C265,381 263,374 263,365"
                + "C263,365 263,360 262,353"
                + "C262,353 261,350 267,352"//CODO LADO DERECHO
                + "C267,352 274,350 276,343"
                + "C276,343 273,336 268,328"
                + "C268,328 260,319 254,316"
                + "C254,316 249,312 249,304");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M214,341 C214,341 222,336 229,329"
                + "C229,329 230,325 225,325"
                + "C225,325 220,327 225,325"
                + "C230,325 229,329 222,336");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M263,351 Q263,351 253,345"
                + "Q253,345 246,341"
                + "Q246,341 239,335"
                + "Q239,335 237,330"
                + "Q237,330 244,329"
                + "Q244,329 251,332"
                + "Q251,332 261,338"
                + "Q261,338 251,332"
                + "Q251,332 244,329"
                + "Q244,329 237,330"
                + "Q239,335 246,341"
                + "Q246,341 253,345"
                + "Q253,345 263,351");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //COLA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(68, 189, 94));
        gc.beginPath();
        gc.appendSVGPath("M237,392 C237,392 237,397 237,392"
                + "C237,397 237,403 239,410"
                + "C239,410 242,419 245,426"
                + "C245,426 251,434 253,430"
                + "C253,430 253,416 253,407"
                + "C253,407 249,402 248,397"
                + "C248,397 248,390 244,391");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //DETALLES
        gc.setLineWidth(1.0);
        gc.setStroke(Color.rgb(67, 121, 70));
        gc.setFill(Color.rgb(67, 121, 70));
        gc.beginPath();
        gc.appendSVGPath("M253,326 Q253,326 258,332");//BRAZO LADO DERECHO
        gc.appendSVGPath("M222,380 Q222,380 230,388");//PIERNA LADO IZQUIERDO
        gc.appendSVGPath("M254,386 Q254,386 260,380");//PIERNA LADO DERECHO
        gc.appendSVGPath("M225,412 Q225,412 228,410");//TALON LADO IZQUIERDO
        gc.appendSVGPath("M263,412 Q263,412 266,410");//TALON LADO DERECHO
        gc.closePath();
        gc.fill();
        gc.stroke();
    }
    
    private void rotar(Group root) {
        Rotate rotar = new Rotate();
        rotar.setAngle(5);
        root.getTransforms().addAll(rotar);
    }

    private void escalar(Group root) {
        Scale escalar = new Scale();
        escalar.setX(0.9);
        escalar.setY(0.9);
        root.getTransforms().addAll(escalar);
    }
    
    private void trasladar(Group root) {
        Translate trasladar = new Translate();
        trasladar.setX(30);
        trasladar.setY(30);
        root.getTransforms().addAll(trasladar);
    }
    
    private void sesgar(Group root) {
        Shear shear = new Shear();
	shear.setPivotX(0);
	shear.setPivotY(0);
        
	shear.setX(0.09);
	shear.setY(0.09);
	root.getTransforms().addAll(shear);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

