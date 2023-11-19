package Ladybug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Dibujo del personaje Plagg con transformaciones.
 * 
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 3.0. 27.09.2021
 */
public class PlaggTransformaciones extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Crear una caja que contendra el menu de opciones en forma vertical (VBox) y sera agregado a la ventana
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
        Scene scene = new Scene(rootSecundario, 500, 500, Color.rgb(84, 150, 175));
        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Plagg Transformaciones");
        // Orden para que se muestre la ventana
        primaryStage.show();
        
        //CheckBox
        CheckBox cRotar = new CheckBox("Rotar");
        CheckBox cEscalar = new CheckBox("Escalar");
        CheckBox cTrasladar = new CheckBox("Trasladar eje Y");
        CheckBox cSesgar =  new CheckBox("Sesgar");
        CheckBox cSalir = new CheckBox("Salir");
        //Se agregra todos los checkBoxes por medio del menuGlobal
        //el cual es llamado por el contenedor secundario
        menuGlobal.getChildren().add(cRotar);
        menuGlobal.getChildren().add(cEscalar);
        menuGlobal.getChildren().add(cTrasladar);
        menuGlobal.getChildren().add(cSesgar);
        menuGlobal.getChildren().add(cSalir);
        
        //Acciones del CheckBox
        cRotar.setOnAction(event ->{
           rotar(root); 
        });
        cEscalar.setOnAction(event ->{
           escalar(root);
        });
        cTrasladar.setOnAction(event ->{
           trasladar(root);
        });
        cSesgar.setOnAction(event ->{
            sesgar(root);
        });
        cSalir.setOnAction(event ->{
            System.exit(0);
        });
        
        //DIBUJO
        //CABEZA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(13, 31, 38));
        gc.beginPath();
        gc.appendSVGPath("M163,201 C163,201 161,192 160,176"
                + "C160,176 163,160 171,142"
                + "C171,142 181,126 194,114"
                + "C194,114 209,103 230,96"
                + "C230,96 252,95 276,102"
                + "C276,102 302,113 317,126"
                + "C317,126 327,142 330,161"
                + "C330,161 332,182 331,192"
                + "C331,192 325,202 320,214"
                + "C320,214 314,225 307,241"
                + "C307,241 301,254 298,259"
                + "C298,259 293,264 286,267"
                + "C286,267 273,270 262,273"
                + "C262,273 252,273 240,273"
                + "C240,273 229,270 216,269"//ULTIMAS 4 COORDENADAS SE ENCUENTRA EL INICIO DE CUELLO
                + "C216,269 207,267 196,263"
                + "C196,263 180,254 170,248"
                + "C170,248 163,241 158,234"
                + "C158,234 155,227 155,221"
                + "C155,221 156,216 158,212"
                + "C158,212 161,209 163,206"
                + "Q163,206 163,201");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(167, 220, 87));
        gc.beginPath();
        gc.appendSVGPath("M201,234 C201,234 197,233 193,232"
                + "C193,232 189,230 184,227"
                + "C184,227 179,224 175,222"
                + "C175,222 169,218 167,216"
                + "C167,216 165,214 165,210"
                + "C165,210 165,207 167,202"
                + "C167,202 170,200 174,199"
                + "C174,199 179,199 184,201"
                + "C184,201 189,205 194,209"
                + "C194,209 197,216 199,220"
                + "C199,220 201,227 202,232"
                + "Q202,232, 201,234");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M192,222 C192,222 191,220 192,216"
                + "C192,216 193,214 194,215"
                + "C194,215 194,221 192,222");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(167, 220, 87));
        gc.beginPath();
        gc.appendSVGPath("M232,239 C232,239 232,238 234,234"
                + "C234,234 235,232 240,226"
                + "C240,226 245,221 251,219"
                + "C251,219 260,218 266,219"
                + "C266,219 274,222 279,224"
                + "C279,224 283,228 288,231"
                + "C288,231 289,234 287,237"
                + "C282,239 275,242 268,243"
                + "C268,243 260,243 252,243"
                + "C252,243 246,243 240,243"
                + "C240,243 235,242 232,239");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M254,234 C254,234 253,231 254,228"
                + "C254,228 256,226 257,229"
                + "C257,229 256,232 254,234");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OREJA LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(13, 31, 38));
        gc.beginPath();
        gc.appendSVGPath("M175,135 C175,135 172,126 169,116"
                + "C169,116 168,104 167,94"
                + "C167,94 167,80 167,70"
                + "C167,70 167,62 176,64"
                + "C176,64 185,68 195,73"
                + "C195,73 204,79 213,84"
                + "C213,84 218,89 227,98"
                + "C227,98 209,104 193,114"
                + "C193,114 180,126 175,135");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OREJA LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(13, 31, 38));
        gc.beginPath();
        gc.appendSVGPath("M303,116 C303,116 313,112 323,110"
                + "C323,110 335,107 355,106"
                + "C355,106 371,106 384,107"
                + "C384,107 395,108 390,121"
                + "C390,121 384,133 378,148"
                + "C378,148 370,160 360,170"
                + "C360,170 348,181 330,192"
                + "C330,192 332,173 331,162"
                + "C331,162 327,142 316,127"
                + "C316,127 309,120 303,116");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BOCA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M207,258 Q207,258 212,261");
        gc.appendSVGPath("M212,261 Q212,261 218,260");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CONTORNO DEL CUERPO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(13, 31, 38));
        gc.beginPath();
        gc.appendSVGPath("M216,269 C216,269 216,273 213,276"
                + "C213,276 208,276 203,278"
                + "C203,278 197,281 191,285"
                + "C191,285 185,289 185,290"
                + "C185,290 186,294 190,296"
                + "C190,296 194,296 196,296"//LIMITE DEL BRAZO LADO IZQUIERDO
                + "C196,296 194,300 192,307"
                + "C192,307 191,312 192,320"
                + "C193,330 193,335 190,338"
                + "C190,350 196,358 204,361"
                + "C204,361 209,362 208,364"
                + "C208,364 200,371 192,380"
                + "C192,380 187,387 185,392"
                + "C185,392 185,397 191,393"
                + "C191,393 203,382 216,367"
                + "C216,367 220,362 222,364"//TERMINA EL PIE DEL LADO IZQUIERDO (220,362)
                + "C222,364 225,366 224,372"
                + "C224,372 222,382 222,395"
                + "C222,395 224,403 227,408"
                + "C227,408 231,410 235,406"
                + "C235,406 237,389 235,377"
                + "C235,377 232,364 230,365"
                + "C230,365 228,361 230,357"
                + "C230,357 230,346 228,333"
                + "C228,333 228,310 228,307"
                + "C228,307 225,300 230,292"
                + "C230,292 233,283 231,281"
                + "C231,281 229,276 229,270"
                + "C229,270 223,270 216,269");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M225,300 Q225,300 220,301");
        gc.appendSVGPath("M220,301 Q220,301 205,295");
        gc.appendSVGPath("M205,295 Q205,295 201,294");
        gc.appendSVGPath("M201,294 Q201,294 200,288");//INTERSECCION CON EL BRAZO LADO IZQUIERDO
        gc.appendSVGPath("M200,288 Q200,288 206,287");
        gc.appendSVGPath("M206,287 Q206,287 212,290");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M196,296 Q196,296 200,293");
        gc.appendSVGPath("M206,287 Q206,287 209,284");
        gc.appendSVGPath("M209,284 Q209,284 209,280");
        gc.appendSVGPath("M209,280 Q209,280 204,280");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //RODILLA LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M193,336 Q193,336 196,336");
        gc.appendSVGPath("M196,336 Q196,336 198,338");
        gc.appendSVGPath("M198,338 Q198,338 200,339");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //RODILLA LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M222,364 Q222,364 211,355");
        gc.appendSVGPath("M211,355 Q211,355 208,352");
        gc.appendSVGPath("M208,352 Q208,352 208,346");
        gc.appendSVGPath("M208,346 Q208,346 211,343");
        gc.appendSVGPath("M211,343 Q211,343 215,344");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENA SUPERIOR
        gc.setLineWidth(0.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M269,100 C269,100 274,66 276,34"
                + "C276,34 273,65 267,101");//ANTENA SUPERIOR
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENA LADO IZQUIERDO
        gc.setLineWidth(0.7);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M156,216 Q156,216 143,219");
        gc.appendSVGPath("M143,219 Q143,219 120,231");
        gc.appendSVGPath("M120,231 Q120,231 102,255");
        gc.appendSVGPath("M102,255 Q102,255 94,275");
        gc.appendSVGPath("M94,275 Q94,275 90,300");
        gc.appendSVGPath("M90,300 Q90,300 94,327");
        gc.appendSVGPath("M94,327 Q94,327 104,351");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENA LADO DERECHO
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M301,253 Q301,253 311,259");
        gc.appendSVGPath("M311,259 Q311,259 329,279");
        gc.appendSVGPath("M329,279 Q329,279 338,312");
        gc.appendSVGPath("M338,312 Q338,312 334,345");
        gc.appendSVGPath("M334,345 Q334,345 314,382");
        gc.appendSVGPath("M314,382 Q314,382 296,397");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //COLA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(13, 31, 38));
        gc.beginPath();
        gc.appendSVGPath("M228,327 C228,324 237,328 247,338"
                + "C247,338 255,351 259,370"
                + "C259,370 259,393 254,416"
                + "C254,416 247,443 247,452"
                + "C247,452 244,457 241,450"
                + "C241,450 245,429 252,409"
                + "C252,409 256,384 255,368"
                + "C255,368 251,348 242,337"
                + "C242,337 231,328 228,327");
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
        trasladar.setY(-30);
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

