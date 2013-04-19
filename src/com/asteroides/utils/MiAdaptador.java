package com.asteroides.utils;

import java.util.Vector;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.asteroides.ui.R;

public class MiAdaptador extends BaseAdapter {
	private final Activity actividad;
	private final Vector<String> lista;

	public MiAdaptador(Activity actividad, Vector<String> lista) {
		super();
		this.actividad=actividad;
		this.lista=lista;
	}

	@Override
	public int getCount() {
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		return lista.elementAt(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.elemento_lista, null,true);
		
		TextView titulo = (TextView)view.findViewById(R.id.tvTitulo);
		titulo.setText(lista.elementAt(position));
		
		ImageView icono = (ImageView)view.findViewById(R.id.ivIcono);
		switch (Math.round((float)Math.random()*3)){
		case 0:
			icono.setImageResource(R.drawable.asteroide1);
			break;
		case 1:
			icono.setImageResource(R.drawable.asteroide2);
			break;
		default:
			icono.setImageResource(R.drawable.asteroide3);
			break;
		}
		return view;
	}

}
