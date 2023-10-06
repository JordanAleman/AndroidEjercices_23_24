package com.jordan.t10listview;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lblEtiqueta;
    private ListView lstOpciones;
    private ListView lstOpciones2;

    private Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    new Titular("Título 5", "Subtítulo largo 5"),
                    new Titular("Título 6", "Subtítulo largo 6"),
                    new Titular("Título 7", "Subtítulo largo 7"),
                    new Titular("Título 8", "Subtítulo largo 8"),
                    new Titular("Título 9", "Subtítulo largo 9"),
                    new Titular("Título 10", "Subtítulo largo 10"),
                    new Titular("Título 11", "Subtítulo largo 11"),
                    new Titular("Título 12", "Subtítulo largo 12"),
                    new Titular("Título 13", "Subtítulo largo 13"),
                    new Titular("Título 14", "Subtítulo largo 14"),
                    new Titular("Título 15", "Subtítulo largo 15")};

    private Titular[] datos2 = {new Titular("Prueba 1", "Subprueba 1"),
            new Titular("Prueba 2", "Subprueba 2")};

    private int posicionSeleccionada = -1; // Inicialmente ninguna vista está seleccionada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*//Ejemplo básico
        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);

        lstOpciones = findViewById(R.id.LstOpciones);

        lstOpciones.setAdapter(adaptador);*/

        lblEtiqueta = findViewById(R.id.LblEtiqueta);
        lstOpciones = findViewById(R.id.LstOpciones);


        //Cabecera
        View header = getLayoutInflater().inflate(R.layout.list_header, null);
        lstOpciones.addHeaderView(header);

        //Adaptador
        AdaptadorTitulares adaptador =
                new AdaptadorTitulares(this, datos);

        lstOpciones.setAdapter(adaptador);


        //Eventos
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                if (lblEtiqueta.getVisibility() == View.GONE)
                    lblEtiqueta.setVisibility(View.VISIBLE);

                // Cambia el color de fondo de la vista seleccionada previamente a amarillo
                if (posicionSeleccionada != -1) {
                    View prevSeleccionada = lstOpciones.getChildAt(posicionSeleccionada);
                    prevSeleccionada.setBackgroundColor(Color.parseColor("#FFE896"));
                }

                // Cambia el color de fondo de la vista seleccionada a rojo
                v.setBackgroundColor(Color.parseColor("#FF0000"));

                // Actualiza la posición seleccionada
                posicionSeleccionada = position;

                //Alternativa 1:
                try { //por si pinchamos en la cabecera, que da excepcion
                    String opcionSeleccionada = ((Titular) a.getItemAtPosition(position)).getTitulo();
                    lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);


//                    v.setBackgroundColor(Color.parseColor("#BA3620"));

//                    LinearLayout linearLayoutList = v.findViewById(R.id.LinearLayoutList);
//                    linearLayoutList.setBackgroundColor(Color.parseColor("#BA3620"));

//

                } catch (Exception e) {
                    lblEtiqueta.setVisibility(View.GONE);
                }

                //Alternativa 2:
                /*try {
                    String opcionSeleccionada =
                            (v.findViewById(R.id.LblTitulo))
                                    .getText().toString();

                    lblEtiqueta.setText("Opción seleccionada: " + opcionSeleccionada);
                }
                catch(Exception e){}*/
            }
        });

        lstOpciones2 = findViewById(R.id.LstOpciones2);

        //    Cabecera2
        View header2 = getLayoutInflater().inflate(R.layout.list2_header, null);
        lstOpciones2.addHeaderView(header2);

        //Adaptador2
        AdaptadorTitulares2 adaptador2 =
                new AdaptadorTitulares2(this, datos2);

        lstOpciones2.setAdapter(adaptador2);


    }


    class AdaptadorTitulares extends ArrayAdapter<Titular> {

        Drawable[] img = {getContext().getDrawable(R.drawable.baseline_beach_access_24),
                getContext().getDrawable(R.drawable.baseline_bed_24),
                getContext().getDrawable(R.drawable.baseline_bedtime_24),
                getContext().getDrawable(R.drawable.baseline_blender_24),
                getContext().getDrawable(R.drawable.baseline_brush_24)};

        public AdaptadorTitulares(Context context, Titular[] datos) {
            super(context, R.layout.listitem_titular, datos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            item.setBackgroundColor(Color.parseColor("#FFE896"));

            TextView lblTitulo = item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos[position].getTitulo());
            lblTitulo.setCompoundDrawablesWithIntrinsicBounds(img[position % 5], null, null, null);

            TextView lblSubtitulo = item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos[position].getSubtitulo());

            return (item);
        }
    }

    class AdaptadorTitulares2 extends ArrayAdapter<Titular> {

        public AdaptadorTitulares2(Context context, Titular[] datos2) {
            super(context, R.layout.listitem_titular, datos2);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = item.findViewById(R.id.LblTitulo);
            lblTitulo.setText(datos2[position].getTitulo());

            TextView lblSubtitulo = item.findViewById(R.id.LblSubTitulo);
            lblSubtitulo.setText(datos2[position].getSubtitulo());

            return (item);
        }
    }
}
