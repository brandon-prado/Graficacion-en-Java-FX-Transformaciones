package Ladybug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Dibujo del personaje Pollen con transformaciones.
 * 
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 3.0. 27.09.2021
 */
public class PollenTransformaciones extends Application {
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
        Scene scene = new Scene(rootSecundario, 500, 500, Color.rgb(238, 124, 90));
        // Se asocia la ventana (scene) al parámetro primaryStage (escenario
        // principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        // Título que se aparecerá en la ventana
        primaryStage.setTitle("Pollen Transformaciones");
        // Orden para que se muestre la ventana
        primaryStage.show();
        //ChoiceBox
        ChoiceBox cOpciones = new ChoiceBox(FXCollections.observableArrayList("Rotar", "Escalar", "Trasladar eje X", "Sesgar", "Salir"));
        //Se agregra toda la barra de menuBar a la ventana principal por medio del menuGlobal
        //el cual es llamado por el contenedor secundario
        menuGlobal.getChildren().add(cOpciones);
        //Acciones de las 5 opciones del ChoiceBx
        cOpciones.getSelectionModel().selectedIndexProperty().addListener((ObservableValue < ? extends Number > oV, Number oldVal, Number newVal) -> {
            if(newVal.intValue() == 0){
                rotar(root);
            }else if(newVal.intValue() == 1){
                escalar(root);
            }else if(newVal.intValue() == 2){
                trasladar(root);
            }else if(newVal.intValue() == 3){
                sesgar(root);
            }else if(newVal.intValue() == 4){
                System.exit(0);
            }
         });
        
        //DIBUJO
        //CABEZA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(229, 166, 29));
        gc.beginPath();
        gc.appendSVGPath("M266,343 C266,343 249,342 249,342"
                + "C249,342 235,339 219,336"
                + "C219,336 204,330 190,323"
                + "C190,323 177,315 168,305"
                + "C168,305 161,293 162,278"
                + "C162,278 165,263 162,256"
                + "C162,256 156,240 154,227"
                + "C154,227 153,214 153,206"
                + "C153,206 152,194 154,181"
                + "C154,181 159,166 164,154"
                + "C164,154 171,142 179,132"
                + "C179,132 189,122 196,117"
                + "C196,117 220,103 236,99"
                + "C236,99 259,95 301,99"
                + "C301,99 319,105 337,116"
                + "C337,116 352,132 362,145"
                + "C362,145 369,157 375,171"
                + "C375,171 378,181 382,195"
                + "C382,195 382,209 383,234"
                + "C383,234 381,257 375,274"
                + "C375,274 369,291 358,304"
                + "C358,304 341,317 317,328"
                + "C317,328 301,334 283,340"
                + "C283,340 272,342 266,343");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(29, 178, 229));
        gc.beginPath();
        gc.appendSVGPath("M222,272 C222,272 212,273 204,273"
                + "C204,273 188,273 180,272"
                + "C180,272 169,271 167,264"
                + "C167,264 168,258 170,251"
                + "C170,251 174,244 185,240"
                + "C185,240 199,241 206,244"
                + "C206,244 212,250 216,255"
                + "C216,255 221,265 222,272");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(102, 16, 29));
        gc.beginPath();
        gc.appendSVGPath("M179,272 C179,272 174,265 174,259"
                + "C174,259 174,255 178,248"
                + "C178,248 184,243 192,241"
                + "C192,241 199,242 206,245"
                + "C206,245 210,250 214,255"
                + "C214,255 215,263 211,273");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M184,272 C184,272 180,268 178,262"
                + "C178,262 178,257 181,252"
                + "C181,252 184,248 190,245"
                + "C190,245 196,244 200,247"
                + "C200,247 203,249 206,252"
                + "C206,252 209,258 209,263"
                + "C209,263 207,268 203,273");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑA OJO LADO IZQUIERDO
        gc.setLineWidth(2);
        gc.setFill(Color.rgb(61, 16, 22));
        gc.setFill(Color.rgb(61, 16, 22));
        gc.beginPath();
        gc.appendSVGPath("M168,266 Q168,266 155,260"
                + "Q155,260 168,262");
        gc.appendSVGPath("M167,259 Q167,259 156,255"
                + "Q156,255 168,253");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(29, 178, 229));
        gc.beginPath();
        gc.appendSVGPath("M269,262 C268,262 269,253 271,244"
                + "C271,244 276,234 286,225"
                + "C286,225 295,221 305,219"
                + "C305,219 325,221 336,225"
                + "C336,225 343,229 343,229"
                + "C343,229 347,230 346,234"
                + "C346,234 343,240 336,246"
                + "C336,246 326,249 317,250"
                + "C317,250 309,252 301,255"
                + "C301,255 285,260 269,262");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(102, 16, 29));
        gc.beginPath();
        gc.appendSVGPath("M275,262 C275,262 269,253 271,244"
                + "C271,244 275,235 286,225"
                + "C286,225 295,221 304,220"
                + "C304,220 315,220 319,224"
                + "C319,224 322,229 325,236"
                + "C325,236 325,241 324,248"
                + "C324,248 317,250 308,252"
                + "C308,252 301,254 293,257");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M281,260 C281,260 276,253 276,249"
                + "C276,249 274,248 282,229"
                + "C282,229 291,225 299,224"
                + "C299,224 307,227 313,231"
                + "C313,231 317,239 316,250"
                + "C316,250 308,252 301,255"
                + "C301,255 293,257 280,260");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑA OJO LADO IZQUIERDO
        gc.setLineWidth(2);
        gc.setFill(Color.rgb(61, 16, 22));
        gc.setFill(Color.rgb(61, 16, 22));
        gc.beginPath();
        gc.appendSVGPath("M335,225 Q335,225 347,227"
                + "Q347,227 351,226"
                + "Q351,226 360,218"
                + "Q360,218 356,226"
                + "Q356,226 351,233"
                + "Q351,233 346,236"
                + "Q346,236 342,239"
                + "Q342,239 347,232"
                + "Q347,232 347,230"
                + "Q347,230 342,228");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BOCA
        gc.setLineWidth(1);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M219,295 Q219,295 226,297"
                + "Q226,297 234,298");
        gc.appendSVGPath("M257,295 Q257,295 265,292"
                + "Q265,292 269,290"
                + "Q269,290 265,292"
                + "Q265,292 257,295");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //DIENTES
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.beginPath();
        gc.appendSVGPath("M234,298 Q234,298 246,297"
                + "Q246,297 257,295"
                + "Q257,295 252,299"
                + "Q252,299 246,301"
                + "Q246,301 238,301"
                + "Q238,301 234,298");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //RAYAS DE LA CABEZA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M197,117 C197,117 207,110 220,104"
                + "C220,104 237,99 251,96"
                + "C251,96 271,94 288,96"
                + "C288,96 301,98 289,98"
                + "C289,98 281,99 268,103"
                + "C268,103 255,108 241,115"
                + "C241,115 236,119 236,119"
                + "C236,119 228,126 228,126"
                + "C228,126 220,121 220,121"
                + "C220,121 212,118 206,117"
                + "Q206,117 197,117");//PRIMER RAYA SUPERIOR
        
        gc.appendSVGPath("M159,166 C159,166 163,163 170,157"
                + "C170,157 181,154 192,154"
                + "C192,154 206,159 218,170"
                + "C218,170 228,187 228,187"
                + "C228,187 231,178 231,178"
                + "C231,178 236,167 243,158"
                + "C243,158 258,144 277,135"
                + "C277,135 289,131 315,134"
                + "C315,134 332,138 344,143"
                + "C344,143 356,151 369,158"
                + "C369,158 361,145 352,132"
                + "C352,132 336,123 320,117"
                + "C320,117 301,113 288,113"
                + "C288,113 270,116 253,122"
                + "C253,122 244,127 234,135"
                + "C234,135 226,147 226,147"
                + "C226,147 220,140 213,135"
                + "C213,135 200,132 191,132"
                + "C191,132 178,137 170,144"
                + "C170,144 164,154 159,166");//SEGUNDA RAYA SUPERIOR
        
        gc.appendSVGPath("M153,206 C153,206 157,201 164,195"
                + "C164,195 171,192 180,191"
                + "C180,191 188,192 200,200"
                + "C200,200 207,207 207,207"
                + "C207,207 203,198 197,191"
                + "C197,191 184,181 176,178"
                + "C176,178 169,177 161,181"
                + "C161,181 152,194 153,206");//TERCER RAYA SUPERIOR IZQUIERDA
        
        gc.appendSVGPath("M378,182 C378,182 366,174 357,167"
                + "C357,167 347,161 335,154"
                + "C335,154 316,148 305,148"
                + "C305,148 291,151 279,157"
                + "C279,157 268,166 258,183"
                + "C258,183 251,202 251,202"
                + "C251,202 258,191 267,184"
                + "C267,184 282,174 301,171"
                + "C301,171 315,171 339,180"
                + "C339,180 352,186 363,195"
                + "C363,195 371,204 382,209"
                + "C382,209 380,196 378,182");//CUARTA RAYA SUPERIOR DERECHA
        
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //ANTENAS
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M168,148 Q168,144 159,137"
                + "Q159,137 133,129"
                + "Q133,129 108,125"
                + "Q108,125 96,130"
                + "Q96,130 80,146"
                + "Q80,146, 96,130"
                + "Q96,130 108,125"
                + "Q108,125 133,129"
                + "Q133,129 159,137"
                + "Q159,137 168,144");
        gc.appendSVGPath("M80,146 C80,146 72,154 64,176"
                + "C59,202 57,214 55,242"
                + "C55,242 56,252 56,252"
                + "C56,252 65,235 72,201"
                + "C72,201 77,170 79,155");//ANTENA LADO IZQUIERDO
        
        gc.appendSVGPath("M358,141 Q358,141 364,115"
                + "Q364,115 367,94"
                + "Q367,94 385,77"
                + "Q385,77 396,69"
                + "Q396,69 403,78"
                + "Q403,78 411,95"
                + "Q411,95 403,78"
                + "Q403,78 396,69"
                + "Q396,69 385,77"
                + "Q385,77 367,94"
                + "Q367,94 364,115"
                + "Q364,115 358,141");
        gc.appendSVGPath("M411,95 C411,95 410,102 411,119"
                + "C411,119 413,142 422,185"
                + "C422,185 428,205 428,205"
                + "C428,205 428,181 426,156"
                + "C426,156 419,118 415,102");//ANTENA LADO DERECHO
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CUERPO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(229, 166, 29));
        gc.beginPath();
        gc.appendSVGPath("M266,343 C266,343 263,349 264,355"
                + "C264,355 262,363 261,368"
                + "C261,368 260,373 262,378"
                + "C262,378 266,384 272,395"
                + "C272,395 280,404 290,412"
                + "C290,412 293,410 293,410"
                + "C293,410 295,415 299,417"
                + "C299,417 307,417 316,407"
                + "C316,407 321,394 320,378"
                + "C320,378 323,357 319,347"
                + "C319,347 315,338 305,334"
                + "C305,334 290,338 277,341");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M264,349 C264,349 256,351 244,355"
                + "C244,355 229,356 215,359"
                + "C215,359 205,368 211,373"
                + "C211,373 230,372 244,376"
                + "C244,376 254,376 260,373"
                + "C260,373 261,363 264,349");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //BRAZO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M322,357 C322,357 331,355 337,353"
                + "C337,353 340,345 334,342"
                + "C334,342 342,340 316,342"
                + "C316,342 320,347 322,351"
                + "Q322,351 322,357");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //CUERPO INFERIOR
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(229, 166, 29));
        gc.beginPath();
        gc.appendSVGPath("M295,414 C295,414 297,420 307,426"
                + "C307,426 316,426 320,418"
                + "C320,418 322,415 322,415"
                + "C322,415 324,418 329,421"
                + "C329,421 340,413 343,400"
                + "C343,400 342,390 333,376"
                + "C333,376 324,368 322,368"
                + "C322,368 320,378 321,385"
                + "C321,385 321,395 316,407"
                + "C316,407 309,416 302,418"
                + "C302,418 298,417 295,414");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PIE VISIBLE
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M337,415 C337,415 341,421 339,426"
                + "C339,426 343,433 350,426"
                + "C350,426 349,415 341,407"
                + "C341,407 340,412 337,415");
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

