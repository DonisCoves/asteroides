package com.asteroides.ui;

import java.util.Vector;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.asteroides.utils.MiAdaptador;

public class PuntuacionesActivity extends ListActivity {
	private Vector<String> puntuaciones;
	private MiAdaptador adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);

		
		puntuaciones = MainActivity.almacen.listaPuntuaciones(10);
		adaptador=new MiAdaptador(this, puntuaciones);
//		puntuaciones=new Vector<String>(); para comprobar que funciona cuando no hay valores
//		adaptador = new ArrayAdapter<String>(this, R.layout.elemento_lista,R.id.tvTitulo, puntuaciones);
		setListAdapter(adaptador);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
//		ViewGroup layout =(ViewGroup)v; 
//		String layoutStr,tituloStr,subTituloStr;
//		TextView titulo, subTitulo;
//		titulo = (TextView) layout.findViewById(R.id.tvTitulo);
//		subTitulo = (TextView) layout.findViewById(R.id.tvSubtitulo);
//		tituloStr=titulo.getText().toString();
//		subTituloStr=subTitulo.getText().toString();
//		String cad="Titulo="+tituloStr+" Subtitulo="+subTituloStr;
		Object o = getListAdapter().getItem(position);
		String cad = "Selección: "+Integer.toString(position)+" - "+o.toString();
		Toast.makeText(this, cad, Toast.LENGTH_LONG).show();
	}
}
