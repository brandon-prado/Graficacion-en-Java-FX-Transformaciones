package Ladybug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Dibujo del personaje Duusu con transformaciones.
 * 
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 3.0. 27.09.2021
 */
public class DuusuTransformaciones extends Application {
    @Override
    public void start(Stage primaryStage) {
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
        Scene scene = new Scene(rootSecundario, 500, 500, Color.rgb(36, 211, 179));
        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Duusu Transformaciones");
        // Orden para que se muestre la ventana
        primaryStage.show();
        //RadioButton
        RadioButton rRotar = new RadioButton("Rotar");
        RadioButton rEscalar = new RadioButton("Escalar");
        RadioButton rTrasladar = new RadioButton("Trasladar eje X");
        RadioButton rSesgar = new RadioButton("Sesgar");
        RadioButton rSalir = new RadioButton("Salir");
        //Se agregra todos los checkBoxes por medio del menuGlobal
        //el cual es llamado por el contenedor secundario
        menuGlobal.getChildren().add(rRotar);
        menuGlobal.getChildren().add(rEscalar);
        menuGlobal.getChildren().add(rTrasladar);
        menuGlobal.getChildren().add(rSesgar);
        menuGlobal.getChildren().add(rSalir);
        //Acciones de los 5 RadioButton
        rRotar.setOnAction((ActionEvent event) -> {
            rotar(root); 
        });
        rEscalar.setOnAction((ActionEvent event) -> {
            escalar(root);
        });
        rTrasladar.setOnAction((ActionEvent event) -> {
            trasladar(root);
        });
        rSesgar.setOnAction((ActionEvent event) -> {
            sesgar(root);
        });
        rSalir.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        
        //DIBUJO
        //CABEZA
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(26, 113, 211));
        gc.beginPath();
        gc.appendSVGPath("M280,274 C280,274 263,264 246,248"
                + "C246,248 226,226 219,205"
                + "C219,205 215,188 222,161"
                + "C222,161 227,144 235,125"
                + "C235,125 243,115 251,103"
                + "C251,103 261,92 270,85"
                + "C270,85 283,77 299,72"
                + "C299,72 315,69, 329,68"
                + "C329,68 335,68 349,70"
                + "C349,70 364,76 379,83"
                + "C379,83 392,94 403,104"
                + "C403,104 414,121 421,136"
                + "C421,136 426,157 427,174"
                + "C427,174 424,187 421,198"
                + "C421,198 416,207 413,212"
                + "C413,212 406,225 407,234"
                + "C407,234 406,249 401,258"
                + "C401,258 396,264 388,271"
                + "C388,271 382,275 379,276"
                + "C379,276 359,281 337,284"
                + "C337,284 316,282 293,278"
                + "Q293,278 280,274");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENAS SUPERIORES
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(26, 113, 211));
        gc.beginPath();
        gc.appendSVGPath("M284,78 Q284,78 264,82"
                + "Q264,82 252,91"
                + "Q252,91 245,99"
                + "Q245,99 252,91"
                + "Q252,91 264,82"
                + "Q264,82 284,78");
        gc.appendSVGPath("M245,99 C245,99 239,101 229,106"
                + "C229,106 222,111 216,116"
                + "C216,116 212,129 221,128"
                + "C221,128 230,120 238,111"
                + "C238,111 243,104 245,99");//PRIMER ANTENA
        gc.appendSVGPath("M319,69 Q319,69 308,64"
                + "Q308,64 294,63"
                + "Q294,63 280,66"
                + "Q280,66 263,74"
                + "Q263,74 280,66"
                + "Q280,66 294,63"
                + "Q294,63 308,64"
                + "Q308,64 319,69");
        gc.appendSVGPath("M263,74 C263,74 258,75 244,78"
                + "C244,78 238,81 230,86"
                + "C230,86 227,94 236,96"
                + "C236,96 247,89 258,80"
                + "Q258,80 263,74");//SEGUNDA ANTENA
        gc.appendSVGPath("M334,68 Q334,68 330,59"
                + "Q330,59 320,49"
                + "Q320,49 311,46"
                + "Q311,46 304,46"
                + "Q304,46 289,50"
                + "Q289,50 304,46"
                + "Q304,46 311,46"
                + "Q311,46 320,49"
                + "Q320,49 330,59"
                + "Q330,59 334,68");
        gc.appendSVGPath("M289,50 C289,50 281,50 273,50"
                + "C273,50 264,53 256,58"
                + "C256,58 252,64 260,67"
                + "C260,67 269,64 284,54"
                + "Q284,54 289,50");//TERCERA ANTENA
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(45, 39, 169));
        gc.beginPath();
        gc.appendSVGPath("M333,193 C333,193 327,197 321,197"
                + "C321,197 312,196 304,193"
                + "C304,193 295,190 288,186"
                + "C288,186 283,182 276,176"
                + "C276,176 270,169 268,161"
                + "C268,161 265,154 265,148"
                + "C265,148 271,144 277,140"
                + "C277,140 290,136 298,136"
                + "C298,136 307,138 314,141"
                + "C314,141 321,146 327,152"
                + "C327,152 331,159 333,166"
                + "C333,166 335,175 335,182"
                + "C335,182 335,189 333,193");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(230, 109, 219));
        gc.beginPath();
        gc.appendSVGPath("M278,178 C278,178 277,170, 278,161"
                + "C278,161 281,155 285,150"
                + "C285,150 293,146 300,145"
                + "C300,145 308,145 314,146"
                + "C314,146 320,150 324,155"
                + "C324,155 328,165 328,172"
                + "C328,172 327,178 324,185"
                + "C324,185 320,190 313,196"
                + "C313,196 305,194 294,190"
                + "C294,190 288,186 279,178");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.appendSVGPath("M286,184 C286,184 284,177 284,170"
                + "C284,170 285,164 289,157"
                + "C289,157 296,152 303,151"
                + "C303,151 310,151 315,155"
                + "C315,155 319,159 320,164"
                + "C320,164 321,171 318,178"
                + "C318,178 315,184 310,187"
                + "C310,187 298,192 291,188"
                + "C291,188 289,187 286,184");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑA OJO LADO IZQUIERDO
        gc.setLineWidth(1);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.appendSVGPath("M266,148 C266,148 263,144 260,140"
                + "C260,140 257,128 262,132"
                + "C262,132 266,135 273,142"
                + "C273,142 269,144 266,148");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(45, 39, 169));
        gc.beginPath();
        gc.appendSVGPath("M369,208 C369,208 370,202 374,198"
                + "C374,198 379,193 385,188"
                + "C385,188 392,184 398,184"
                + "C398,184 403,187 409,192"
                + "C411,198 411,205 411,212"
                + "C411,212 409,220 406,225"
                + "C406,225 404,230 400,233"
                + "C400,233 396,236 391,236"
                + "C391,236 388,235 383,231"
                + "C383,231 379,227 374,220"
                + "C374,220 370,212 369,208");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(230, 109, 219));
        gc.beginPath();
        gc.appendSVGPath("M390,185 C388,185 394,187 398,189"
                + "C398,189 402,192 404,197"
                + "C404,197 406,201 406,207"
                + "C406,207 406,213 405,219"
                + "C405,219 402,223 399,227"
                + "C399,227 395,230 389,234"
                + "C389,234 388,235 384,231"
                + "C384,231 380,227 374,220"
                + "C374,220 370,212 370,205"
                + "C370,205 371,200 377,194"
                + "C377,194 382,190 390,186");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.appendSVGPath("M382,191 C382,191 387,191 393,193"
                + "C393,193 397,197 400,204"
                + "C400,204 401,207 401,213"
                + "C401,213 399,218 396,223"
                + "C396,223 391,226 388,229"
                + "C388,229 384,231 380,228"
                + "C380,228 377,224 371,215"
                + "C371,215 369,211 370,208"
                + "C370,208 371,203 373,198"
                + "C373,198 379,193 382,191");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑA OJO LADO IZQUIERDO
        gc.setLineWidth(1);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.appendSVGPath("M411,213 C411,213 416,213 418,213"
                + "C418,213 422,213 420,216"
                + "C420,216 418,219 415,220"
                + "C415,220 408,222 411,213");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUNTO SUPERIOR 
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(230, 109, 219));
        gc.beginPath();
        gc.appendSVGPath("M374,139 C374,139 375,134 378,133"
                + "C378,133 381,130 383,132"
                + "C383,132 387,135 389,138"
                + "C389,138 389,142 388,146"
                + "C388,146 386,149 381,149"
                + "C381,149 376,147 374,144"
                + "Q374,144 374,139");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CUERPO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(26, 113, 211));
        gc.beginPath();
        gc.appendSVGPath("M280,274 C280,274 279,277 273,277"
                + "C273,277 266,276 258,275"
                + "C244,271 236,270 225,269"
                + "C203,271 198,274 202,279"
                + "C221,284 234,284 246,285"
                + "C246,285 256,284 260,284"
                + "C260,284 264,284 260,289"
                + "C260,289 250,298 241,308"
                + "C241,308 232,318 229,322"
                + "C229,322 225,326 216,325"
                + "C216,325 195,326 176,325"
                + "C176,325 154,326 135,326"
                + "C135,326 113,328 91,333"
                + "C91,333 75,340 61,349"
                + "C61,349 54,362 56,370"
                + "C56,370 64,382 64,382"
                + "C64,382 54,396 53,407"
                + "C53,407 55,426 65,438"
                + "C65,438 83,448 98,447"
                + "C98,447 98,455 111,473"
                + "C111,473 134,493 172,483"
                + "C172,483 189,471 189,471"
                + "C189,471 202,476 202,476"
                + "C202,476 225,482 239,475"
                + "C239,475 260,461 267,439"
                + "C267,439 292,441 296,404"
                + "C296,404 294,392 283,377"
                + "C283,377 265,354 265,354"
                + "C265,354 270,340 279,327"
                + "C279,327 285,312 290,302"
                + "C290,302 289,302 292,308"
                + "C292,308 301,318 310,326"
                + "C310,326 320,327 321,320"
                + "C321,320 312,309 303,300"
                + "C303,300 291,290 291,290"
                + "C291,290 289,283 292,281"
                + "Q292,281 293,278");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //DETALLES
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.strokeOval(85,344,40,37);
        gc.fillOval(85,344,40,37);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(178, 33, 165));
        gc.beginPath();
        gc.strokeOval(89,347,30,27);
        gc.fillOval(89,347,30,27);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.strokeOval(93,352,20,17);
        gc.fillOval(93,352,20,17); //PRIMER DETALLE
        
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.strokeOval(71,390,40,37);
        gc.fillOval(71,390,40,37);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(178, 33, 165));
        gc.beginPath();
        gc.strokeOval(75,394,30,27);
        gc.fillOval(75,394,30,27);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.strokeOval(78,399,20,17);
        gc.fillOval(78,399,20,17); //SEGUNDO DETALLE
        
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.strokeOval(123,431,40,37);
        gc.fillOval(123,431,40,37);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(178, 33, 165));
        gc.beginPath();
        gc.strokeOval(126,434,30,27);
        gc.fillOval(126,434,30,27);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.strokeOval(129,439,20,17);
        gc.fillOval(129,439,20,17); //TERCER DETALLE
        
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.strokeOval(204,430,40,37);
        gc.fillOval(204,430,40,37);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(178, 33, 165));
        gc.beginPath();
        gc.strokeOval(207,435,30,27);
        gc.fillOval(207,435,30,27);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.strokeOval(210,441,20,17);
        gc.fillOval(210,441,20,17); //CUARTO DETALLE
        
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(16, 15, 64));
        gc.beginPath();
        gc.strokeOval(239,386,40,37);
        gc.fillOval(239,386,40,37);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(178, 33, 165));
        gc.beginPath();
        gc.strokeOval(243,391,30,27);
        gc.fillOval(243,391,30,27);
        
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.strokeOval(246,396,20,17);
        gc.fillOval(246,396,20,17); //QUINTO DETALLE
        
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //COLA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M132,382 Q132,382 152,374");
        gc.appendSVGPath("M152,374 Q152,374 169,364");//PRIMER CONTORNO
        
        gc.appendSVGPath("M147,421 Q147,421 167,405");
        gc.appendSVGPath("M167,405 Q167,405 184,384");//SEGUNDO CONTORNO
        
        gc.appendSVGPath("M189,419 Q189,419 189,404");
        gc.appendSVGPath("M189,404 Q189,404 197,381");//TERCER CONTORNO
        
        gc.appendSVGPath("M229,402 Q229,402 226,390");
        gc.appendSVGPath("M226,390 Q226,390 228,374");//CUARTO CONTORNO
        
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BOCA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M305,244 Q305,244 315,251");
        gc.appendSVGPath("M315,251 Q315,251 327,254");
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
        trasladar.setX(-30);
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

