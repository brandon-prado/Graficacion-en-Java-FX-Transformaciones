package Ladybug;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Dibujo del personaje Tikki con transformaciones.
 * 
 * @author Brandon Alexis Prado Castro (19051178)
 * @version 3.0. 27.09.2021
 */
public class TikkiTransformaciones extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Crear una caja que contendra el menu de opciones y sera agregado a la ventana
        //principal por medio del rootSecundario
        HBox menuGlobal = new HBox();
        /* CREACIÓN DE LA VENTANA Y DE LOS CONTENEDORES PRINCIPALES */
        // Contenedor principal donde se alojarán todos los elementos
        Group root = new Group();
        //Se crea otro contenedor donde se llama al contenedor principal y a su vez el menuGlobal
        //para que las transformaciones no afecten al menu
        Group rootSecundario = new Group(root, menuGlobal);
        //Creación de una zona de dibujo (canvas) de 500 x 500 puntos
        Canvas canvas = new Canvas(500, 500);
        //Obtención del contexto gráfico del canvas anterior que permitirá realizar posteriormente los dibujos
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Se añade el canvas al contenedor principal (root)
        root.getChildren().add(canvas);
        //Creación del área (scene) correspondiente al contenido que tendrá la ventana, de 500 x 500 puntos, con color dado en rgb, indicando que el
        //elemento rootSecundario va a ser el contenedor principal de este espacio
        Scene scene = new Scene(rootSecundario, 500, 500, Color.rgb(129, 112, 193));
        //Se asocia la ventana (scene) al parámetro primaryStage (escenario
        //principal). El parámetro primaryStage se recibe en este método start
        primaryStage.setScene(scene);
        //Título que se aparecerá en la ventana
        primaryStage.setTitle("Tikki Transformaciones");
        //Orden para que se muestre la ventana
        primaryStage.show();
        
        //Crear barra de menú
        MenuBar menuBar = new MenuBar();
        Menu menuPrincipal = new Menu("Menu transformaciones");
        //Agregar a la parte superior
        menuBar.getMenus().addAll(menuPrincipal);
        //Creacion de opciones de menu
        MenuItem mRotar = new MenuItem("Rotar");
        MenuItem mEscalar = new MenuItem("Escalar");
        MenuItem mTrasladar = new MenuItem("Trasladar eje X");
        MenuItem mSesgar = new MenuItem("Sesgar");
        MenuItem mSalir = new MenuItem("Salir");
        //Agrega los elementos al menu principal
        menuPrincipal.getItems().addAll(mRotar, mEscalar, mTrasladar, mSesgar, mSalir);
        //Se aplica una barra horizontal en la parte superior donde se encuentra el menu principal
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        //Se agregra toda la barra de menuBar a la ventana principal por medio del menuGlobal
        //el cual es llamado por el contenedor secundario
        menuGlobal.getChildren().add(menuBar);
        
        //Acciones de los items
        mRotar.setOnAction(event ->{
            rotar(root); 
        });
        mEscalar.setOnAction(event ->{
            escalar(root);
        });
        mTrasladar.setOnAction(event ->{
            trasladar(root); 
        });
        mSesgar.setOnAction(event ->{
            sesgar(root); 
        });
        mSalir.setOnAction(event ->{
            System.exit(0);
        });
        
        //DIBUJO
        //CABEZA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(187, 10, 66));
        gc.beginPath();
        gc.appendSVGPath("M166,181 Q166,181 167,171"
                + "L167,171 Q167,171 168,163"
                + "L168,163 Q168,163 170,153"
                + "L170,153 Q170,153 175,139"
                + "L175,139 Q175,139 183,125"
                + "L183,125 Q183,125 192,116"
                + "L192,116 Q192,116 200,108"
                + "L200,108 Q200,108 210,101"
                + "L210,101 Q210,101 221,95"
                + "L221,95 Q221,95 230,91"
                + "L230,91 Q230,91 239,89"
                + "L239,89 Q239,89 247,89"
                + "L247,89 Q247,89 256,88"
                + "L256,88 Q256,88 264,88"
                + "L264,88 Q264,88 274,89"
                + "L274,89 Q274,89 281,90"
                + "L281,90 Q281,90 292,93"
                + "L292,93 Q292,93 299,97"
                + "L299,97 Q299,97 307,101"
                + "L307,101 Q307,101 317,107"
                + "L317,107 Q317,107 325,114"
                + "L325,114 Q325,114 333,123"
                + "L333,123 Q333,123 338,131"
                + "L338,131 Q338,131 342,139"
                + "L342,139 Q342,139 346,148"
                + "L346,148 Q346,148 348,155"
                + "L348,155 Q348,155 350,164"
                + "L350,164 Q350,164 350,171"
                + "L350,171 Q350,171 350,180"
                + "L350,180 Q350,171 349,193"
                + "L349,193 Q349,193 346,204"
                + "L346,204 Q346,204 341,216"
                + "L341,216 Q341,216 337,227"
                + "L337,227 Q337,227 334,236"
                + "L334,236 Q334,236 329,249"
                + "L329,249 Q329,249 322,260"
                + "L322,260 Q322,260 315,266"
                + "L307,273 Q307,273 296,278"
                + "L296,278 Q296,278 285,281"
                + "L264,284 Q264,284 251,284"
                + "L251,284 Q251,284 238,284"
                + "L238,284 Q238,284 225,281"
                + "L225,281 Q225,281 211,276"
                + "L211,276 Q211,276 199,269"
                + "L199,269 Q199,269 187,263"
                + "L187,263 Q187,263 176,254"
                + "L176,254 Q176,254 167,244"
                + "L160,236 Q158,229 157,224"
                + "L157,224 Q157,224 158,218"
                + "L161,212 Q161,212 166,203"
                + "L166,203 Q166,203 166,199"
                + "L166,199 Q166,199 166,194"
                + "L166,194 Q166,194 166,188"
                + "L166,188 Q166,188 166,181");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //OJO LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.beginPath();
        gc.appendSVGPath("M174,194 C174,194 175,192 177,189"
                + "C177,189 180,186 183,183"
                + "C183,183 186,181 191,180"
                + "C191,180 195,179 199,179"
                + "C199,179 204,181 207,184"
                + "C207,184 209,188 213,193"
                + "C213,193 215,200 216,205"
                + "C216,205 216,210 216,216"
                + "C216,216 216,222 213,226"
                + "C216,226 207,229 202,230"
                + "C202,230 198,231 191,231"
                + "C191,231 185,230 180,227"
                + "C180,227 177,224 173,219"
                + "C173,219 172,214 172,211"
                + "C172,211 172,206 172,202"
                + "C172,202 173,197 174,194");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLUE);
        gc.beginPath();
        gc.appendSVGPath("M193,183 C193,183 197,181 202,181"
                + "C202,181 205,182 207,185"
                + "C207,185 209,188 210,191"
                + "C210,191 213,195 214,200"
                + "C214,200 215,206 215,210"
                + "C215,210 215,215 213,218"
                + "C213,218 211,221 208,225"
                + "C208,225 204,228 198,230"
                + "C198,230 192,231 188,230"
                + "C188,230 184,226 181,223"
                + "C181,223 179,219 177,214"
                + "C177,214 176,210 176,204"
                + "C176,204 178,201 179,196"
                + "C179,196 181,194 193,183");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA LADO IZQUIERDO
        gc.setLineWidth(2);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(26, 24, 79));
        gc.beginPath();
        gc.appendSVGPath("M186,196 C186,196 188,193 192,190"
                + "C192,190 196,188 200,188"
                + "C200,188 203,189 206,192"
                + "C206,192 208,195 210,200"
                + "C210,200 211,205 210,209"
                + "C210,209 209,214 207,217"
                + "C207,217 204,220 199,223"
                + "C199,223 195,224 191,223"
                + "C191,223 187,220 185,216"
                + "C185,216 184,211 183,205"
                + "C183,205 184,200 186,196");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //REFLEJO EN PUPILA LADO IZQUIERDO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.beginPath();
        gc.appendSVGPath("M184,190 C184,190 184,191 182,196"
                + "C182,196 181,199 178,199"
                + "C178,199 178,196 179,192"
                + "C179,192 181,190 184,190");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑA OJO LADO IZQUIERDO
        gc.setLineWidth(3.0);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M172,197 Q172,197 170,195");
        gc.appendSVGPath("M174,193 Q174,193 168,187");
        gc.appendSVGPath("M181,184 Q181,184 175,177");
        gc.appendSVGPath("M187,181 Q187,181 185,178");
        gc.closePath();
        gc.stroke();
        
        //OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.beginPath();
        gc.appendSVGPath("M254,231 C254,231 254,228 254,225"
                + "C254,225 255,220 256,217"
                + "C256,217 258,212 261,206"
                + "C261,206 267,199 273,193"
                + "C273,193 279,190 284,188"
                + "C284,188 292,188 298,190"
                + "C298,190 303,193 309,197"
                + "C309,197 312,201 314,207"
                + "C314,207 316,213 316,221"
                + "C316,221 315,226 311,231"
                + "C311,231 307,235 300,240"
                + "C300,240 292,242 284,243"
                + "C284,243 278,242 272,241,"
                + "C272,241 267,239 262,237"
                + "C262,237 255,234 254,231");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //IRIS LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.BLUE);
        gc.beginPath();
        gc.appendSVGPath("M280,192 C280,192 284,193 289,195"
                + "C289,195 295,198 298,202"
                + "C298,202 301,207 303,211"
                + "C303,211 303,217 302,223"
                + "C302,223 300,229 296,235"
                + "C296,235 291,240 285,241"
                + "C285,241 278,242 273,241"
                + "C273,241 267,239 261,237"
                + "C261,237 257,232 255,226"
                + "C255,226 255,220 258,213"
                + "C258,213 261,206 267,199"
                + "C267,199 273,195 276,193"
                + "C276,193 280,192 280,192");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PUPILA LADO DERECHO
        gc.setLineWidth(2);
        gc.setFill(Color.BLACK);
        gc.setFill(Color.rgb(26, 24, 79));
        gc.beginPath();
        gc.appendSVGPath("M273,201 C273,201 279,199 285,201"
                + "C285,201 289,205 292,210"
                + "C292,210 293,216 293,222"
                + "C293,222 293,226 291,232"
                + "C291,232 286,235 280,237"
                + "C280,237 274,236 268,233"
                + "C268,233 264,228 262,222"
                + "C262,222 262,216 263,211"
                + "C263,211 267,204 273,201");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //REFLEJO EN OJO LADO DERECHO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.beginPath();
        gc.appendSVGPath("M288,205 C288,205 290,204 292,203"
                + "C292,203 296,203 298,206"
                + "C298,206 300,210 300,217"
                + "C300,217 297,221 293,221"
                + "C293,221 290,218 287,214"
                + "C287,214 287,209 288,205");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //PESTAÑAS OJO LADO DERECHO
        gc.setLineWidth(3.0);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M300,190 Q300,190 304,187");
        gc.appendSVGPath("M304,193 Q304,193 308,190");
        gc.appendSVGPath("M311,198 Q311,198 321,196");
        gc.appendSVGPath("M316,211 Q316,211 326,209");
        gc.appendSVGPath("M317,217 Q317,217 322,216");
        gc.closePath();
        gc.stroke();
        
        //BOCA
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M213,248 Q213,248 217,252");
        gc.appendSVGPath("M217,252 Q217,252 224,257");
        gc.appendSVGPath("M224,257 Q224,257 233,258");
        gc.appendSVGPath("M233,258 Q233,258 241,258");
        gc.appendSVGPath("M241,258 Q241,258 248,255");
        gc.closePath();
        gc.stroke();
        
        //MANCHA SUPERIOR
        gc.setLineWidth(1.0);
        gc.setFill(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M223,102 C223,102 228,99 236,95"
                + "C236,95 246,92 256,92"
                + "C256,92 268,93 277,96"
                + "C277,96 286,102 292,107"
                + "C292,107 297,112 299,120"
                + "C299,120 296,129 291,136"
                + "C291,136 282,143 272,148"
                + "C272,148 261,150 251,151"
                + "C251,151 241,151 231,147"
                + "C231,147 225,143 219,138"
                + "C219,138 214,131 210,123"
                + "C210,123 210,116 213,111"
                + "C213,111 218,106 223,102");
        gc.closePath();
        gc.fill();
        
        //CONTRONO DEL CUERPO
        gc.setLineWidth(1.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(187, 10, 66));
        gc.beginPath();
        gc.appendSVGPath("M231,281 C231,281 231,284 231,285"
                + "C231,285 228,285 222,285"
                + "C222,285 219,287 214,295"
                + "C214,295 211,302 209,309"
                + "C209,309 207,314 208,318"
                + "C208,318 215,319 218,319"//AQUI EMPIEZA LA PARTE DESPUES DEL BRAZO LADO IZQUIERDO
                + "C218,319 220,323 221,329"
                + "C221,329 219,335 216,343"
                + "C216,343 214,350 215,357"
                + "C215,357 218,364 224,367"
                + "C224,367 227,366 227,369"
                + "C227,369 224,374 221,386"
                + "C221,386 222,392 224,399"
                + "C224,399 231,408 235,409"
                + "C235,409 238,408 238,400"
                + "C238,400 238,391 237,382"
                + "C237,382 236,380 236,375"
                + "C236,375 236,361 233,357"
                + "C233,357 237,351 241,349"
                + "C241,349 242,350 242,357"
                + "C242,357 243,362 248,365"
                + "C248,365 248,371 246,376"
                + "C246,376 245,384 245,396"
                + "C245,396 248,402 256,401"
                + "C256,401 261,392 261,378"
                + "C261,378 261,364 259,361"
                + "C259,361 260,357 263,346"
                + "C263,346 263,336 259,328"
                + "C259,328 258,324 259,322"//AQUI EMPIEZA EL BRAZO LADO DERECHO
                + "C259,322 264,319 266,316"
                + "C266,316 264,310 262,305"
                + "C262,305 258,297 256,293"
                + "C256,293 253,290 250,289"
                + "C250,289 246,288 246,286"
                + "C246,286 246,283 245,283"
                + "C245,283 238,283 231,281");
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //MANO LADO DERECHO
        gc.setLineWidth(1.0);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(187, 10, 66));
        gc.beginPath();
        gc.appendSVGPath("M218,319 Q218,319 226,312"
                + "Q226,312 229,302 Q229,302 225,300"
                + "Q225,300 219,303 Q219,303 225,300"
                + "Q225,300 229,302"
                + "Q229,302 226,312 Q226,312 218,319");
        gc.closePath();
        gc.stroke();  
        
        //MANO LADO IZQUIERDO
        gc.setLineWidth(1.0);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.appendSVGPath("M259,322 Q259,322 254,320"
                + "Q254,320 247,316 Q247,316 242,311"
                + "Q242,311 243,304 Q243,304 247,302"
                + "Q247,302 251,305 Q251,305 255,308"
                + "Q255,308 251,305 Q251,305 247,302"
                + "Q247,302 243,304 Q243,304 242,311"
                + "Q242,311 247,316 Q247,316 254,320");
        gc.closePath();
        gc.stroke();
        
        //ANTENAS
        gc.setLineWidth(0.5);
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.rgb(187, 10, 66));
        gc.beginPath();
        gc.appendSVGPath("M166,172 C166,172 163,175 155,189"
                + "C155,189 151,200 145,217"
                + "C141,229 138,245 139,273 "
                + "C139,273 140,300 141,314"
                + "C141,314 145,313 144,302"
                + "C144,302 144,246 144,242"
                + "C144,242 147,223 155,197"
                + "C155,197 161,184 166,172");//ANTENA LADO IZQUIERDO
        gc.appendSVGPath("M349,161 C349,161 366,178 386,216"
                + "C386,216 396,266 394,306"
                + "C394,306 378,362 374,358"
                + "C374,358 389,312 393,262"
                + "C393,262 384,218 360,175"
                + "C360,175 353,166, 349,161");//ANTENA LADO IZQUIERDO
        gc.closePath();
        gc.fill();
        gc.stroke();
        
        //DETALLES
        gc.setLineWidth(1.0);
        gc.setStroke(Color.BLACK);;
        gc.beginPath();
        gc.appendSVGPath("M224,294 Q224,294 223,298");//BRAZO LADO IZQUIERDO
        gc.appendSVGPath("M248,295 Q248,295 248,300");//BRAZO LADO DERECHO
        gc.appendSVGPath("M223,342 Q223,342 230,348");//PIERNA LADO IZQUIERDO
        gc.appendSVGPath("M247,346 Q247,346 255,339");//PIERNA LADO DERECHO
        gc.appendSVGPath("M230,365 Q230,365 232,363");//RODILLA LADO IZQUIERDO
        gc.appendSVGPath("M252,367 Q252,367 257,364");//RODILLA LADO DERECHO
        gc.closePath();
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